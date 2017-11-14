package com.sk.wagawin.person.service;

import java.util.Map;

import com.sk.wagawin.person.entity.Child;
import com.sk.wagawin.person.entity.Meal;
import com.sk.wagawin.person.entity.Person;

public interface ChildService {

    /**
     * Gets the house for person id.
     *
     * @param personId
     *            the person id
     * @return the person for person id
     */
    Person getParentInfoForChild(final Long childId);

    /**
     * Gets the favorite meal info for child.
     *
     * @param childId
     *            the child id
     * @return the favorite meal info for child
     */
    Meal getFavoriteMealInfoForChild(Long childId);

    /**
     * Gets the color for child id.
     *
     * @param childId
     *            the child id
     * @return the color for child id
     */
    Child getColorForChildId(long childId);

    /**
     * Gets the person and children data counts.
     *
     * @return the person and children data counts
     */
    Map<String, Long> getPersonAndChildrenDataCounts();

}
