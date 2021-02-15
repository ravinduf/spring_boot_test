package com.senal.test.api;

import com.senal.test.model.Person;
import com.senal.test.service.PersonService;

public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    public void addPerson(Person person){
        personService.addPerson(person);
    }

    
}
