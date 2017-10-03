package repositories;

import org.hibernate.criterion.Restrictions;

import com.google.inject.ImplementedBy;

import models.Account;
import services.exceptions.ServiceException;

@ImplementedBy(AccountRepositoryImplementation.class)
public interface AccountRepository extends BaseRepository<Account> {
	public Account getByEmail(Account account);
	public Account getByEmailAndPassword(Account account);
}
