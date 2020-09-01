package br.com.api.transaction.business.repository;

import br.com.api.transaction.business.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
