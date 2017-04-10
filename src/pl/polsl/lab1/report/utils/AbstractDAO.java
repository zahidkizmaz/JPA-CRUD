
package pl.polsl.lab1.report.utils;

import java.util.List;

/**
 *
 * @author Muhammed Zahid KIZMAZ
 * @version 1.1
 */
public abstract class AbstractDAO<T> {
    
    /**
     * Connection holder objects instance.
     */
    protected ConnectionHolder connectionHolder = ConnectionHolder.getInstance();
    
    protected void startTransaction(){
        connectionHolder.getEntityManager().getTransaction().begin();
    }
    
    protected void finishTransaction (boolean success){
        if (success) {
            connectionHolder.getEntityManager().getTransaction().commit();
        }else{
            connectionHolder.getEntityManager().getTransaction().rollback();
        }
    }
    
    public void create (T entity){
        startTransaction();
        connectionHolder.getEntityManager().persist(entity);
        finishTransaction(true);
    }
    
    public T find(Class<T> clazz, Integer id){
        return connectionHolder.getEntityManager().find(clazz, id);
    }
    
    public abstract List<T> find(String name);

}
