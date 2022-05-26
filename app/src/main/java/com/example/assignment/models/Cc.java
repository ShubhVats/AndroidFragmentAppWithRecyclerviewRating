package com.example.assignment.models;

import java.io.IOException;

public enum Cc {
    US;

    public static Cc forValue(String value) throws IOException {
        if (value.equals("US")) return US;
        throw new IOException("Cannot deserialize Cc");
    }

    public String toValue() {
        switch (this) {
            case US:
                return "US";
        }
        return null;
    }
}
