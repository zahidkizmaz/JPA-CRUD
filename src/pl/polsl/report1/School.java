/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.report1;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Muhammed Zahid KIZMAZ
 * @version 1.1
 */
@Entity
@Table(name = "school")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT c FROM Student c WHERE c.school=:name"),
    @NamedQuery(name = "School.FindById", query = "SELECT c FROM School c WHERE c.id=:id")
})
public class School implements Serializable{
    
    /**
     * Primary key of School objects.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Name of School objects.
     */
    @Column(name = "name")
    private String name;
    /**
     * Enumerated typed of Location of Schools.
     */
    @Enumerated(EnumType.STRING)
    private Location location;
    /**
     * List of the students who studies at that School.
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "school")
    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final School other = (School) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name);
        str.append(" ");
        str.append(location);
        return str.toString();
    }

}
