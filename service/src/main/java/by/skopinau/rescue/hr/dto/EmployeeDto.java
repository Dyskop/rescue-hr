package by.skopinau.rescue.hr.dto;

public class EmployeeDto {
    private String surname;
    private String name;
    private String patronymic;
    private String birthday;
    private String rankTitle;
    private String positionTitle;
    private String subdivisionTitle;

    public EmployeeDto(String surname, String name, String patronymic,
                       String birthday, String rankTitle, String positionTitle,
                       String subdivisionTitle) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.rankTitle = rankTitle;
        this.positionTitle = positionTitle;
        this.subdivisionTitle = subdivisionTitle;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRankTitle() {
        return rankTitle;
    }

    public void setRankTitle(String rankTitle) {
        this.rankTitle = rankTitle;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getSubdivisionTitle() {
        return subdivisionTitle;
    }

    public void setSubdivisionTitle(String subdivisionTitle) {
        this.subdivisionTitle = subdivisionTitle;
    }
}