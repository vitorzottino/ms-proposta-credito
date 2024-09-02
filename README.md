
# ms-proposta-credito

Simple API rest developed to practice in classes

## API Reference

#### Get all users

```http
  GET /localhost:8080/users
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|  |  | Retrieve a list of all users|

#### Get user by id

```http
  GET localhost:8080/users/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | Get the full *User* info |

#### Delete user by id if exists

```http
  DELETE localhost:8080/users/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | Delete *User* if exists |

#### Update user by id if exists

```http
  PUT localhost:8080/users/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | Update *User* if exists | 

```
JSON BODY FOR UPDATE
{
    "nome": "Nome",
    "sobrenome": "Sobrenome",
    "cpf": "XXXXXXXXXXX",
    "telefone": "XXXXXXXXXXX",
    "renda": 9999.99
}
```
#### Insert a new user

```http
  POST localhost:8080/users
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | Insert *User* | 

```
JSON BODY FOR INSERT
{
    "nome": "Nome",
    "sobrenome": "Sobrenome",
    "cpf": "XXXXXXXXXXX",
    "telefone": "XXXXXXXXXXX",
    "renda": 9999.99
}
```

#### Get all propostas

```http
  GET /localhost:8080/propostas
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|  |  | Retrieve a list of all propostas|


#### Get proposta by id

```http
  GET localhost:8080/propostas/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | Get the full *Proposta* info |

#### Delete Proposta by id if exists

```http
  DELETE localhost:8080/propostas/{id}
```

| Parameter | Type     | Description                 |
| :-------- | :------- |:----------------------------|
| `id`      | `string` | Delete *Proposta* if exists |


#### Update proposta by id if exists

```http
 PUT localhost:8080/propostas/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | Update *Proposta* by Id if exists | 

```
JSON BODY FOR UPDATE
{
    "valorSolicitado": 10,
    "prazoParaPagamento": 10,
    "aprovado": true
}
```
#### Insert a new proposta

```http
  POST localhost:8080/propostas
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | Insert *Proposta* | 

```
JSON BODY FOR INSERT
{
    "nome": "Nome",
    "sobrenome": "Sobrenome",
    "cpf": "XXXXXXXXXXX",
    "telefone": "XXXXXXXXXXX",
    "renda": 9999.99
    "valorSolicitado": 10,
    "prazoParaPagamento": 2
}