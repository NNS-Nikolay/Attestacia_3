package db;

import java.io.IOException;
import java.sql.SQLException;


public interface CompanyRepository {

    int createCompany () throws SQLException, IOException;

    void deleteCompany (int companyId) throws SQLException;

}
