package ext;


import db.EmployeeRepository;
import db.EmployeeRepositoryJDBC;
import helpers.EnvHelper;
import org.junit.jupiter.api.extension.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class CreateEmployeeRepositoryResolver implements ParameterResolver, BeforeAllCallback,  AfterAllCallback{

    private Connection connection;


    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(EmployeeRepository.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new EmployeeRepositoryJDBC(connection);
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        if (connection != null){
            connection.close();
        }
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {

        EnvHelper envHelper = new EnvHelper();
        Properties properties = envHelper.getConfProperties();

        String connectionString = properties.getProperty("db.connectionString");
        String login = properties.getProperty("db.login");
        String password = properties.getProperty("db.password");

        connection = DriverManager.getConnection(connectionString, login, password);

    }
}
