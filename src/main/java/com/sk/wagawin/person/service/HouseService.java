package com.sk.wagawin.person.service;

import com.sk.wagawin.person.entity.House;

public interface HouseService {

    /**
     * Gets the house for person id.
     *
     * @param personId
     *            the person id
     * @return the house for person id
     */
    House getHouseForPersonId(final Long personId);

}
