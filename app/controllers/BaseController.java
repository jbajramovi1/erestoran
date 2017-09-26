package controllers;

import javax.inject.Singleton;

import models.BaseModel;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.BaseService;


@Singleton
//@Security.Authenticated(Secured.class)
public class BaseController<M extends BaseModel<M>, S extends BaseService> extends Controller {
	protected S service;

	@Transactional(readOnly = true)
	public Result get(Long id) {
		try{
			return ok(Json.toJson(service.get(id)));
		}
		catch(Exception e){
			return internalServerError("Internal server error in BaseController@get");
		}
	}    
}
