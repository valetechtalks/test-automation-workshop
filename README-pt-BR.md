# Exemplos

Este diretório contém exemplos de código em diversas linguagens de programação cobertas pelo workshop.

Favor, adicione exemplos usando a estrutura de diretórios a seguir:

- Linguagem de Programação
  + Projeto / Nome do exemplo
    * Códigos

# Sorteador de prêmios

A aplicação deve obter a lista de RSVPs do meetup.com e salvar em um banco de dados (Relacional ou em memória).

- Endpoint ou background job capaz de buscar e salvar os participantes do evento em um banco de dados (Relacional ou em memória).
  - Regras:
    - O nome deve ser único;
    - Não pode repetir o mesmo participante;
  - Atributos do participante:
    - name { Nome } [String] (Não pode ser nulo);
    - languages { Resposta da pergunta "Quais linguagens de programação você usa?" } [Array] (Default [] - Não pode ser nullo);
    - awarded { Já ganhou recebeu algum prêmio } [Boolean] (Default é false - Não pode ser nullo);

Exemplo casos for um endpoint: `[POST] \refresh\`

Url para buscar participantes: https://api.meetup.com/valetechtalks/events/268854460/rsvps?&sign=true&photo-host=public&fields=answers

- Endpoint capaz de inserir participantes que não confirmaram presença via o Meetup.com [Opcional] 

Rota: `[POST] \attendees\`

Body: 
```
{
  name: "Foobar"
}
```

- Endpoint capaz de obter a lista de participates.

Rota: `[GET] \attendees\`

Resposta:
```
[
  { name: "Foo", languages: ["Python", "C#"], awarded: false },
  { name: "Bar", languages: ["Java", "PHP"], awarded: true }
]
```

- Endpoint capaz de filter por participate com filtros [Opcional].

Rota: `[GET] \attendees?name=Foo&languages=Python&awarded=false`

Resposta:
```
[
  { name: "Foo", languages: ["Python", "C#"], awarded: false }
]
```
  - Parâmetros de pesquisa:
    - name (String)
    - languages (String)
    - awarded (Boolean)
    
- Endpoint capaz de filtrar por participate com filtros [Opcional].

Rota: `[GET] \attendees?name=Foo&languages=Python&awarded=false`

Resposta:
```
[
  { name: "Foo", languages: ["Python", "C#"], awarded: false }
]
```
  - Parâmetros de pesquisa:
    - name (String)
    - languages (String)
    - awarded (Boolean)
    
- Endpoint capaz de listar as linguagens mais usadas [Opcional].

Rota: `[GET] \languages\`

Resposta:
```
[
  { name: "Python", attendants_using: 10 },
  { name: "Java", attendants_using: 8 }
]
```
A resposta precisa vir ordenada por quantidade de participantes usando a linguagem.

- Endpoint capaz de sortear o prêmio.

Rota: `[POST] \draw\`

Resposta:
```
[
  { name: "Foo" }
]
```
  - Após sorteado o participante não poderá mais receber prêmios e o atributo awarded dele deve ser marcado como true.
