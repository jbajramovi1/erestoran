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
	  
	  public Session getSession()
	    {
	        return JPA.em().unwrap(Session.class);
	    }
	  
	  // Impl create-a
	  public void create(M model) throws RepositoryException {
	    try {
	      JPA.em().persist(model);
	      JPA.em().flush();
	    } catch (PersistenceException e) {
	      throw new RepositoryException(e.toString());
	    }
	  }
	  
	// Impl update-a
	  public void update(M model) throws RepositoryException {
	    try {
	      JPA.em().merge(model);
	      JPA.em().flush();
	    } catch (PersistenceException e) {
	      throw new RepositoryException(e.toString());
	    }
	  }

	  // Impl delete-a
	  public void delete(M model) throws RepositoryException {
	    try {
	      JPA.em().remove(model);
	      JPA.em().flush();
	    } catch (PersistenceException e) {
	      throw new RepositoryException(e.toString());
	    }
	  }
}
	  