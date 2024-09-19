package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        //View
        Query query = session.createQuery("select s from Student s");
        List<Student> students = query.list();
        for (Student student : students) {
            System.out.println(student);
        }

        //Insert
        Query query1 = session.createQuery("insert into Student(id,age,name) values(?1,?2,?3)");
        query1.setParameter(1, 2);
        query1.setParameter(2, 24);
        query1.setParameter(3, "Chamod");
        query1.executeUpdate();

        //Update
        Query query2 = session.createQuery("update Student s set s.name = :name where s.id = :id");
        query2.setParameter("name", "Gihan");
        query2.setParameter("id", 1);
        query2.executeUpdate();

        //Delete
        Query query3 = session.createQuery("delete from Student s where s.id = :id");
        query3.setParameter("id", 2);
        query3.executeUpdate();

        //Join
        Query query4 = session.createQuery("SELECT s.id, s.name, s.age FROM Student s JOIN Address a ON s.id = a.aid");
        List<Student> studentList = query4.list();
        for (Student student : studentList) {
            System.out.println(Arrays.toString(new Student[]{student}));
        }
        transaction.commit();
        session.close();
    }
}