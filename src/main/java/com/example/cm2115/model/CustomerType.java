package com.example.cm2115.model;

/**
 * The CustomerType enum represents different types of customers.
 */
public enum CustomerType {

    // Enum constants with corresponding values
    FIRST_STRING("Individual"),
    SECOND_STRING("Business"),
    THIRD_STRING("Charity");

    // Private field to store the value associated with each enum constant
    private final String value;

    /**
     * Constructor for CustomerType enum.
     *
     * @param value The string value associated with the enum constant.
     */
    CustomerType(String value) {
        this.value = value;
    }

    /**
     * Getter method to retrieve the string value associated with the enum constant.
     *
     * @return The string value of the enum constant.
     */
    public String getValue() {
        return value;
    }

}
