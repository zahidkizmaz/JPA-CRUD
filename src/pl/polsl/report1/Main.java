
package pl.polsl.report1;

import java.util.Date;

/**
 *
 * @author Muhammed Zahid KIZMAZ
 * @version 1.1
 */
public class Main {
    public static void main(String[] args) {
        
        SchoolDAO schoolDAO = new SchoolDAO();
        StudentDAO studentDAO = new StudentDAO();
        
        
        School school = new School();
        school.setName("POLSL");
        school.setLocation(Location.GLIWICE);
        schoolDAO.create(school);
        
        System.out.println(school);
        
        school.setLocation(Location.KRAKOW);
        schoolDAO.update(school);
        System.out.println(school);

        
        Student s1 = new Student();
        s1.setName("Zahid");
        s1.setSurname("Kizmaz");
        s1.setBirthDate(new Date(95, 04, 27));
        s1.setSchool(school);
        studentDAO.create(s1);
        
        
        Student s2 = new Student();
        s2.setName("Harun");
        s2.setSurname("Gulec");
        s2.setBirthDate(new Date(95, 06, 14));
        s2.setSchool(school);
        studentDAO.create(s2);
        
        System.out.println(schoolDAO.getStudentList(school));
        
        //schoolDAO.delete(school);
        
        //System.out.println(schoolDAO.getStudentList(school));

        
        
    }
}
