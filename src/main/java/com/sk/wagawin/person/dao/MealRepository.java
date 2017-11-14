package com.sk.wagawin.person.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sk.wagawin.person.entity.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    /**
     * Find by child id order by invented.
     *
     * @param childId
     *            the child id
     * @return the list
     */
    List<Meal> findByChild_idOrderByInvented(Long childId);

}
