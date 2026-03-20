package edu.ntnu.lucyciara.util;

public final class ParameterCheck {
    private ParameterCheck() { };
   
    private static void nullCheck(Object object, String variableName) {
        if (object == null) {
            throw new IllegalArgumentException(String.format("%s can't be null", variableName));
        }
    }

    public static void stringValidation(String string, String variableName) throws IllegalArgumentException {
        nullCheck(string, variableName);
        if (string.isBlank()) {
            throw new IllegalArgumentException(String.format("%s can't be blank", variableName));
        }
    }

    public static void objectValidation(Object object, String variableName) throws IllegalArgumentException {
        nullCheck(object, variableName);
    }
}
