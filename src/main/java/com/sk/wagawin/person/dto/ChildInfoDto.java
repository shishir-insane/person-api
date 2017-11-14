package com.sk.wagawin.person.dto;

import com.sk.wagawin.person.entity.Meal;
import com.sk.wagawin.person.entity.Person;

public class ChildInfoDto {

    private Person parent;

    private Meal favoriteMeal;

    public ChildInfoDto() {

    }

    public ChildInfoDto(final Person parent, final Meal favoriteMeal) {
        this.parent = parent;
        this.favoriteMeal = favoriteMeal;
    }

    public Person getParent() {
        return parent;
    }

    public void setParent(final Person parent) {
        this.parent = parent;
    }

    public Meal getFavoriteMeal() {
        return favoriteMeal;
    }

    public void setFavoriteMeal(final Meal favoriteMeal) {
        this.favoriteMeal = favoriteMeal;
    }
}
