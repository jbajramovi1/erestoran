package repositories;

import javax.persistence.PersistenceException;

import org.hibernate.*;
import org.hibernate.jpa.HibernateEntityManager;

import play.db.jpa.JPA;
import repositories.exceptions.*;

import java.lang.reflect.ParameterizedType;

public class BaseRepositoryImplementation<M> implements BaseRepository<M> {


	private Class<M> getParameterizedClass() {
	    return (Class<M>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	  }

	  public M findById(Long id) {
	    return JPA.em().find(getParameterizedClass(), id);
	  }

	  protected Criteria getBaseCriteria() {
	    Session session = ((HibernateEntityManager) JPA.em()).getSession();
	    return session.createCriteria(getParameterizedClass());
	  }
	  
	  // Impl create-a
	  public void create(M model) {
	    try {
	      JPA.em().persist(model);
	      JPA.em().flush();
	    } catch (PersistenceException e) {
	      //throw new RepositoryException(e);
	    }
	  }
	  
	// Impl update-a
	  public void update(M model) {
	    try {
	      JPA.em().merge(model);
	      JPA.em().flush();
	    } catch (PersistenceException e) {
	      //throw new RepositoryExceptionn("error");
	    }
	  }

	  // Impl delete-a
	  public void delete(M model) {
	    try {
	      JPA.em().remove(model);
	      JPA.em().flush();
	    } catch (PersistenceException e) {
	      //throw new RepositoryException(e);
	    }
	  }
}
	  