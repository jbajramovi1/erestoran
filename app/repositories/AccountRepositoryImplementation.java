package repositories;

import play.mvc.Http.Session;
import org.hibernate.criterion.Restrictions;
import org.mindrot.jbcrypt.*;

import models.Account;
import services.exceptions.ServiceException;

public class AccountRepositoryImplementation extends BaseRepositoryImplementation<Account> implements AccountRepository {

    @Override
    public Account getByEmail(Account account) {
        return (Account) getBaseCriteria()
                .add(Restrictions.eq("email", account.getEmail())).uniqueResult();
    }

    @Override
    public Account getByEmailAndPassword(Account account, Session session) {
        Account acc = (Account) getBaseCriteria()
                .add(Restrictions.eq("email", account.getEmail()))
                .uniqueResult();
        if (acc != null && BCrypt.checkpw(account.getPassword(), acc.getPassword())) {
            session.clear();
            session.put("id",acc.getId().toString());
            return account;
        }
        return null;
    }


}