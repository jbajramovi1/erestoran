package services;

import javax.inject.Inject;
import javax.inject.Singleton;

import models.BaseModel;
import org.slf4j.LoggerFactory;
import repositories.BaseRepository;
import repositories.exceptions.RepositoryException;
import services.exceptions.ServiceException;

@Singleton
public abstract class BaseService<M extends BaseModel<M>, R extends BaseRepository<M>> {
	protected R repository;
	final org.slf4j.Logger logger = LoggerFactory.getLogger(BaseService.class);
	@Inject
	public void setRepository(R repository) {
		this.repository = repository;
	}

	public M get(Long id) throws ServiceException  {

		M model = repository.findById(id);
	
	    if (model != null) {
	      return model;
	    }

		logger.error("Service exception in BseService@get");
	    throw new ServiceException("Service Exception BaseService@get");
	  }
	
	public M create(M model) throws ServiceException {
        try {
            repository.create(model);
            return model;
        } catch(RepositoryException e) {
            throw new ServiceException("Service couldn't create model.", e);
        }
    }
	
	public M update(Long id, M data) throws ServiceException {
        try {
            M model = get(id);
            if(model == null) {
                throw new ServiceException("Service couldn't find model [" + id + "].");
            }
            model.update(data);
            repository.update(model);
            return model;
        } catch(RepositoryException e) {
            throw new ServiceException("Service couldn't update model.", e);
        }
    }
	
	 public void delete(Long id) throws ServiceException {
	        try {
	            M model = get(id);
	            if(model == null) {
	                throw new ServiceException("Service couldn't find model [" + id + "].");
	            }
	            repository.delete(model);
	        } catch(RepositoryException e) {
	            throw new ServiceException("Service couldn't find model [" + id + "].", e);
	        }
	    }
}