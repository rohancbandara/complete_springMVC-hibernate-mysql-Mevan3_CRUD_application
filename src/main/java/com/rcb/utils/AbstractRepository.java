package com.rcb.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRepository<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
    @Autowired
    private SessionFactory sessionFactory;
 
    public AbstractRepository(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
 
    public void persist(Object entity) {
        getSession().persist(entity);
    }
 
    public void delete(Object entity) {
        getSession().delete(entity);
    }
    
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}
