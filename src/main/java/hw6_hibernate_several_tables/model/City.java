package hw6_hibernate_several_tables.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString (exclude = {"employees"})
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int id;
    @Column(name = "city_name")
    private String Name;
    @OneToMany (mappedBy = "city", cascade =CascadeType.ALL)
    private List<Employee> employees;

    public City(String name) {
        Name = name;
    }

    public City(int id, String name) {
        this.id = id;
        Name = name;
    }
}
