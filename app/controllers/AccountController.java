package controllers;

import javax.inject.Inject;

import org.mindrot.jbcrypt.Bcrypt;

import models.Account;
import play.mvc.BodyParser;
import play.mvc.Http.Session;
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
	public Result login(){
		try{
			Form<Account> form = formFactory.form(Account.class).bindFromRequest();
			if (form.hasErrors()) {
				Logger.error("Form error");
				return badRequest(Json.toJson("Form error"));
			}
			return ok(Json.toJson(service.getByEmailAndPassword(form.get(),session())));
		}
		catch(ServiceException e){
			Logger.error("Service error in AccountController@login");
			return badRequest(Json.toJson(""));
		}
		catch(Exception e) {
			Logger.error("Error in AccountController@login");
            return internalServerError(Json.toJson("Internal server error in AccountController@login"));
        }
		
	}
	
   public Result register(){
	   try{
		   Form<Account> form=formFactory.form(Account.class).bindFromRequest();
		   if (form.hasErrors()) {
			   Logger.error("Form error");
			   return badRequest(Json.toJson("Form error"));
		   }
		   form.get().setPassword((BCrypt.hashpw(form.get().getPassword(), BCrypt.gensalt())));
		   return ok(Json.toJson(service.create(form.get())));
	   }
	   catch(ServiceException e){
		   Logger.error("Service error in AccountController@register");
			return badRequest(Json.toJson(""));
		}
		catch(Exception e) {
			Logger.error("Error in AccountController@login");
           return internalServerError(Json.toJson("Internal server error in AccountController@register"));
	   }
   }
}
