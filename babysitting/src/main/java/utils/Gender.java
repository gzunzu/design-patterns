package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    MALE("boy", "he", "his", "him"),
    FEMALE("girl", "she", "her", "her");

    private String name;

    private String pronoun;

    private String possessivePronoun;

    private String thirdPronoun;
}