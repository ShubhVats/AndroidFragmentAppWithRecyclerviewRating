package com.example.assignment.models;

import java.io.IOException;

public enum Label {
    DISPLAY, ENTRANCE;

    public static Label forValue(String value) throws IOException {
        if (value.equals("display")) return DISPLAY;
        if (value.equals("entrance")) return ENTRANCE;
        throw new IOException("Cannot deserialize Label");
    }

    public String toValue() {
        switch (this) {
            case DISPLAY:
                return "display";
            case ENTRANCE:
                return "entrance";
        }
        return null;
    }
}
