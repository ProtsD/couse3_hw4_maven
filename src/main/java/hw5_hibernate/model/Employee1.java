package hw5_hibernate.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode (exclude = {"id"})

@Entity
@Table(name = "employee")
public class Employee1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String secondName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @Column(name = "city_id")
    private int city;

    public Employee1(String firstName, String secondName, String gender, int age, int city) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }
    public Employee1(int id, String firstName, String secondName, String gender, int age, int city) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.id = id;
    }
}
