
package pl.polsl.report1;

import java.util.List;
import javax.persistence.EntityManager;
import pl.polsl.lab1.report.utils.AbstractDAO;

/**
 *
 * @author Muhammed Zahid KIZMAZ
 * @version 1.1
 */
public class StudentDAO extends AbstractDAO<Student>{
    
    /**
     * Finds the lists of students that given as a parameter.
     * @param name of the student as a String.
     * @return Returns finded the students as a List.
     */
    @Override
    public List<Student> find(String name) {
        return connectionHolder.getEntityManager().createNamedQuery("Student.findByName")
                .setParameter("name", name).getResultList();
    }
    
    /**
     * Finds the studenst by searching with their id numbers.
     * @param id of Student
     * @return This method returns the students searched by it's id
     */
    public Student findStudentById(Integer id){
        connectionHolder.getEntityManager().clear();
        return (Student)connectionHolder.getEntityManager().createNamedQuery("Student.findById")
                .setParameter("id", id).getSingleResult();
    }
    
    /**
     * This method finds the all students in database.
     * @return List of all students.
     */
    public List<Student> getAllStudents(){
        return connectionHolder.getEntityManager().createNamedQuery("Student.getAll")
                .getResultList();
    }
    
    /**
     * This method will find a student by ıt's name.
     * @param name of a student as a string.
     * @return Returns the finded student.
     */
    public Student findStudentByName(String name){
        return (Student) (connectionHolder.getEntityManager().createQuery("SELECT c FROM Student c WHERE c.name=:name").
                setParameter("name", name).getSingleResult());
    }
   
    /**
     * This method is going to delete a Student that given as a parameter.
     * @param stu is a Student object.
     * @return If the deleting operation is successful this method return the 
     * value of true otherwise false.
     */
    public boolean delete(Student stu){
        EntityManager em = connectionHolder.getEntityManager();
        stu = findStudentById(stu.getId());
        if (stu != null) {
            em.getTransaction().begin();
            em.remove(stu);
            em.getTransaction().commit();
            return true;
        }else
        return false;
    }  

    /**
     * This method updates the Student obkects.
     * @param stu is a Student object
     * @return Returns updated version of given Student object.
     */    
    public Student update(Student stu){
        EntityManager em = connectionHolder.getEntityManager();
        return em.merge(stu);
    }
    
}
