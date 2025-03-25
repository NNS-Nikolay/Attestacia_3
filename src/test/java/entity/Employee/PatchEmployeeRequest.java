package entity.Employee;

public record PatchEmployeeRequest(String lastName, String email, String url, String phone, Boolean isActive) {
}
