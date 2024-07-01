package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.*;
import health.tracking.backend.model.entity.Doctor;
import health.tracking.backend.model.entity.DrugUsage;
import health.tracking.backend.model.entity.Patient;
import health.tracking.backend.model.entity.Prescription;
import health.tracking.backend.model.request.CreateDrugUsageRequest;
import health.tracking.backend.model.request.CreatePrescriptionRequest;
import health.tracking.backend.model.request.UpdatePrescriptionRequest;
import health.tracking.backend.repository.PrescriptionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
        return prescriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Prescription with id " + id + " does not exist"));
    }
    @Override
    @Transactional
    public String createPrescription(CreatePrescriptionRequest request, Long doctorId) {
        Doctor doctor = doctorService.getByDoctorById(doctorId);
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
                    .drug(drugService.getDrugById(drugUsageRequest.getDrugId()))
                    .dosage(drugUsageRequest.getDosage())
                    .frequency(drugUsageRequest.getFrequency())
                    .prescription(prescription)
                    .build();
            prescription.getDrugUsages().add(drugUsage);
        }
        prescriptionRepository.save(prescription);  // Save entity
        return "Prescription created successfully";  // Return response
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
