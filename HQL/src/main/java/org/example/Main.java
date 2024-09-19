package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Address;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

       /* //get all data from student
        Query query = session.createQuery("from Student");
        List<Student> studentList = query.list();

        for (Student student : studentList) {
            System.out.println(student.getName());
        }

        //unique one data from student

        Query query1 = session.createQuery("from Student where id =? 1");

        Student student = (Student) query.uniqueResult();
        System.out.println(student.getId());


        //load only one column
        Query query2 = session.createQuery("from Student where id =?1");
        query2.setParameter(1, 1);
        Student student = (Student) query2.uniqueResult();
        System.out.println(student.getId());



        //----------------------------------------------
        //----------------------------------------------

        //View
        Query query = session.createQuery("from Student");
        List<Student> students = query.list();
        for (Student student: students){
            System.out.println(student);
        }
        //Insert
        Query query1 = session.createQuery("insert into Student(id,age,name) values(?1,?2,?3)");
        query1.setParameter(1, 2);
        query1.setParameter(2, 23);
        query1.setParameter(3, "Charith");
        query1.executeUpdate();

        //Update
        Query query2 = session.createQuery("update Student set name=?1 where id=?2");
        query2.setParameter(1, "Nimeda");
        query2.setParameter(2, 1);
        query2.executeUpdate();

        //Delete
        Query query3 = session.createQuery("delete from Student where id=?1");
        query3.setParameter(1, 2);
        query3.executeUpdate();
*/
        //JoinQuery
        Query query4 = session.createQuery("SELECT s.id, s.name, s.age FROM Student s JOIN Address a ON s.id = a.aid");
        List<Student> studentList = query4.list();
        for (Student student : studentList) {
            System.out.println(Arrays.toString(new Student[]{student}));
        }

        transaction.commit();
        session.close();

    }
}