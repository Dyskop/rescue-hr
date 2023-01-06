package by.skopinau.rescue.hr.model.enums;

import java.util.stream.Stream;

public enum Rank {
    LIEUTENANT_GENERAL("генерал-лейтенант"),
    MAJOR_GENERAL("генерал-майор"),
    COLONEL("полковник"),
    SUB_COLONEL("подполковник"),
    MAJOR("майор"),
    CAPTAIN("капитан"),
    SENIOR_LIEUTENANT("старший лейтенант"),
    LIEUTENANT("лейтенант"),
    JUNIOR_LIEUTENANT("младший лейтенант"),
    SENIOR_ENSIGN("старший прапорщик"),
    ENSIGN("прапорщик"),
    MASTER_SERGEANT("старшина"),
    STAFF_SERGEANT("старший сержант"),
    SERGEANT("сержант"),
    LANCE_SERGEANT("младший сержант"),
    SOLDIER("рядовой");

    private final String title;

    Rank(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static Rank of(String title) {
        return Stream.of(Rank.values())
                .filter(r -> r.getTitle().equals(title))
                .findFirst()
                .orElseThrow();
    }
}
