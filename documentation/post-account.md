# Criar Conta

Criação de uma conta através de um endpoint que aceita os dados da conta em formato JSON.

**URL** : `/accounts`

**Método** : `POST`

#### Dados da requisição:

`documentNumber`: Código do documento. Informar apenas números.

### SUCESSO

**Código** : `200`

**Request Body**

```
{ "documentNumber":"1234567890" }
```
**Response Body**

```
{ "id": 5,"documentNumber": "1234567890" }
```
### ERRO

**Código** : `400`

**Request Body**

```
{ "documentNumber":"ABC" }
```
**Response Body**

```
{ "message": "Número de documento não informado ou inválido!" }
```
