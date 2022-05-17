package com.maria.ejercicio.controller;

import com.maria.ejercicio.model.User;
import com.maria.ejercicio.model.UserDocu;
import com.maria.ejercicio.repository.UserRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserE2ETest {

    @Autowired
    private UserRepo userRepository;

    @Autowired 
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;


    @Test
    public void UserTest(){
        Iterable<User> users = userRepository.findAll();

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/users";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<User>> result = testRestTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<User>>(){}
        );


        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(users);


    }

    @Autowired 
    private JdbcTemplate template;

    @Test
    public void UserJoinTest(){
        String query = "SELECT * FROM USERS INNER JOIN DOCUMENTS ON USERS.USER_ID = DOCUMENTS.USER_ID";

        Iterable<UserDocu> joins = template.query(
            query,
            (data,rowNum) -> {
                return new UserDocu(
                    data.getLong("USERS.USER_ID"),
                    data.getString("USERS.USER"),
                    data.getString("USERS.COMMENT"),
                    data.getLong("DOCUMENTS.DOC_ID"),
                    data.getString("DOCUMENTS.DOC")
                );
            }
        );

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/users/docs";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<UserDocu>> result = testRestTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<UserDocu>>(){}
        );


        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(joins);


    }



    
}
