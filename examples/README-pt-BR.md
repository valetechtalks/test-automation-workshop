# Exemplos

Este diretório contém exemplos de código em diversas linguagens de programação cobertas pelo workshop.

Favor, adicione exemplos usando a estrutura de diretórios a seguir:

- Linguagem de Programação
  + Projeto / Nome do exemplo
    * Códigos

# Sorteador de prêmios

A aplicação deve obter a lista de RSVPs do meetup.com e salvar em um banco de dados (Relacional ou em memória).


## Modelo de dados

O modelo do banco de dados pode variar ligeiramente de uma aplicação para outra.

- `attendees` tabela de participante
  + `name` (texto, requerido) nome do participante
  + `vendor_user_id` (texto, requerido, único) id de usuário do meetup.com
  + `rsvp_answer` (texto, opcional) resposta para a pergunta no momento da inscrição
  + `awarded` (boolean, requerido) verdadeiro se participante já recebeu um prêmio
  + `image_url` (string, opicional) url da imagem do participante


## Endpoints

### `GET /attendees`

- (obrigatório) Obtém a lista completa de participantes
- (opcional) Filtra a lista por campos (exemplo: `name`)

Resposta:
```json
[
  { "name": "Foo", "vendor_user_id": 999, "awarded": false },
  { "name": "Bar", "vendor_user_id": 999, "awarded": true }
]
```

### `POST /attendees`

- (opcional) Adiciona um novo participante à base de dados

Body: 
```json
{
  "name": "Foobar"
}
```

### `GET /attendees/awarded`

- (obrigatório) Obtém a lista de participantes premiados, em ordem decrescente

Resposta:
```json
[
  { "name": "Foo", "vendor_user_id": 999, "awarded": true },
  { "name": "Bar", "vendor_user_id": 999, "awarded": true }
]
```

### `POST /attendees/draw`

- (obrigatório) Sorteia um participante aleatório da lista
- (obrigatório) Marca `awarded = true` para o participante sorteado

Uma vez premiado, um participante não pode ser sorteado novamente.

Resposta:
```json
[
  { "name": "Bar", "vendor_user_id": 999, "awarded": true }
]
```

### `POST /refresh`

- (obrigatório) Sincroniza / atualiza a lista de participantes pelo meetup.com

Url para obter lista de participantes:

- https://api.meetup.com/valetechtalks/events/268854460/rsvps?&sign=true&photo-host=public&fields=answers

