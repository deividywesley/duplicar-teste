package br.com.api.transaction.business.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountDTO {

  private Long id;
  private String documentNumber;

}
