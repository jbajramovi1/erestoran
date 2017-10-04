package repositories;

import org.hibernate.criterion.Restrictions;
import org.mindrot.jbcrypt.*;

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
		Account acc= (Account) getBaseCriteria()
    			.add(Restrictions.eq("email", account.getEmail()))
    			.uniqueResult();
		if(acc != null && BCrypt.checkpw("password", account.getPassword())) {
            return account;
        }

        return null;
	}
	
}