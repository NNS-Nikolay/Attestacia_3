package helpers;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingInterceptor implements Filter {

    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx){

        Response response = ctx.next(requestSpec, responseSpec);

        System.out.println("----------------------------------");
        System.out.println("REQUEST_ENDPOINT: "  + requestSpec.getURI());
        System.out.println("REQUEST_METHOD: "  + requestSpec.getMethod());
        System.out.println("REQUEST_BODY: "  + requestSpec.getBody());
        System.out.println("RESPONSE_CODE: " + response.getStatusCode());
        System.out.println("RESPONSE_BODY: " + response.getBody().asString());
        System.out.println("----------------------------------");
        
        return response;

    }

}
