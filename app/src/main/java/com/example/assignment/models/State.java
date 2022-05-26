package com.example.assignment.models;

import java.io.IOException;

public enum State {
    NY;

    public static State forValue(String value) throws IOException {
        if (value.equals("NY")) return NY;
        throw new IOException("Cannot deserialize State");
    }

    public String toValue() {
        switch (this) {
            case NY:
                return "NY";
        }
        return null;
    }
}
