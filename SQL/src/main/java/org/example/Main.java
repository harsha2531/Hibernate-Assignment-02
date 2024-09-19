package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        /*Address address1 = new Address();
        address1.setAid(1);
        address1.setNumber("223");
        address1.setStreet("Main Street");
        address1.setCity("Panadura");

        Address address2 = new Address();
        address2.setAid(2);
        address2.setNumber("54");
        address2.setStreet("Cemetry Street");
        address2.setCity("Bandargama");


        List<Address> addresses = new ArrayList<Address>();
        addresses.add(address1);
        addresses.add(address2);

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Harsha");
        student1.setAge(25);

        address1.setStudent(student1);
        address2.setStudent(student1);*/

    Session session = FactoryConfiguration.getInstance().getSession();
    Transaction transaction = session.beginTransaction();

    NativeQuery query = session.createNativeQuery("select * from student");
    //insert/update/delete/search
    query.addEntity(Student.class);

    List<Student> studentList = query.list();

    for(Student student:studentList){
        System.out.println(student.getId());

    }

        //Insert----------------------------------------------------------------

       /* NativeQuery nativeQuery1 = session.createNativeQuery("insert into student values(?1,?2,?3)");
        nativeQuery1.setParameter(1, 1);
        nativeQuery1.setParameter(2, 25);
        nativeQuery1.setParameter(3,"Harsha");
        nativeQuery1.executeUpdate();*/

        //Update----------------------------------------------------------------

       /* NativeQuery nativeQuery2 = session.createNativeQuery("update student set age =?2 where id =?1");
        nativeQuery2.setParameter(1, 1);
        nativeQuery2.setParameter(2,23);
        nativeQuery2.executeUpdate();*/

        //Delete----------------------------------------------------------------

        /*NativeQuery nativeQuery3 = session.createNativeQuery("delete from student where id=?1");
        nativeQuery3.setParameter(1,1);
        nativeQuery3.executeUpdate();*/

        //JoinQuery----------------------------------------------------------------

        NativeQuery nativeQuery4 = session.createNativeQuery("SELECT s.id, s.name, s.age FROM student s JOIN address a ON s.id = a.aid");
        List<Student> students = nativeQuery4.list();
        for (Student student : students) {
            System.out.println(Arrays.toString(new Student[]{student}));
        }
        transaction.commit();
        session.close();

}
}