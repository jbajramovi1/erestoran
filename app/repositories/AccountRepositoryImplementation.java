package repositories;

import org.hibernate.criterion.Restrictions;

import models.Account;
import services.exceptions.ServiceException;

public class AccountRepositoryImplementation extends BaseRepositoryImplementation<Account> implements AccountRepository{


	
	

	@Override
	public Account getByEmail(Account account) {
		return (Account) getBaseCriteria()
				.add(Restrictions.eq("email",account.getEmail())).uniqueResult();
		
	}

	@Override
	public Account getByEmailAndPassword(Account account) {
		return (Account) getBaseCriteria()
    			.add(Restrictions.eq("email", account.getEmail())).add(
    			Restrictions.eq("password",account.getPassword())).uniqueResult();
	}
	
}