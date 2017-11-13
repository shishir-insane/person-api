package com.sk.wagawin.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.wagawin.person.dao.HouseRepository;
import com.sk.wagawin.person.entity.House;
import com.sk.wagawin.person.exception.PersonApiException;
import com.sk.wagawin.person.service.HouseService;
import com.sk.wagawin.person.util.AppConstants;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sk.wagawin.person.service.HouseService#getHouseForPersonId(java.lang.
     * Long)
     */
    @Override
    public House getHouseForPersonId(final Long personId) {
        final House house = houseRepository.findOneByPerson_id(personId);
        if (null == house) {
            throw new PersonApiException(AppConstants.NO_HOUSE_DATA_FOUND);
        }
        return house;
    }

}
