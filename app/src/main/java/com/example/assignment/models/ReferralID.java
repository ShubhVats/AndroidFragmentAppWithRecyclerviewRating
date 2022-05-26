package com.example.assignment.models;

import java.io.IOException;

public enum ReferralID {
    V_1653469472;

    public static ReferralID forValue(String value) throws IOException {
        if (value.equals("v-1653469472")) return V_1653469472;
        throw new IOException("Cannot deserialize ReferralID");
    }

    public String toValue() {
        switch (this) {
            case V_1653469472:
                return "v-1653469472";
        }
        return null;
    }
}
