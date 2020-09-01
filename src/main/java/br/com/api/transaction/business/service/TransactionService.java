package br.com.api.transaction.business.service;

import br.com.api.transaction.business.dto.TransactionDTO;
import br.com.api.transaction.business.entity.Account;
import br.com.api.transaction.business.entity.Transaction;
import br.com.api.transaction.business.enumeration.OperationType;
import br.com.api.transaction.business.exception.AccountNotFoundException;
import br.com.api.transaction.business.exception.OperationTypeNotFoundException;
import br.com.api.transaction.business.exception.TransactionAmountInvalidException;
import br.com.api.transaction.business.repository.TransactionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {

  @NonNull
  private final TransactionRepository transactionRepository;

  @NonNull
  private final AccountService accountService;

  public TransactionDTO save(TransactionDTO transactionDTO) {
    return entityToDTO(transactionRepository.save(dtoToEntity(transactionDTO)));
  }

  private Transaction dtoToEntity(final TransactionDTO transactionDTO) {

    Long accountId = Optional.ofNullable(transactionDTO.getAccountId()).orElseThrow(AccountNotFoundException::new);
    Account account = accountService.findOptionalById(transactionDTO.getAccountId())
        .orElseThrow(AccountNotFoundException::new);

    int operationTypeId = Optional.ofNullable(transactionDTO.getOperationTypeId()).orElseThrow(
        OperationTypeNotFoundException::new);
    OperationType operationType = OperationType.findById(operationTypeId);

    BigDecimal amount = Optional.ofNullable(transactionDTO.getAmount())
        .map(o -> calculateAmount(operationType, transactionDTO.getAmount()))
        .orElseThrow(TransactionAmountInvalidException::new);

    Transaction transaction = Transaction
        .builder()
        .account(account)
        .operationType(operationType)
        .eventDate(LocalDateTime.now())
        .amount(amount)
        .build();

    return transaction;

  }

  private TransactionDTO entityToDTO(final Transaction transaction) {
    return TransactionDTO.builder()
        .id(transaction.getId())
        .accountId(transaction.getAccount().getId())
        .operationTypeId(transaction.getOperationType().getId())
        .amount(transaction.getAmount())
        .eventDate(transaction.getEventDate())
        .build();
  }

  private final BigDecimal calculateAmount(OperationType operationType, BigDecimal amount) {
    return operationType.isNegative() ? amount.negate() : amount.abs();
  }

}
