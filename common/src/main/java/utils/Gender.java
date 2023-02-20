package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    MALE("boy", "he", "him", "his"),
    FEMALE("girl", "she", "her", "her"),
    NON_BINARY("kid", "ze", "hir", "hir");

    private final String name;

    private final String subjectivePronoun;

    private final String objectivePronoun;

    private final String possessivePronoun;
}