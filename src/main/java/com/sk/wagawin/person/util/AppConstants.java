package com.sk.wagawin.person.util;

public final class AppConstants {

    // End points
    public static final String HOUSE_ENDPOINT = "/house/{personId}";
    public static final String CHILD_INFO_ENDPOINT = "/child/info/{childId}";
    public static final String COLOR_INFO_ENDPOINT = "/color/{childId}";
    public static final String DATA_COUNT_ENDPOINT = "/persons/children";

    // Exception messages
    public static final String INVALID_ID_ERR_MSG = "Requested ID in the URL is invalid.";
    public static final String NO_HOUSE_DATA_FOUND = "No house belongs to the requested ID.";
    public static final String NO_PERSON_DATA_FOUND = "No person belongs to the requested ID.";
    public static final String NO_MEAL_DATA_FOUND = "No meal belongs to the requested ID.";
    public static final String NO_CHILD_DATA_FOUND = "No child belongs to the requested ID.";

    // Name constants
    public static final String PERSON_COUNT_KEY = "PERSON_COUNT_KEY";
    public static final String CHILDREN_COUNT_KEY = "CHILDREN_COUNT_KEY";

}
