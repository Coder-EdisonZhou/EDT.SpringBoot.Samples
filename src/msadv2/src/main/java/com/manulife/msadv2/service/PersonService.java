package com.manulife.msadv2.service;

import com.manulife.msadv2.domain.Person;
import com.manulife.msadv2.domain.PersonRepository;

public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person getPerson(int id){
        return personRepository.getPersonById(id);
    }

    public boolean updatePerson(int id, String name){
        Person person = personRepository.getPersonById(id);
        if (person == null){
            return false;
        }

        person.setName(name);

        return personRepository.updatePerson(person);
    }
}
