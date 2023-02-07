package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    MALE("boy", "he", "him", "his"),
    FEMALE("girl", "she", "her", "her"),
    NON_BINARY("kid", "ze", "hir", "hir");

    private String name;

    private String subjectivePronoun;

    private String objectivePronoun;

    private String possessivePronoun;
}