package services;

import models.Comment;
import play.mvc.Http;
import repositories.CommentRepository;
import repositories.exceptions.RepositoryException;
import services.exceptions.ServiceException;

import javax.inject.Inject;
import java.util.Date;

public class CommentService extends BaseService<Comment, CommentRepository> {
    private AccountService accountService;

    @Inject
    public void setAccountService(AccountService service) { this.accountService=service;}

    public Comment create(Comment model, Http.Session session) throws ServiceException{
        try {
            model.setInsertTime(new Date());
            model.setAccount(accountService.getCurrentUser(session.get("username")));
            repository.create(model);
            return model;
        } catch (RepositoryException e) {
            logger.error("Repository exception in CommentService@create", e);
            throw new ServiceException("Service couldn't create model.", e);
        }
    }


}
