# Criar Conta

**URL** : `/transactions`

**Método** : `POST`

#### Dados da requisição:

`accountId`: Código da conta.
`amount`: Valor da transação.
`operationTypeId`: Tipo de operação. Possíveis valores:

| Valor | Descrição        |
| ----- | ---------------- |
| 1     | COMPRA_A_VISTA   |
| 2     | COMPRA_PARCELADA |
| 3     | SAQUE            |
| 4     | PAGAMENTO        |

### SUCESSO

**Código** : `200`

**Request Body**

```
{
	"accountId":"1", 
	"operationTypeId":"1",
	"amount":"100.25"
}
```
**Response Body**

```
{
    "id": 3,
    "accountId": 1,
    "operationTypeId": 1,
    "amount": -100.25,
    "eventDate": "2020-08-24T22:15:09.9598498"
}
```


### ERROS DE NEGÓCIO

#### Conta não encontrada!

**Código** : `400`

**Request Body**
```
{"accountId":"999", "operationTypeId":"1","amount":"100.25"}
```
**Response Body**
```
{"message": "Conta não encontrada!"}
```

#### Tipo de operação inválido!

**Código** : `400`

**Request Body**
```
{"accountId":"1", "operationTypeId":"5","amount":"100.25"}
```
**Response Body**
```
{"message": "Tipo de operação inválido!"}
```

#### Valor da transação inválido!

**Código** : `400`

**Request Body**
```
{"accountId":"1", "operationTypeId":"5","amount":""}
```
**Response Body**
```
{"message": "Valor da transação inválido!"}
```