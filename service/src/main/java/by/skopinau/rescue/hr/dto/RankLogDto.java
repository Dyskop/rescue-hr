package by.skopinau.rescue.hr.dto;

import by.skopinau.rescue.hr.entity.Employee;

public class RankLogDto {
    private String gettingDate;
    private Employee employee;
    private String rankTitle;
    private String rankOrderPublisher;
    private String rankOrderNumber;

    public RankLogDto(String gettingDate, Employee employee, String rankTitle,
                      String rankOrderPublisher, String rankOrderNumber) {
        this.gettingDate = gettingDate;
        this.employee = employee;
        this.rankTitle = rankTitle;
        this.rankOrderPublisher = rankOrderPublisher;
        this.rankOrderNumber = rankOrderNumber;
    }

    public String getGettingDate() {
        return gettingDate;
    }

    public void setGettingDate(String gettingDate) {
        this.gettingDate = gettingDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getRankTitle() {
        return rankTitle;
    }

    public void setRankTitle(String rankTitle) {
        this.rankTitle = rankTitle;
    }

    public String getRankOrderPublisher() {
        return rankOrderPublisher;
    }

    public void setRankOrderPublisher(String rankOrderPublisher) {
        this.rankOrderPublisher = rankOrderPublisher;
    }

    public String getRankOrderNumber() {
        return rankOrderNumber;
    }

    public void setRankOrderNumber(String rankOrderNumber) {
        this.rankOrderNumber = rankOrderNumber;
    }
}