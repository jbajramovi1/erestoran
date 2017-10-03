package services;

import org.hibernate.criterion.Restrictions;


import models.Account;
import play.Logger;
import play.mvc.Http.Session;
import repositories.AccountRepository;
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
}
