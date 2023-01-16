package com.denilsson.learning.graphqlexample.service;

import com.denilsson.learning.graphqlexample.model.Person;
import com.denilsson.learning.graphqlexample.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person getPersonByID(Integer id){
        return personRepository.getReferenceById(id);
    }

}
