package bean;

import java.util.stream.Stream;

public enum Gender {

    FEMALE("female"), MALE("male");

    private final String type;

    Gender(String type) {
        this.type = type;
    }

    public static Gender of(String type) {
        return Stream.of(Gender.values())
                .filter(valuable -> valuable.type.equalsIgnoreCase(type))
                .findFirst().orElse(MALE);
    }
}
