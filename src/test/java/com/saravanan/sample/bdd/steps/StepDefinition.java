package com.saravanan.sample.bdd.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class StepDefinition {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private HttpGet request;
    private HttpResponse httpResponse;

    @Before
    public void setUp() {

    }

    @Given("^we need to test Rest Endpoint$")
    public void initialize() {
        request = new HttpGet("http://dummy.restapiexample.com/api/v1/employee/111169");
    }

    @When("^the rest endpoint is invoked$")
    public void callRestMethod() throws IOException {
        httpResponse = httpClient.execute(request);
    }

    @Then("^the rest endpoint should provide successful response$")
    public void theResultShouldBe() throws IOException {
        String responseString = convertResponseToString(httpResponse);
        assertEquals(responseString, "{\"id\":\"111169\",\"employee_name\":\"I know what you did yesterday, Boy...\",\"employee_salary\":\"50000\",\"employee_age\":\"22\",\"profile_image\":\"\"}");
    }

    private String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }
}