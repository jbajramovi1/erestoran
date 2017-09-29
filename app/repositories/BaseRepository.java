package repositories;

import com.google.inject.ImplementedBy;

import repositories.exceptions.RepositoryException;

@ImplementedBy(BaseRepositoryImplementation.class)
public interface BaseRepository<M> { 
  
	M findById(Long id);
	void create(M model) throws RepositoryException;
	void update(M model) throws RepositoryException;
	void delete(M model) throws RepositoryException;
	
}