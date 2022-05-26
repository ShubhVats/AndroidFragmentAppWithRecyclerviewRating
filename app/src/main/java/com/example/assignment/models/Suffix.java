package com.example.assignment.models;

import java.io.IOException;

public enum Suffix {
    PNG;

    public static Suffix forValue(String value) throws IOException {
        if (value.equals(".png")) return PNG;
        throw new IOException("Cannot deserialize Suffix");
    }

    public String toValue() {
        switch (this) {
            case PNG:
                return ".png";
        }
        return null;
    }
}
