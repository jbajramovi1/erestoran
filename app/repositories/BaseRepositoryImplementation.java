package repositories;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.jpa.HibernateEntityManager;
import org.slf4j.LoggerFactory;
import play.db.jpa.JPA;
import repositories.exceptions.RepositoryException;
import java.lang.reflect.ParameterizedType;

public class BaseRepositoryImplementation<M> implements BaseRepository<M> {
    final org.slf4j.Logger logger = LoggerFactory.getLogger(BaseRepositoryImplementation.class);
    private Class<M> getParameterizedClass() {
        return (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public M findById(Long id) {
        return JPA.em().find(getParameterizedClass(), id);
    }

    protected Criteria getBaseCriteria() {
        Session session = ((HibernateEntityManager) JPA.em()).getSession();
        return session.createCriteria(getParameterizedClass());
    }

    public Session getSession() {
        return JPA.em().unwrap(Session.class);
    }

    public void create(M model) throws RepositoryException {
        try {
            JPA.em().persist(model);
            JPA.em().flush();
        } catch (PersistenceException e) {
            logger.error("ServiceException in BaseRepository@create", e);
            throw new RepositoryException(e.toString());
        }
    }

    public void update(M model) throws RepositoryException {
        try {
            JPA.em().merge(model);
            JPA.em().flush();
        } catch (PersistenceException e) {
            logger.error("ServiceException in BaseRepository@update", e);
            throw new RepositoryException(e.toString());
        }
    }

    public void delete(M model) throws RepositoryException {
        try {
            JPA.em().remove(model);
            JPA.em().flush();
        } catch (PersistenceException e) {
            logger.error("ServiceException in BaseRepository@delete", e);
            throw new RepositoryException(e.toString());
        }
    }
}
