package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentDao
{
    EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    public void saveUser(Student student)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
    public  void  updateUser(int rollNo,String name)
    {
        entityManager.getTransaction().begin();
        Student student=entityManager.find(Student.class,rollNo);
        if(student!=null)
        {
            student.setName(name);
            entityManager.persist(student);
            entityManager.getTransaction().commit();
            System.out.println("Data Updated");

        }
        else
        {
            System.out.println("Not find record");
        }
        entityManager.close();
        entityManagerFactory.close();

    }
    public  void deleteUser(int rollNo)
    {
        entityManager.getTransaction().begin();
        Student student=entityManager.find(Student.class,rollNo);
        if(student!=null)
        {
            entityManager.remove(student);
            entityManager.getTransaction().commit();
            System.out.println("Data Deleted");
        }
        else
        {
            System.out.println("Data Not Found");
        }
        entityManager.close();
        entityManagerFactory.close();
    }
    public  void fetchData(int rollNo)
    {
        entityManager.getTransaction().begin();
        Student student=entityManager.find(Student.class,rollNo);
        if(student!=null)
        {
            System.out.println(student);
            entityManager.getTransaction().commit();
        }
        else
        {
            System.out.println("Data Not Found");
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
