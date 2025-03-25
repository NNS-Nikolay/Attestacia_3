package entity.Employee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EmployeeResponse(int id, String firstName, String lastName, String middleName, int companyId, String email,
                               String avatar_url, String phone, String birthdate, Boolean isActive) {
}
