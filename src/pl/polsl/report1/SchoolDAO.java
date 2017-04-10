
package pl.polsl.report1;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import pl.polsl.lab1.report.utils.AbstractDAO;

/**
 *
 * @author Muhammed Zahid KIZMAZ
 * @version 1.1
 */
public class SchoolDAO extends AbstractDAO<School>{
    
    /**
     * Finds the lists of schools that given as a parameter.
     * @param name of a School
     * @return Returns finded the schools as a List.
     */
    @Override
    public List<School> find(String name) {
        return connectionHolder.getEntityManager().createNamedQuery("School.findByName")
                .setParameter("name", name).getResultList();
    }
    
    /**
     * Searches schools using id number.
     * @param id Integer type id number.
     * @return This method returns the school searched by it's id.
     */
    public School findSchoolById(Integer id){
        connectionHolder.getEntityManager().clear();
        return (School)connectionHolder.getEntityManager().createNamedQuery("School.FindById")
                .setParameter("id", id).getSingleResult();
    }

    
    /**
     * Searches students from schools that given as a parameter.
     * @param school School object.
     * @return Student list whose belongs that giving the parameter of school.
     */
    public List<Student> getStudentList(School school){
        return connectionHolder.getEntityManager().createNamedQuery("Student.findAll")
               .setParameter("name", school).getResultList();    
    }
    
    /**
     * This method will search a school by the name of it.
     * @param name String type name of school. 
     * @return School object that searched.
     */
    public School findSchoolByName(String name){
        return (School) (connectionHolder.getEntityManager().createQuery("SELECT c FROM School c WHERE c.name=:name").
                setParameter("name", name).getSingleResult());
    }
    
    /**
     * This method is going to delete a School that given as a parameter.
     * @param sc is School object.
     * @return If the deleting operation is successful this method return the 
     * value of true otherwise false.
     */
    public boolean delete(School sc){
        EntityManager em = connectionHolder.getEntityManager();
        sc = findSchoolById(sc.getId());
        if (sc != null) {
            em.getTransaction().begin();
            em.remove(sc);
            em.getTransaction().commit();
            return true;
        }else
        return false;
    }  
    
    /**
     * This method updates the School objects.
     * @param sc School object.
     * @return Returns updated version of given School object.
     */     
    public School update(School sc){
        EntityManager em = connectionHolder.getEntityManager();
        return em.merge(sc);
    }
    
}
