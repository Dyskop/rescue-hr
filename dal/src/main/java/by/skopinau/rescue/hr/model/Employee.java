package by.skopinau.rescue.hr.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Employee {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthday;
    private String rank;
    private String subdivision;
    private String position;
}
