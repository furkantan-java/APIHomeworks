package hw2;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GitHubAPI {

   @BeforeAll
    public void beforeAll() {
       baseURI = "https://api.github.com";
   }

//    GitHub API testing
//    In this assignment, you will test GitHub API. Full documentation for GitHub API can be found here:
//    https://developer.github.com/v3/.
//    Automate the given test cases written based on couple of the endpoints from the GitHub API. You can
//    use any existing project. You can automate all test cases in same class or different classes.
//    Base Path: https://api.github.com
//    TEST CASES
//    Verify organization information
//1. Send a get request to /orgs/:org. Request includes :
//            • Path param org with value cucumber
//2. Verify status code 200, content type application/json; charset=utf-8
//            3. Verify value of the login field is cucumber
//4. Verify value of the name field is cucumber
//5. Verify value of the id field is 320565
//    Verify error message
//1. Send a get request to /orgs/:org. Request includes :
//            • Header Accept with value application/xml
//• Path param org with value cucumber
//2. Verify status code 415, content type application/json; charset=utf-8
//            3. Verify response status line include message Unsupported Media Type
//    Number of repositories
//1. Send a get request to /orgs/:org. Request includes :
//            • Path param org with value cucumber
//2. Grab the value of the field public_repos
//3. Send a get request to /orgs/:org/repos. Request includes :
//            • Path param org with value cucumber
//4. Verify that number of objects in the response is equal to value from step 2
//    Repository id information
//1. Send a get request to /orgs/:org/repos. Request includes :
//            • Path param org with value cucumber
//2. Verify that id field is unique in every in every object in the response
//3. Verify that node_id field is unique in every in every object in the response
//    Repository owner information
//1. Send a get request to /orgs/:org. Request includes :
//            • Path param org with value cucumber
//2. Grab the value of the field id
//3. Send a get request to /orgs/:org/repos. Request includes :
//            • Path param org with value cucumber
//4. Verify that value of the id inside the owner object in every response is equal to value from step 2
//    Ascending order by full_name sort
//1. Send a get request to /orgs/:org/repos. Request includes :
//            • Path param org with value cucumber
//• Query param sort with value full_name
//2. Verify that all repositories are listed in alphabetical order based on the value of the field name
//    Descending order by full_name sort
//1. Send a get request to /orgs/:org/repos. Request includes :
//            • Path param org with value cucumber
//• Query param sort with value full_name
//• Query param direction with value desc
//2. Verify that all repositories are listed in reverser alphabetical order based on the value of the field
//            name
//    Default sort
//1. Send a get request to /orgs/:org/repos. Request includes :
//            • Path param org with value cucumber
//2. Verify that by default all repositories are listed in descending order based on the value of the field
//    created_at
}
