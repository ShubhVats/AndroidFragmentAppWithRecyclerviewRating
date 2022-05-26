package com.example.assignment.models;

import java.io.IOException;

public enum City {
    NEW_YORK;

    public static City forValue(String value) throws IOException {
        if (value.equals("New York")) return NEW_YORK;
        throw new IOException("Cannot deserialize City");
    }

    public String toValue() {
        switch (this) {
            case NEW_YORK:
                return "New York";
        }
        return null;
    }
}
