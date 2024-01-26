package health.tracking.backend.model.request;

public record AuthRequest (
        String username,
        String password
){
}