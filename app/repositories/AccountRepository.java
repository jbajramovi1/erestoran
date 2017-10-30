package repositories;

import com.google.inject.ImplementedBy;

import models.Account;
import play.mvc.Http;

@ImplementedBy(AccountRepositoryImplementation.class)
public interface AccountRepository extends BaseRepository<Account> {
    public Account getByEmail(Account account);

    public Account getByEmailAndPassword(Account account);
    public Account getCurrentUser(String email);
}
