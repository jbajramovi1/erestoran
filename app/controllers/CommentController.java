package controllers;

import models.Comment;
import play.Logger;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import services.CommentService;
import services.exceptions.ServiceException;

public class CommentController extends BaseController<Comment, CommentService>{


}
