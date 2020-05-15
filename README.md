# LetsGoApi

Api feita para o projeto de eventos, quando for editar, enviar o id do objeto junto no JSON, Exemplo:
```JSON
{
	"id": 1,
	"nome": "Fabio",
	"sobrenome": "lopes",
	"email": "binhopecoraaa@gmail.com",
	"telefone": "(13) 981725946",
	"senha": "123456",
	"papel": { "id": 1 },
	"dataNascimento": "1997-04-18"
}
```

## Rotas

<strong>Usuario</strong>
| METHOD       | URL           |
| ------------- |:-------------:|
| GET  |  [`localhost:8080/usuario/{id} `](#usuario) | 
| POST |  [`localhost:8080/usuario `](#usuario)     | 
| PUT  |  [`localhost:8080/usuario `](#usuario)     | 
| DEL  |  [`localhost:8080/usuario/{id} `](#usuario) |

<strong>Casa De Show</strong>
| METHOD       | URL           |
| ------------- |:-------------:|
| GET  |  [`localhost:8080/casadeshow `](#casa-de-show) | 
| GET  |  [`localhost:8080/casadeshow/{id} `](#casa-de-show) | 
| GET  |  [`localhost:8080/usuario/{id}/casadeshow`](#casa-de-show) |  
| POST |  [`localhost:8080/casadeshow/`](#casa-de-show)     | 
| PUT  |  [`localhost:8080/casadeshow/`](#casa-de-show)      |  
| DELETE  |  [`localhost:8080/casadeshow/{id}`](#casa-de-show) |

<strong>Evento</strong>
| METHOD       | URL           |
| ------------- |:-------------:|
| GET  |  [`localhost:8080/evento`](#evento) |
| GET  |  [`localhost:8080/casadeshow/{id}/evento`](#evento) |
| GET  |  [`localhost:8080/evento/{id}`](#evento) |
| POST |  [`localhost:8080/evento`](#evento) |
| PUT  |  [`localhost:8080/evento`](#evento) |
| DELETE  |  [`localhost:8080/evento/{id}`](#evento) |

<strong>Pedido</strong>
| METHOD       | URL           |
| ------------- |:-------------:|
| GET  |  [`localhost:8080/pedido`](#pedido) |
| GET  |  [`localhost:8080/pedido/{id}`](#pedido) |
| GET  |  [`localhost:8080/usuario/{id}/pedido`](#pedido) |
| POST |  [`localhost:8080/pedido`](#pedido) |
| PUT  |  [`localhost:8080/pedido`](#pedido) |
| DELETE  |  [`localhost:8080/pedido/{id}`](#pedido) |


### Usuario
Exemplo:
```json
{
	"nome": "Fabio",
	"sobrenome": "lopes",
	"email": "binhopecoraaa@gmail.com",
	"telefone": "(13) 981725946",
	"senha": "123456",
	"papel": { "id": 1 },
	"dataNascimento": "1997-04-18"
}
```
### Casa De Show
Exemplo:
```json
{
	"nome": "Jhosons Bar",
	"cep" : "11707090",
	"endereco": "Av. São Romério",
	"numero": 143,
	"cidade": "Praia Grande",
	"estado": "SP",
	"capacidade" : 5000,
	"imagemCasaDeShow": [ 120, 43, 12, 14, 87, 93, 55],
	"usuario": { "id": 1 }
}
```
### Evento
Exemplo:
```json
{
	"nome": "Rock in Rio",
	"descricao": "Melhor evento de rock da região",
	"dataInicio" : "2020-08-25T22:00:00",
	"dataFim" : "2020-08-26T00:00:00",
	"quantidadeIngressos" : 200,
	"quantidadeIngressosInicial": 200,
	"preco": 25.20,
	"casaDeShow": { "id": 1 },
	"imagemEvento": [ 1, 2, 3, 4, 5, 6]
}
```
### Pedido
Exemplo:
```json
{
	"usuario": { "id": 3 },
	"dataCompra": "2020-05-14T20:00:00",
	"quantidadeIngressos" : 1,
	"evento": { "id": 1 }
}
```
