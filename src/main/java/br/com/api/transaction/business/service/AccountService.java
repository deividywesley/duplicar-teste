package br.com.api.transaction.business.service;

import br.com.api.transaction.business.dto.AccountDTO;
import br.com.api.transaction.business.entity.Account;
import br.com.api.transaction.business.exception.AccountNotFoundException;
import br.com.api.transaction.business.exception.InvalidDocumentNumber;
import br.com.api.transaction.business.repository.AccountRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

  @NonNull
  private final AccountRepository accountRepository;

  public AccountDTO findById(Long id) {
    return findOptionalById(id).map(this::entityToDTO)
        .orElseThrow(AccountNotFoundException::new);
  }

  public AccountDTO save(AccountDTO accountDTO) {
    return entityToDTO(accountRepository.save(dtoToEntity(accountDTO)));
  }

  public Optional<Account> findOptionalById(Long id) {
    return accountRepository.findById(id);
  }

  private Account dtoToEntity(final AccountDTO accountDTO) {
    if (StringUtils.isEmpty(accountDTO.getDocumentNumber()) || !StringUtils
        .isNumeric(accountDTO.getDocumentNumber())) {
      throw new InvalidDocumentNumber();
    }
    return Account.builder().id(accountDTO.getId()).documentNumber(accountDTO.getDocumentNumber())
        .build();
  }

  private AccountDTO entityToDTO(final Account account) {
    return AccountDTO.builder().id(account.getId()).documentNumber(account.getDocumentNumber())
        .build();
  }

}