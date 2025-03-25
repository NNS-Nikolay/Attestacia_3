package db;

import entity.Employee.CreateEmployeeRequest;
import entity.Employee.EmployeeDB;

import java.io.IOException;
import java.sql.SQLException;

public interface EmployeeRepository {

    int createEmployee(CreateEmployeeRequest createEmployeeRequest) throws SQLException, IOException;

    void deleteEmployee (int employeeId) throws SQLException;

    EmployeeDB getEmployeeInfo (int employeeId) throws SQLException;
}
