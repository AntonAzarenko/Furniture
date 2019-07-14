package testFunc;

import azarenka.Application;
import azarenka.entity.auth.LoginForm;
import com.fasterxml.jackson.databind.JsonNode;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class WebTest {

    static HttpHeaders headers = new HttpHeaders();
    static HttpEntity<String> entity;
    @Value("${app.admin.username}")
    private String username;

    @Value("${app.admin.password}")
    private String password;

    @LocalServerPort
    private int port;

    protected TestRestTemplate restTemplate = new TestRestTemplate();

    protected Mapper dozerBeanMapper = new DozerBeanMapper();

    @Before
    public void setUpAll() {
        logIn(username, password);
    }

    public String createURL(String uri) {
        return "http://localhost:" + port + uri;
    }

    private void logIn(String username, String pass) {
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername(username);
        loginForm.setPassword(pass);
        HttpEntity<LoginForm> request = new HttpEntity<>(loginForm);
        JsonNode jsonNode = restTemplate.postForObject(createURL("/furniture/auth/signin"),
                request, JsonNode.class);
        String authority = "Bearer " + jsonNode.get("accessToken").asText();
        headers.add("authorization", authority);
        entity = new HttpEntity<>(headers);
    }
}
