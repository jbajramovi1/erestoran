package repositories;

import com.google.inject.ImplementedBy;
import models.Restaurant;

@ImplementedBy(RestaurantRepositoryImplementation.class)
public interface RestaurantRepository extends BaseRepository<Restaurant> {
}
