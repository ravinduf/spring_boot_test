package com.senal.test.dao;

import com.senal.test.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMayBe = selectPersonById(id);
        if(personMayBe.isEmpty()) {
            return 0;
        }
        else {
            DB.remove(personMayBe.get());
        }
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id)
                .map(person1 -> {
                    int indexOfPersonToDelete = DB.indexOf(person);
                    if (indexOfPersonToDelete >= 0){
                        DB.set(indexOfPersonToDelete, person);
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }

}
