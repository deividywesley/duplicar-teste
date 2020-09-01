package br.com.api.transaction.business.enumeration;

import br.com.api.transaction.business.exception.OperationTypeNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum OperationType {

  NAO_UTILIZAR(0),
  COMPRA_A_VISTA(1),
  COMPRA_PARCELADA(2),
  SAQUE(3),
  PAGAMENTO(4);

  private int id;

  public static OperationType findById(final int id) {
    switch (id) {
      case 1:
        return COMPRA_A_VISTA;
      case 2:
        return COMPRA_PARCELADA;
      case 3:
        return SAQUE;
      case 4:
        return PAGAMENTO;
      default:
        throw new OperationTypeNotFoundException();
    }
  }

  public boolean isNegative() {
    return Arrays.asList(COMPRA_A_VISTA, COMPRA_PARCELADA, SAQUE).contains(this);
  }

}