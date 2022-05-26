package com.example.assignment.models;

import java.io.IOException;

public enum Summary {
    NOBODY_HERE;

    public static Summary forValue(String value) throws IOException {
        if (value.equals("Nobody here")) return NOBODY_HERE;
        throw new IOException("Cannot deserialize Summary");
    }

    public String toValue() {
        switch (this) {
            case NOBODY_HERE:
                return "Nobody here";
        }
        return null;
    }
}
