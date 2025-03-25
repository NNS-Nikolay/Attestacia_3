package entity.Employee;

public record EmployeeDB(int id, Boolean is_active, String create_timestamp, String change_timestamp,
                         String first_name, String last_name, String middle_name, String phone, String email,
                         String birthdate, String avatar_url, int company_id) {
}
