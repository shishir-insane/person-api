package com.sk.wagawin.person.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sk.wagawin.person.dao.ChildRepository;
import com.sk.wagawin.person.dao.MealRepository;
import com.sk.wagawin.person.dao.PersonRepository;
import com.sk.wagawin.person.entity.Child;
import com.sk.wagawin.person.entity.Meal;
import com.sk.wagawin.person.entity.Person;
import com.sk.wagawin.person.exception.PersonApiException;
import com.sk.wagawin.person.service.ChildService;
import com.sk.wagawin.person.util.AppConstants;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private ChildRepository childRepository;

    private Map<String, Long> dataCount;

    /*
     * (non-Javadoc)
     *
     * @see
     * com.sk.wagawin.person.service.ChildService#getParentInfoForChild(java.
     * lang.Long)
     */
    @Override
    public Person getParentInfoForChild(final Long childId) {
        final Person parent = personRepository.findOneByChildren_id(childId);
        if (null == parent) {
            throw new PersonApiException(AppConstants.NO_PERSON_DATA_FOUND);
        }
        return parent;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.sk.wagawin.person.service.ChildService#getFavoriteMealInfoForChild(
     * java.lang.Long)
     */
    @Override
    public Meal getFavoriteMealInfoForChild(final Long childId) {
        final List<Meal> favoriteMeals = mealRepository.findByChild_idOrderByInvented(childId);
        if (CollectionUtils.isEmpty(favoriteMeals)) {
            throw new PersonApiException(AppConstants.NO_MEAL_DATA_FOUND);
        }
        return favoriteMeals.get(0);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sk.wagawin.person.service.ChildService#getColorForChildId(long)
     */
    @Override
    public Child getColorForChildId(final long childId) {
        final Child child = childRepository.findOne(childId);
        if (null == child) {
            throw new PersonApiException(AppConstants.NO_CHILD_DATA_FOUND);
        }
        return child;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sk.wagawin.person.service.ChildService#getPersonAndChildrenDataCounts
     * ()
     */
    @Override
    public Map<String, Long> getPersonAndChildrenDataCounts() {
        return dataCount;
    }

    /**
     * Refresh data count.
     */
    @Scheduled(fixedRate = 600000)
    public void refreshDataCount() {
        if (CollectionUtils.isEmpty(dataCount)) {
            dataCount = new HashMap<>();
        }
        dataCount.put(AppConstants.PERSON_COUNT_KEY, personRepository.count());
        dataCount.put(AppConstants.CHILDREN_COUNT_KEY, childRepository.count());
    }
}
