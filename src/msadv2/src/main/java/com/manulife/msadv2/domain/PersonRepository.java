package com.manulife.msadv2.domain;

public interface PersonRepository {
    Person getPersonById(int id);
    boolean updatePerson(Person person);
}
