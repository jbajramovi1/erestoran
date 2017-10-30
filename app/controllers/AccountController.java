package controllers;

import models.Account;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import services.AccountService;
import services.exceptions.ServiceException;

public class AccountController extends BaseController<Account, AccountService> {
    @Transactional(readOnly = true)
    public Result login() {
        try {
            Form<Account> form = formFactory.form(Account.class).bindFromRequest();
            if (form.hasErrors()) {
                logger.error("Login attempt failed, form has errors.", form.errors());
                return badRequest(form.errorsAsJson());
            }
            return ok(Json.toJson(service.getByEmailAndPassword(form.get(), session())));
        } catch (ServiceException e) {
            logger.error("Service error in AccountController@login", e);
            return badRequest(Json.toJson(""));
        } catch (Exception e) {
            logger.error("Error in AccountController@login", e);
            return internalServerError(Json.toJson("Internal server error in AccountController@login"));
        }

    }

    @Transactional
    public Result register() {
        try {
            Form<Account> form = formFactory.form(Account.class).bindFromRequest();
            if (form.hasErrors()) {
                logger.error("Login attempt failed, form has errors.", form.errors());
                return badRequest(form.errorsAsJson());
            }

            return ok(Json.toJson(service.create(form.get())));
        } catch (ServiceException e) {
            logger.error("Service error in AccountController@register", e);
            return badRequest(Json.toJson(""));
        } catch (Exception e) {
            logger.error("Error in AccountController@register", e);
            return internalServerError(Json.toJson("Internal server error in AccountController@register"));
        }
    }

    @Transactional
    public Result logout(){

        session().clear();
        return ok();
    }

    @Transactional
    public Result getUserSession(){
        Long sessionId=Long.parseLong(session().get("id"));
        try {
            return ok(Json.toJson(service.get(sessionId)));
        }
        catch (ServiceException e) {
            logger.error("Service error in AccountController@session", e);
            return badRequest(Json.toJson(""));
        } catch (Exception e) {
            logger.error("Error in AccountController@session", e);
            return internalServerError(Json.toJson("Internal server error in AccountController@session"));
        }
    }

}
