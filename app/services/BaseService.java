package services;

import javax.inject.Singleton;

import org.hibernate.service.spi.ServiceException;

import models.BaseModel;
import play.Logger;
import repositories.BaseRepository;
import repositories.exceptions.RepositoryException;

@Singleton
public abstract class BaseService<M extends BaseModel<M>, R extends BaseRepository<M>> {
	protected R repository;

	public M get(Long id)  {
	    M model = repository.findById(id);
	
	    if (model != null) {
	      return model;
	    }
	
	    //Logger.error(message);
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