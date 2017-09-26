package repositories;

import com.google.inject.ImplementedBy;

@ImplementedBy(BaseRepositoryImplementation.class)
public interface BaseRepository<M> { 
  
	M findById(Long id);
}