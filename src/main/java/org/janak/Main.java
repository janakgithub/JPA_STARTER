package org.janak;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Employee emp = new Employee();
        emp.setName("Janak Adhikari");
        emp.setDob(new Date());
        emp.setSsn("123234123");
        emp.setType(EmployeeType.FULL_TIME);
        emp.setDebugString("DEBUGGING ON");

        Employee emp2 = new Employee();
        emp2.setName("Nikita Adhikari");
        emp2.setDob(new Date());
        emp2.setSsn("1234567890");
        emp2.setType(EmployeeType.CONTRACTOR);
        emp.setDebugString("DEBUGGING OFF");

        AccessCard aCard = new AccessCard();
        aCard.setIssueDate(new Date());
        aCard.setActive(true);
        aCard.setFirmware("1.0.0");

        AccessCard aCard2 = new AccessCard();
        aCard2.setIssueDate(new Date());
        aCard2.setActive(false);
        aCard2.setFirmware("1.1.0");

        EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(emp);
        entityManager.persist(emp2);

        entityManager.persist(aCard);
        entityManager.persist(aCard2);


 //       Employee employee = entityManager.find(Employee.class, 2);
 //       System.out.println(employee);

//        employee.setName("Nikita  Adhikari");
//        entityManager.persist(employee);

//        entityManager.remove(employee);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}