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
| GET  |  [`/usuario/{id} `](#usuario) | 
| POST |  [`/usuario `](#usuario)     | 
| PUT  |  [`/usuario `](#usuario)     | 
| DEL  |  [`/usuario/{id} `](#usuario) |

<strong>Casa De Show</strong>
| METHOD       | URL           |
| ------------- |:-------------:|
| GET  |  [`/casadeshow `](#casa-de-show) | 
| GET  |  [`/casadeshow/{id} `](#casa-de-show) | 
| GET  |  [`/usuario/{id}/casadeshow`](#casa-de-show) |  
| POST |  [`/casadeshow/`](#casa-de-show)     | 
| PUT  |  [`/casadeshow/`](#casa-de-show)      |  
| DELETE  |  [`/casadeshow/{id}`](#casa-de-show) |

<strong>Evento</strong>
| METHOD       | URL           |
| ------------- |:-------------:|
| GET  |  [`/evento`](#evento) |
| GET  |  [`/casadeshow/{id}/evento`](#evento) |
| GET  |  [`/evento/{id}`](#evento) |
| POST |  [`/evento`](#evento) |
| PUT  |  [`/evento`](#evento) |
| DELETE  |  [`/evento/{id}`](#evento) |

<strong>Pedido</strong>
| METHOD       | URL           |
| ------------- |:-------------:|
| GET  |  [`/pedido`](#pedido) |
| GET  |  [`/pedido/{id}`](#pedido) |
| GET  |  [`/usuario/{id}/pedido`](#pedido) |
| POST |  [`/pedido`](#pedido) |
| PUT  |  [`/pedido`](#pedido) |
| DELETE  |  [`/pedido/{id}`](#pedido) |


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
