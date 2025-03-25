package db;

import helpers.EnvHelper;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class CompanyRepositoryJDBC implements CompanyRepository{

    private final Connection connection;


    public CompanyRepositoryJDBC(Connection connection)  {
        this.connection = connection;
    }

    @Override
    public int createCompany() throws SQLException, IOException {

        EnvHelper envHelper = new EnvHelper();
        Properties properties = envHelper.getConfProperties();

        String TestCompanyName = properties.getProperty("TestCompanyName");
        String TestCompanyDescription = properties.getProperty("TestCompanyDescription");

        String CREATE_COMPANY = "insert into company (name, description) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_COMPANY, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, TestCompanyName);
        preparedStatement.setString(2, TestCompanyDescription);
        preparedStatement.executeUpdate();
        ResultSet result = preparedStatement.getGeneratedKeys();
        result.next();
        return result.getInt("id");
    }


    @Override
    public void deleteCompany(int companyId) throws SQLException  {
        String DEL_COMPANY = "delete from company where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(DEL_COMPANY);
        preparedStatement.setInt(1, companyId);

        preparedStatement.execute();

    }




}















