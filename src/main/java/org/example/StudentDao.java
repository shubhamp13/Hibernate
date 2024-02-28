package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentDao
{
    EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    public void saveUser(Student student)
    {
        entityManager.getTransaction().begin();
        if(entityManager.find(Student.class,student.getRollNo()).equals(student))
        {
            System.out.println("Already present");
            return;
        }
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
            entityManager.merge(student);
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
    public  void display()
    {
        entityManager.getTransaction().begin();
        List<Student>students=entityManager.createQuery("from Student",Student.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        for (Student student:students)
        {
            System.out.println(student);
        }
    }
}
