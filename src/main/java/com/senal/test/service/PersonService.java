package com.senal.test.service;

import com.senal.test.dao.PersonDao;
import com.senal.test.model.Person;

public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
       return personDao.insertPerson(person);
    }

}
