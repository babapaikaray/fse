package com.baba.test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import com.baba.Application;
import com.baba.persistence.dao.UserRepository;
import com.baba.persistence.model.User;
import com.baba.spring.TestDbConfig;
import com.baba.spring.TestIntegrationConfig;
import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class, TestDbConfig.class, TestIntegrationConfig.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ChangePasswordIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${local.server.port}")
    int port;

    private FormAuthConfig formConfig;
    private String URL;

    //

    @Before
    public void init() {
        User user = userRepository.findByEmail("test@test.com");
        if (user == null) {
            user = new User();
            user.setFirstName("Test");
            user.setLastName("Test");
            user.setPassword(passwordEncoder.encode("test"));
            user.setEmail("test@test.com");
            user.setEnabled(true);
            userRepository.save(user);
        } else {
            user.setPassword(passwordEncoder.encode("test"));
            userRepository.save(user);
        }

        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
        URL = "/user/updatePassword";
        formConfig = new FormAuthConfig("/login", "username", "password");
    }

    @Test
    public void givenNotAuthenticatedUser_whenLoggingIn_thenCorrect() {
        final RequestSpecification request = RestAssured.given().auth().form("test@test.com", "test", formConfig);

        request.when().get("/console.html").then().assertThat().statusCode(200).and().body(containsString("home"));
    }

    @Test
    public void givenNotAuthenticatedUser_whenBadPasswordLoggingIn_thenCorrect() {
        final RequestSpecification request = RestAssured.given().auth().form("XXXXXXXX@XXXXXXXXX.com", "XXXXXXXX", formConfig).redirects().follow(false);

        request.when().get("/console.html").then().statusCode(IsNot.not(200)).body(isEmptyOrNullString());
    }

    @Test
    public void givenLoggedInUser_whenChangingPassword_thenCorrect() {
        final RequestSpecification request = RestAssured.given().auth().form("test@test.com", "test", formConfig);

        final Map<String, String> params = new HashMap<String, String>();
        params.put("oldPassword", "test");
        params.put("newPassword", "newTest&12");

        final Response response = request.with().queryParams(params).post(URL);

        assertEquals(200, response.statusCode());
        assertTrue(response.body().asString().contains("Password updated successfully"));
    }

    @Test
    public void givenWrongOldPassword_whenChangingPassword_thenBadRequest() {
        final RequestSpecification request = RestAssured.given().auth().form("test@test.com", "test", formConfig);

        final Map<String, String> params = new HashMap<String, String>();
        params.put("oldPassword", "abc");
        params.put("newPassword", "newTest&12");

        final Response response = request.with().queryParams(params).post(URL);

        assertEquals(400, response.statusCode());
        assertTrue(response.body().asString().contains("Invalid Old Password"));
    }

    @Test
    public void givenNotAuthenticatedUser_whenChangingPassword_thenRedirect() {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("oldPassword", "abc");
        params.put("newPassword", "xyz");

        final Response response = RestAssured.with().params(params).post(URL);

        assertEquals(302, response.statusCode());
        assertFalse(response.body().asString().contains("Password updated successfully"));
    }

}
