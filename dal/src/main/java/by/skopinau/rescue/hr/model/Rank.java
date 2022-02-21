package by.skopinau.rescue.hr.model;

public enum Rank {
    LIEUTENANT_GENERAL("генерал-лейтенант"),
    MAJOR_GENERAL("генерал-майор"),
    COLONEL("полковник"),
    LIEUTENANT_COLONEL("подполковник"),
    MAJOR("майор"),
    CAPTAIN("капитан"),
    SENIOR_LIEUTENANT("старший лейтенант"),
    LIEUTENANT("лейтенант"),
    JUNIOR_LIEUTENANT("младший лейтенант"),
    SENIOR_ENSIGN("старший прапорщик"),
    ENSIGN("прапорщик"),
    FOREMAN("старшина"),
    STAFF_SERGEANT("старший сержант"),
    SERGEANT("сержант"),
    LANCE_SERGEANT("младший сержант"),
    PRIVATE("рядовой");

    private final String rank;

    Rank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
}
