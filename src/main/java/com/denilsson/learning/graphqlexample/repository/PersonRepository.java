package com.denilsson.learning.graphqlexample.repository;

import com.denilsson.learning.graphqlexample.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends  JpaRepository <Person,Integer> {

}
