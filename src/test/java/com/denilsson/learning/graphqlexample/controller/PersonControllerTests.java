package com.denilsson.learning.graphqlexample.controller;


import com.denilsson.learning.graphqlexample.model.Person;
import com.denilsson.learning.graphqlexample.service.PersonService;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.equalTo;


@GraphQlTest
public class PersonControllerTests {

    @Autowired
    private GraphQlTester graphQlTester;
    @MockBean
    private PersonService personService;
    private Person person;
    static final int PERSON_ID  = 1;
    static final String PERSON_NAME  = "Denilsson";
    static final String PERSON_LASTNAME  = "Montoya";
    static final String PERSON_GENDER  = "M";

    @BeforeEach
    void setUp() {
        person = Person.builder()
                .id(PERSON_ID)
                .name(PERSON_NAME)
                .lastName(PERSON_LASTNAME)
                .gender(PERSON_GENDER)
                .build();
    }

    @Test
    public void testPersonByIdSuccessful(){
        given(personService.getPersonByID(eq(PERSON_ID))).willReturn(person);
        String personName = this.graphQlTester.documentName("schema-person-test")
                .execute().path("personById")
                .entity(Person.class)
                .get().getName();

        MatcherAssert.assertThat(personName,equalTo(PERSON_NAME));
    }

    @Test
    public void testPersonByIdNotExistsGender(){
        given(personService.getPersonByID(eq(PERSON_ID))).willReturn(person);

        this.graphQlTester.documentName("schema-person-test")
                .execute()
                .path("personById.gender")
                .pathDoesNotExist();
    }

}
