package br.com.api.transaction.business.entity;

import br.com.api.transaction.business.enumeration.OperationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transaction", schema = "api")
@Builder
@AllArgsConstructor
public class Transaction implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "operation_type")
  private OperationType operationType;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "event_date")
  private LocalDateTime eventDate;

  @ManyToOne
  @JoinColumn(name = "account_id")
  private Account account;

  public Transaction() {
  }
}