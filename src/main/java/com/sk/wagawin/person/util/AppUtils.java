package com.sk.wagawin.person.util;

public final class AppUtils {

    /**
     * Validate and convert request id string to the corresponding long
     *
     * @param id
     *            the request id
     * @return the long
     */
    public static Long validateAndConvertRequestId(final String id) {
        Long personIdLong;
        try {
            personIdLong = Long.parseLong(id, 10);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(AppConstants.INVALID_ID_ERR_MSG);
        }
        return personIdLong;
    }
}
