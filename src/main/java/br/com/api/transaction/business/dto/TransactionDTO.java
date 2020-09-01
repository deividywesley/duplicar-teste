package br.com.api.transaction.business.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
public class TransactionDTO {

  private Long id;
  private Long accountId;
  private Integer operationTypeId;
  private BigDecimal amount;
  private LocalDateTime eventDate;

}
