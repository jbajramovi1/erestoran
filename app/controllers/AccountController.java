package controllers;

import javax.inject.Inject;

import models.Account;
import play.mvc.BodyParser;
import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.data.FormFactoryModule;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import services.AccountService;
import services.exceptions.ServiceException;
import services.exceptions.*;
public class AccountController extends BaseController<Account, AccountService> {
	
	
	@Transactional(readOnly=true)
    @BodyParser.Of(BodyParser.Json.class)
	public Result login(){
		try{
			if (FORM.hasErrors()) {
				Logger.error("form");
				return badRequest(Json.toJson("form error"));
			}
			return ok(Json.toJson(service.getByEmailAndPassword(FORM.get())));
		
		}
		catch(ServiceException e){
			return badRequest(Json.toJson(""));
		}
		catch(Exception e) {
			//logger
            return internalServerError(Json.toJson("Internal server error in AccountController@login"));
        }
		
	}
}
