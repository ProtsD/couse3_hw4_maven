package model;

import lombok.*;
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Employee {
    private int id;
    private String firstName;
    private String secondName;
    private String gender;
    private int age;
    private City city;

    public Employee(int id, String firstName, String secondName, String gender, int age, City city) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }
}
