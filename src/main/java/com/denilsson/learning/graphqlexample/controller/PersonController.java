package com.denilsson.learning.graphqlexample.controller;

import com.denilsson.learning.graphqlexample.model.Person;
import com.denilsson.learning.graphqlexample.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @QueryMapping
    public Person personById(@Argument Integer id){
        return personService.getPersonByID(id);
    }
}
