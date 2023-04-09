package hw6_hibernate_several_tables.service;

import hw6_hibernate_several_tables.model.City;
import hw6_hibernate_several_tables.model.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public interface CityDAO {

    void add(City city, EntityManager entityManager);

    City getById(int id, EntityManager entityManager);

    void updateCity(City city, EntityManager entityManager);

    void deleteById(int id, EntityManager entityManager);

    List<City> getAllCity(EntityManager entityManager);

}
