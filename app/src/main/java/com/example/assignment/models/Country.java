package com.example.assignment.models;

import java.io.IOException;

public enum Country {
    UNITED_STATES;

    public static Country forValue(String value) throws IOException {
        if (value.equals("United States")) return UNITED_STATES;
        throw new IOException("Cannot deserialize Country");
    }

    public String toValue() {
        switch (this) {
            case UNITED_STATES:
                return "United States";
        }
        return null;
    }
}
