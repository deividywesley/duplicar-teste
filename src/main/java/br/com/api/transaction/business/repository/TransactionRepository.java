package br.com.api.transaction.business.repository;

import br.com.api.transaction.business.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}