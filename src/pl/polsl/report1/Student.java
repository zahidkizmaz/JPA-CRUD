
package pl.polsl.report1;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Muhammed Zahid KIZMAZ
 * @version 1.1
 */
@Entity
@Table(name = "students")
@NamedQueries({
    @NamedQuery(name = "Student.getAll", query = "SELECT c FROM Student c"),
    @NamedQuery(name = "Student.findById", query = "SELECT c FROM Student c WHERE c.id=:id")
})
public class Student implements Serializable{
    
    /**
     * Primary key of Student objects.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Name of Students.
     */
    @Column(name = "name", nullable = false, length = 40)
    private String name;
    /**
     * Surname of a Students.
     */
    @Column(name = "surname", nullable = false, length = 40)
    private String surname;
    /**
     * Birth date of Students typed Date.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;
    /**
     * School object that Student study at.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(id);
        str.append("-");
        str.append(name);
        str.append(" ");
        str.append(surname);
        
        return str.toString();
    }

   
    
    
    
    
           
          
    
    
}
