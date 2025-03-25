package entity.Employee;

public record CreateEmployeeRequest(String firstName, String lastName, String middleName, int companyId,
                                    String email, String url, String phone, String birthdate) {

    public CreateEmployeeRequest changeFieldFirstName(){
        return new CreateEmployeeRequest("", this.lastName, this.middleName, this.companyId, this.email, this.url,
                this.phone, this.birthdate);
    }
}
