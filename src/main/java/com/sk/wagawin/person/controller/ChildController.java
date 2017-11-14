package com.sk.wagawin.person.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.wagawin.person.dto.ChildInfoDto;
import com.sk.wagawin.person.dto.ColorResponse;
import com.sk.wagawin.person.entity.Child;
import com.sk.wagawin.person.service.ChildService;
import com.sk.wagawin.person.util.AppConstants;
import com.sk.wagawin.person.util.AppUtils;

@RestController
public class ChildController {

    @Autowired
    private ChildService childService;

    /**
     * Gets the house for person.
     *
     * @param childId
     *            the child id
     * @return the house for person
     */
    @RequestMapping(path = AppConstants.CHILD_INFO_ENDPOINT)
    public ChildInfoDto getHouseForPerson(@PathVariable(name = "childId") final String childId) {
        final long id = AppUtils.validateAndConvertRequestId(childId);
        return new ChildInfoDto(childService.getParentInfoForChild(id), childService.getFavoriteMealInfoForChild(id));
    }

    /**
     * Gets the color for child.
     *
     * @param childId
     *            the child id
     * @return the color for child
     */
    @RequestMapping(path = AppConstants.COLOR_INFO_ENDPOINT)
    public ColorResponse getColorForChild(@PathVariable(name = "childId") final String childId) {
        final Child child = childService.getColorForChildId(AppUtils.validateAndConvertRequestId(childId));
        return ColorResponse.getResponseObject(child.isDaughter(), child.getColor());
    }

    @RequestMapping(path = AppConstants.DATA_COUNT_ENDPOINT)
    public Map<String, Long> getPersonChildrenDataCounts() {
        return childService.getPersonAndChildrenDataCounts();
    }

}
