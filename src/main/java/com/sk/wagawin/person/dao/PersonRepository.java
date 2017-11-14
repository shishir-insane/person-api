package com.sk.wagawin.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sk.wagawin.person.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * Find one by children id.
     *
     * @param childId
     *            the child id
     * @return the person
     */
    Person findOneByChildren_id(final long childId);
}
