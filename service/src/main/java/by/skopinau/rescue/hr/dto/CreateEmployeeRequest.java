package by.skopinau.rescue.hr.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateEmployeeRequest {
    private String surname;
    private String name;
    private String patronymic;
    private String birthday;
    private String rankTitle;
    private String positionTitle;
    private String subdivisionTitle;
    /*
    private String positionGettingDate;
    private String positionOrderPublisher;
    private String positionOrderNumber;*/
}