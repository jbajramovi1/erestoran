package repositories;

import com.google.inject.ImplementedBy;
import models.Reservation;

@ImplementedBy(ReservationRepositoryImplementation.class)
public interface ReservationRepository extends BaseRepository<Reservation> {
}
