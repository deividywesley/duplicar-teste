package br.com.api.transaction.business.exception;

public class InvalidDocumentNumber extends ApplicationException {

  private static final String errorMsg = "Número de documento não informado ou inválido!";

  public InvalidDocumentNumber() {
    super(errorMsg);
  }
}
