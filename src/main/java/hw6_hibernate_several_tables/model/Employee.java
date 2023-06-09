package hw6_hibernate_several_tables.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode (exclude = {"id"})

@Entity
@Table(name = "employee")
public class Employee {
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

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;


    public Employee(String firstName, String secondName, String gender, int age, City city) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }
    public Employee(int id, String firstName, String secondName, String gender, int age, City city) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.id = id;
    }
}
