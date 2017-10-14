package repositories;

import com.google.inject.ImplementedBy;
import models.Restaurant;
import services.exceptions.ServiceException;

@ImplementedBy(RestaurantRepositoryImplementation.class)
public interface RestaurantRepository extends BaseRepository<Restaurant> {
}
