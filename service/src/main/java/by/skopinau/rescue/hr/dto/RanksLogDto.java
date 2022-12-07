package by.skopinau.rescue.hr.dto;

import by.skopinau.rescue.hr.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateRanksLogRequest {
    private String rankGettingDate;
    private Employee employee;
    private String rankTitle;
    private String rankOrderPublisher;
    private String rankOrderNumber;
}