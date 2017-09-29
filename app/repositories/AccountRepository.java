package repositories;

import org.hibernate.criterion.Restrictions;

import models.Account;
import services.exceptions.ServiceException;

public class AccountRepository extends BaseRepositoryImplementation<Account>{

	public Account getByEmail(Account account) {
	       
    	return (Account) getBaseCriteria()
            .add(Restrictions.eq("email", account.getEmail())
            .uniqueResult();
           
}
	
	public Account getByEmailAndPassword(Account account) {
       
        	return (Account) getBaseCriteria()
                .add(Restrictions.eq("email", account.getEmail())
                .add(Restrictions.eq("password",account.getPassword())
                .uniqueResult();
               
    }
	
}
