package hw6_hibernate_several_tables.service;

import hw6_hibernate_several_tables.model.City;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public void add(City city, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
    }

    @Override
    public City getById(int id, EntityManager entityManager) {
        return entityManager.find(City.class, id);
    }

    @Override
    public void updateCity(City city, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.merge(city);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteById(int id, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(getById(id, entityManager));
        } catch (IllegalArgumentException e) {
            System.out.println("The city with id = " + id + " doesn't exist");
            e.printStackTrace();
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public List<City> getAllCity(EntityManager entityManager) {
        String jpqlQuery = "SELECT s FROM City s";
        TypedQuery<City> query = entityManager.createQuery(jpqlQuery, City.class);
        List<City> Cities = query.getResultList();
        return Cities;
    }
}
