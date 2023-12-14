import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import typicode.response_models.UserResponseModel;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiChallenge {

    public String baseURL = "https://jsonplaceholder.typicode.com/";
    /**
     * Using the following Reset Server https://jsonplaceholder.typicode.com
     * You are expected to deserialize the response data
     */


    /**
     * Using the /users/n endpoint get the 5th user from typicode
     */
    @Test
    public void Get5thUser()
    {
        when().
                get(baseURL + "users/5").
                then().
                statusCode(200).
                body("id", equalTo(5)).
                body("name", equalTo("Chelsey Dietrich"))
        ;
    }

    /**
     * Retrieve all the users from the /users endpoint and store them in a list
     */
    @Test
    public void GetAllUsers()
    {
        var response =
        when().
                get(baseURL + "users").
                then().
                statusCode(200).
        extract().
                response();

        String responseJson = response.asString();
        List<UserResponseModel> responseModel = null;

        try
        {
            responseModel = new ObjectMapper().readValue(responseJson, new TypeReference<List<UserResponseModel>>(){});
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Assertions.assertTrue(responseModel!=null && responseModel != null && responseModel.size() > 0);
    }

    /**
     * Retrieve all the users from the /users endpoint, then find a user with the following street address
     * Dayna Park
     */
    @Test
    public void GetAllUsersAndRefine()
    {
        var response =
                when().
                        get(baseURL + "users").
                        then().
                        statusCode(200).
                        extract().
                        response();

        String responseJson = response.asString();
        List<UserResponseModel> responseModel = null;

        try
        {
            responseModel = new ObjectMapper().readValue(responseJson, new TypeReference<List<UserResponseModel>>(){});
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Assertions.assertTrue(responseModel!=null && responseModel != null && responseModel.size() > 0);

        UserResponseModel user = responseModel.stream().filter(x-> x.getAddress().getStreet().equals("Dayna Park")).toList().get(0);
        Assertions.assertTrue(user!=null && user.getAddress().getStreet().equals("Dayna Park"));
    }
}
