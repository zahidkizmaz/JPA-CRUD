
package pl.polsl.lab1.report.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Muhammed Zahid KIZMAZ
 * @version 1.1
 */
public class ConnectionHolder {
    
    /**
     * Instance of ConnectionHolder object.
     */
    private static final ConnectionHolder instance = new ConnectionHolder();
    /**
     * Persistence unit name as a string.
     */
    private String persistenceUnitName;
    /**
     * Entity manager object.
     */
    private EntityManager entityManager;
    /**
     * Persistence unit names value.
     */
    private static final String DEFAULT_PU = "Lab1PU";
    
    
    private ConnectionHolder (){}
    
    public static ConnectionHolder getInstance(){
        return instance;
    }
    
    public EntityManager getEntityManager(){
        if (entityManager == null) {
            if (persistenceUnitName == null) {
                persistenceUnitName = DEFAULT_PU;                
            }
            entityManager = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
        }
        return entityManager;
    }
    
    public void closeEntityManager(){
        if (entityManager != null) {
            entityManager.close();
            entityManager = null;
        }
    }

    public void setPersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }  
    
}
