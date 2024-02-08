package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.*;
import health.tracking.backend.model.entity.Doctor;
import health.tracking.backend.model.entity.DrugUsage;
import health.tracking.backend.model.entity.Patient;
import health.tracking.backend.model.entity.Prescription;
import health.tracking.backend.model.request.CreateDrugUsageRequest;
import health.tracking.backend.model.request.CreatePrescriptionRequest;
import health.tracking.backend.model.request.UpdatePrescriptionRequest;
import health.tracking.backend.model.response.GetDrugUsageResponse;
import health.tracking.backend.model.response.GetPrescriptionResponse;
import health.tracking.backend.repository.PrescriptionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final DrugService drugService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final DrugUsageService drugUsageService;

    @Override
    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @Override
    @Transactional
    public String createPrescription(CreatePrescriptionRequest request) {
        Doctor doctor = doctorService.getByDoctorById(request.getDoctorId());
        Patient patient = patientService.getByPatientById(request.getPatientId());
        Prescription prescription = Prescription.builder()
                .doctor(doctor)
                .patient(patient)
                .instructions(request.getInstructions())
                .prescriptionDate(request.getPrescriptionDate())
                .expiryDate(request.getExpiryDate())
                .drugUsages(new ArrayList<>())
                .build();
        for (CreateDrugUsageRequest drugUsageRequest : request.getDrugUsages()) {
            DrugUsage drugUsage = DrugUsage.builder()
                    .drug(drugService.getByDrugById(drugUsageRequest.getDrugId()))
                    .dosage(drugUsageRequest.getDosage())
                    .prescription(prescription)
                    .build();
            prescription.getDrugUsages().add(drugUsage);
        }
        prescriptionRepository.save(prescription);  // Save entity
        return "Prescription created successfully";  // Return response
    }

    @Override
    public GetPrescriptionResponse getPrescription(Long id) {
        Prescription prescription = this.getPrescriptionById(id);
        List<GetDrugUsageResponse> drugUsagesResponse = new ArrayList<>();
        for (DrugUsage drugUsage : prescription.getDrugUsages()) {
            GetDrugUsageResponse drugUsageResponse = GetDrugUsageResponse.builder()
                    .drug(drugService.getDrug(drugUsage.getDrug().getId()))
                    .dosage(drugUsage.getDosage())
                    .frequency(drugUsage.getFrequency())
                    .build();
            drugUsagesResponse.add(drugUsageResponse);
        }
        return GetPrescriptionResponse.builder()
                .doctor(doctorService.getDoctor(prescription.getDoctor().getId()))
                .patient(patientService.getPatient(prescription.getPatient().getId()))
                .instructions(prescription.getInstructions())
                .prescriptionDate(prescription.getPrescriptionDate())
                .expiryDate(prescription.getExpiryDate())
                .drugUsages(drugUsagesResponse)
                .build();
    }

    @Override
    public String updatePrescription(UpdatePrescriptionRequest request) {
        // Implement update logic
        // Update entity and convert to response
        return "Prescription updated successfully";
    }

    @Override
    public String deletePrescription(Long id) {
        // Implement delete logic
        prescriptionRepository.deleteById(id);
        return "Prescription deleted successfully";
    }
}
