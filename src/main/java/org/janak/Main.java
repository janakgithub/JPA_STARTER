package org.janak;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        Employee emp = new Employee();

        emp.setName("Janak Adhikari");

        EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //entityManager.persist(emp);

        Employee employee = entityManager.find(Employee.class, 2);
        System.out.println(employee);

        employee.setName("Nikita  Adhikari");
        entityManager.persist(employee);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}