package com.sk.wagawin.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sk.wagawin.person.entity.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    /**
     * Find one by person id.
     *
     * @param personId
     *            the person id
     * @return the house
     */
    House findOneByPerson_id(final long personId);

}
