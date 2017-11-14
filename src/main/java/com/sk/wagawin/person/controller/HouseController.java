package com.sk.wagawin.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.wagawin.person.entity.House;
import com.sk.wagawin.person.service.HouseService;
import com.sk.wagawin.person.util.AppConstants;
import com.sk.wagawin.person.util.AppUtils;

@RestController
public class HouseController {

    @Autowired
    private HouseService houseService;

    /**
     * Gets the house for person.
     *
     * @param personId
     *            the person id
     * @return the house for person
     */
    @RequestMapping(path = AppConstants.HOUSE_ENDPOINT)
    public House getHouseForPerson(@PathVariable final String personId) {
        return houseService.getHouseForPersonId(AppUtils.validateAndConvertRequestId(personId));
    }
}
