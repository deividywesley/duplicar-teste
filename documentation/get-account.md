# Consulta de informações de uma conta

Consulta todas as informações da conta.

**URL** : `/accounts/:accountId`

**Método** : `GET`

#### Dados da requisição:

`accountId`: Código da conta a ser consultada.

### SUCESSO

**Código** : `200 - OK`

**Response body:**

```
{
    "id": 5,
    "documentNumber": "1234567890"
}
```
### ERRO

**Código** : `400 - BAD REQUEST`

**Response Body:**

```
{
    "message": "Conta não encontrada!"
}
```
