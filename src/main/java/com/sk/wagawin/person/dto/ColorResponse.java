package com.sk.wagawin.person.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;

@Builder
@JsonInclude(Include.NON_NULL)
public class ColorResponse {
    private String hairColor;
    private String bicycleColor;

    public static ColorResponse getResponseObject(final boolean isDaughter, final String color) {
        if (isDaughter) {
            return ColorResponse.builder().hairColor(color).build();
        } else {
            return ColorResponse.builder().bicycleColor(color).build();
        }
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(final String hairColor) {
        this.hairColor = hairColor;
    }

    public String getBicycleColor() {
        return bicycleColor;
    }

    public void setBicycleColor(final String bicycleColor) {
        this.bicycleColor = bicycleColor;
    }
}
