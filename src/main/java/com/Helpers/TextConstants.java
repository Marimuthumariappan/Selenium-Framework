package com.Helpers;

public enum TextConstants {

	SOLUTIONS("Solutions"),
    WHY_ORANGE_HRM("Why OrangeHRM"),
    RESOURCES("Resources"),
    COMPANY("Company");

    private final String text;

    TextConstants(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
