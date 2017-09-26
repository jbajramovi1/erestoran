package services;

import javax.inject.Singleton;

import org.hibernate.service.spi.ServiceException;

import models.BaseModel;
import play.Logger;
import repositories.BaseRepository;

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
}