package controllers;

import models.Reservation;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import services.ReservationService;
import services.exceptions.ServiceException;

public class ReservationController extends BaseController<Reservation, ReservationService>{
    @Override
    public Result create() {
        try {
            Form<Reservation> form = formFactory.form(Reservation.class).bindFromRequest();
            if (form.hasErrors()) {
                return badRequest(form.errorsAsJson());
            }
            return ok(Json.toJson(service.create(form.get())));
        } catch (ServiceException e) {
            logger.error("Service error in ReservationController@create",e);
            return badRequest("Service error in ReservationController@create");
        } catch (Exception e) {
            logger.error("Internal server error in ReservationController@create",e);
            return internalServerError("Internal server error in ReservationController@create");
        }
    }
}
