package controllers;

import models.Comment;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import services.CommentService;
import services.exceptions.ServiceException;

public class CommentController extends BaseController<Comment, CommentService>{

    @Override
    public Result create() {
        try {
            Form<Comment> form = formFactory.form(Comment.class).bindFromRequest();
            if (form.hasErrors()) {
                return badRequest(form.errorsAsJson());
            }
            return ok(Json.toJson(service.create(form.get(),session())));
        } catch (ServiceException e) {
            logger.error("Service error in BaseController@create",e);
            return badRequest("Service error in BaseController@create");
        } catch (Exception e) {
            logger.error("Internal server error in BaseController@create",e);
            return internalServerError("Internal server error in BaseController@create");
        }
    }

}
