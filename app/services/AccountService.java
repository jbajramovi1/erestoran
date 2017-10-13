package services;

import models.Role;
import org.hibernate.criterion.Restrictions;

import org.mindrot.jbcrypt.*;
import models.Account;
import play.Logger;
import play.mvc.Http.Session;
import repositories.AccountRepository;
import repositories.exceptions.RepositoryException;
import services.exceptions.ServiceException;


public class AccountService extends BaseService<Account, AccountRepository> {

	public Account getByEmail(Account data) throws ServiceException {
		Account account=repository.getByEmail(data);
		if (account==null){
			throw new ServiceException("entity not found");
	
		}
		
		return account;
    }
	
	public Account getByEmailAndPassword(Account data,Session session) throws ServiceException{
		
		Account account=repository.getByEmailAndPassword(data);
		if (account==null){
			Logger.error("entity not found",data.getEmail(),data.getPassword());
			throw new ServiceException("entity not found");
	
		}
		session.clear();
        session.put("username",account.getEmail());
		return account;
	}

	@Override
	public Account create(Account model) throws ServiceException {
		try {
			model.setPassword((BCrypt.hashpw(model.getPassword(), BCrypt.gensalt())));
			if (model.getRole()==null) {
			}
			repository.create(model);
			return model;
		} catch(RepositoryException e) {
			Logger.error("Repository exception in AccountService@create",e);
			throw new ServiceException("Service couldn't create model.", e);
		}
	}
}
