package hw1;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class UINames {




//    UI names API testing
//    In this assignment, you will test api uinames. This is a free api used to create test users. Documentation
//    for this api is available at https://github.com/CybertekSchool/uinames. You can import Postman
//    collection for this API using link: https://www.getpostman.com/collections/c878c63023e6d788da7d
//    Automate the given test cases. You can use any existing project. You can automate all test cases in
//    same class or different classes.

    @BeforeAll
    public static void beforeAll(){
        baseURI = "https://cybertek-ui-names.herokuapp.com/api/";
    }
//    TEST CASES
//    No params test
//1. Send a get request without providing any parameters
//2. Verify status code 200, content type application/json; charset=utf-8
//3. Verify that name, surname, gender, region fields have value

    @Test
    @DisplayName("No params test")
    public void noParams(){
        Response response = when().get().prettyPeek();

        response.then().
                assertThat().
                        statusCode(200).
                and().
                        contentType("application/json; charset=utf-8").
                and().
                        body("name", notNullValue()).
                        body("surname",notNullValue()).
                        body("gender",notNullValue()).
                        body("region",notNullValue());
    }

//    Gender test
//1. Create a request by providing query parameter: gender, male or female
//2. Verify status code 200, content type application/json; charset=utf-8
//3. Verify that value of gender field is same from step 1


    @Test
    @DisplayName("Gender test")
    public void genderTest() {
        Collections.shuffle(genders);//to change order of our list
        String gender = genders.get(0);//because of shuffling our index can change and we can pick random gender
        System.out.println("Sending gender as = " + gender);
        Response response =
                given().
                        queryParams("gender",gender).
                when().
                        get().prettyPeek();

        response.then().
                assertThat().
                        statusCode(200).
                and().
                        contentType("application/json; charset=utf-8").
                and().
                        body("gender",is(gender));

    }

//     2 params test
//1. Create a request by providing query parameters: a valid region and gender
//    NOTE: Available region values are given in the documentation
//2. Verify status code 200, content type application/json; charset=utf-8
//3. Verify that value of gender field is same from step 1
//4. Verify that value of region field is same from step 1

    @Test
    @DisplayName("2 params test")
    public void twoParamsTest() {
        Response response =
                given().
                        queryParams("region","Belgium").
                        queryParams("gender","female").
                when().
                        get().prettyPeek();


        response.then().
                assertThat().
                        statusCode(200).
                and().
                        contentType("application/json; charset=utf-8").
                and().
                        body("gender",is("female")).
                        body("region",is("Belgium"));
    }

//    Invalid gender test
//1. Create a request by providing query parameter: invalid gender
//2. Verify status code 400 and status line contains Bad Request
//3. Verify that value of error field is Invalid gender
    @Test
    @DisplayName("Invalid gender test")
    public void invalidGender() {
        Response response =
                given().
                        queryParams("gender","dog").
                when().
                        get().prettyPeek();

        response.then().
                assertThat().
                        statusCode(400).
                and().
                        statusLine(containsString("Bad Request")).
                and().
                        body("error",is("Invalid gender"));

    }

//    Invalid region test
//1. Create a request by providing query parameter: invalid region
//2. Verify status code 400 and status line contains Bad Request
//3. Verify that value of error field is Region or language not found
    @Test
    @DisplayName("Invalid region test")
    public void invalidRegion() {
        Response response =
                given().
                        queryParams("region","Miami").
                when().
                        get().prettyPeek();

        response.then().
                assertThat().
                        statusCode(400).
                and().
                        statusLine(containsString("Bad Request")).
                and().
                        body("error",is("Region or language not found"));
    }

//    Amount and regions test
//1. Create request by providing query parameters: a valid region and amount (must be bigger than 1)
//2. Verify status code 200, content type application/json; charset=utf-8
//3. Verify that all objects have different name+surname combination
    @Test
    @DisplayName("Amount and regions test")
    public void amountAndRegion() {
        Response response =
                given().
                        queryParams("region","Argentina").
                        queryParams("amount",10).
                when().
                        get().prettyPeek();

        List<User>userList = response.jsonPath().getList("",User.class);
        System.out.println("userList = " + userList);
        Set<String> fullNames = new HashSet<>();

        for (User user:userList) {
            String fullName = user.getName() + " " + user.getSurname();
            fullNames.add(fullName);
        }
        //2nd way
        Set<String> fullNamesV2 = userList.stream().
                                        map(user -> user.getName() + " " + user.getSurname() ).
                                            collect(Collectors.toSet());



        response.then().
                assertThat().
                        statusCode(200).
                and().
                        header("Content-Type","application/json; charset=utf-8").
                and().
                        body("size()",is(fullNames.size()));

    }

//      3 params test
//1. Create a request by providing query parameters: a valid region, gender and amount (must be bigger
//            than 1)
//2. Verify status code 200, content type application/json; charset=utf-8
//3. Verify that all objects the response have the same region and gender passed in step 1

    //nextInt () method from Random class will create numbers between 0-499
    //That's why we add + 1
    //in this case my random number will be between 1-500
    int randomAmount = new Random().nextInt(500) + 1;
    List<String> genders = Arrays.asList("male","female");//We will pick random gender for each execution

    public String generateRandomGender() {
        Collections.shuffle(genders);
        return genders.get(0);
    }
    //getProperty("user.dir") will provide project path: C:\Users\1\Desktop\bugbusters\APIHomeworks
    File namesJson = new File(System.getProperty("user.dir") + File.separator + "names.json");
    JsonPath jsonPath = new JsonPath(namesJson);
    List<String>regions = jsonPath.getList("region");

    public String generateRandomRegion() {
        Collections.shuffle(regions);
        return regions.get(0);
    }

    @Test
    @DisplayName("3 params test")
    public void threeParamsTest() {
        String randomGender = generateRandomGender();
        String randomRegion = generateRandomRegion();

        System.out.println("randomRegion = " + randomRegion);
        System.out.println("randomAmount = " + randomAmount);
        System.out.println("randomGender = " + randomGender);

        Response response =
                given().
                        queryParams("region",randomRegion).
                        queryParams("gender",randomGender).
                        queryParams("amount",randomAmount).
                when().
                        get().prettyPeek();

        response.then().
                assertThat().
                        statusCode(200).
                and().
                        contentType("application/json; charset=utf-8").
                and().
                        body("size()",is(randomAmount)).
                        body("gender",everyItem(is(randomGender))).
                        body("region",everyItem(is(randomRegion)));
    }

//    Amount count test
//1. Create a request by providing query parameter: amount (must be bigger than 1)
//2. Verify status code 200, content type application/json; charset=utf-8
//3. Verify that number of objects returned in the response is same as the amount passed in step 1

    @Test
    @DisplayName("Amount count test")
    public void amountCount() {
        System.out.println("randomAmount = " + randomAmount);
        Response response =
                given().
                        queryParams("amount",randomAmount).
                when().
                        get().prettyPeek();

        response.then().
                assertThat().
                        statusCode(200).
                and().
                        contentType("application/json; charset=utf-8").
                and().
                        body("size()",is(randomAmount));
    }
}
