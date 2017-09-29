package services;

import org.hibernate.criterion.Restrictions;


import models.Account;
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
	
	public Account getByEmailAndPassword(Account data) throws ServiceException{
		
		Account account=repository.getByEmailAndPassword(data);
		if (account==null){
			throw new ServiceException("entity not found");
	
		}
		
		return account;
	}
}
