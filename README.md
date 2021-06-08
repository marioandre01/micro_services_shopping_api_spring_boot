[![Author](https://img.shields.io/badge/author-marioandre01-00b300?style=flat-square)](https://github.com/marioandre01)
[![Languages](https://img.shields.io/github/languages/count/marioandre01/micro_services_shopping_api_spring_boot?color=%2300b300&style=flat-square)](#)
[![Stars](https://img.shields.io/github/stars/marioandre01/micro_services_shopping_api_spring_boot?color=00b300&style=flat-square)](https://github.com/marioandre01/micro_services_shopping_api_spring_boot/stargazers)
[![Forks](https://img.shields.io/github/forks/marioandre01/micro_services_shopping_api_spring_boot?color=%2300b300&style=flat-square)](https://github.com/marioandre01/micro_services_shopping_api_spring_boot/network/members)
[![Contributors](https://img.shields.io/github/contributors/marioandre01/micro_services_shopping_api_spring_boot?color=00b300&style=flat-square)](https://github.com/marioandre01/micro_services_shopping_api_spring_boot/graphs/contributors)
[![Licence](https://img.shields.io/github/license/marioandre01/micro_services_shopping_api_spring_boot?color=%2300b300&style=flat-square)](https://github.com/marioandre01/micro_services_shopping_api_spring_boot/blob/master/LICENCE.md)


<h1 align="center">
  <img alt="logo-spring" title="logo-spring" src="imgs/logo_spring_boot.svg" width="200px" />
  <br>
  micro_services_shopping_api_spring_boot
</h1>

<p align="center"> 
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-executando-a-aplicação">Executando a aplicação</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#gear-contribuição">Contribuição</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#memo-licença">Licença</a>
</p>

## 💻 Projeto

Este projeto tem como objetivo desenvolver uma aplicação de compras (shopping) como o uso de microserviços utilizando o framework spring boot.

<!-- O resultado da aplicação pode ser acessado através da seguinte URL:  -->

## 📋 Tecnologias

O projeto foi desenvolvido com as seguintes tecnologias:

- [Java](https://www.java.com/pt-BR/)
- [Spring boot](https://spring.io/)
- [Lombok](https://projectlombok.org/)
- [Docker](https://docs.docker.com/engine/install/ubuntu/)
- Postgres (No docker)

<!-- ## 🎨 Layout

### 💻 Web 

<p align="center">
  <img alt="Podcastr web" title="Podcastr web" src="public/podcastr-tela01.png" width="800px">
  <img alt="Podcastr web" title="Podcastr web" src="public/podcastr-tela02.png" width="800px">
  <img alt="Podcastr web" title="Podcastr web" src="public/podcastr-tela03.png" width="800px">
</p>
</p> -->

### :octocat: Clonando o Repositório

```bash
$ git clone https://github.com/marioandre01/micro_services_shopping_api_spring_boot.git

# entre na pasta do projeto
$ cd micro_services_shopping_api_spring_boot
```
### 💻 Executando a aplicação

Com o docker instalado executar:
```bash
$ sudo docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres
```

Com o "psql" instalado usa-lo para acessar o postgres:
```bash
$ psql -h 127.0.0.1 -U postgres -W
```
A senha é **postgres**

criar o database "dev" no banco
```sql
CREATE DATABASE dev;
```

Sair do postgres
```sql
exit;
```

Para executar a aplicação há duas formas usando o maven:

Caso o maven não esteja instalado executar:

```bash
$ sudo apt install maven
```
A primeira maneira é usando o comando **spring-boot:run**

```bash
$ mvn spring-boot:run
```
A aplicação será iniciada.

A segunda maneira é gerando o seu arquivo **.jar**

 executar o comando:
```bash
$ mvn clean package
```
Será iniciado o processo de build e será gerado a pasta **target** na pasta raiz do projeto. Dentro dela estará o arquivo **.jar** criado.

Então entrar na pasta **target**
```bash
$ cd target
```
E executar:
```bash
$ java -jar nome_do_arquivo.jar
```
A aplicação será iniciada.

Agora acessar as rotas da API para usar os seus serviços. Para acessar as rotas, usar os softwares [insomnia](https://insomnia.rest/download) ou [Postman](https://www.postman.com/downloads/).

### API - Shopping

### Rotas GET
- get-shopping

  [GET] `http://localhost:8082/shopping`
  #### Resposta:   
  ```bash
    [
      {
        "userIdentifier": "Mario",
        "total": 449.0,
        "date": "2021-06-02T17:57:01.959+00:00",
        "items": [
          {
            "productIdentifier": "a1",
            "price": 100.0
          },
          {
            "productIdentifier": "a2",
            "price": 299.0
          },
          {
            "productIdentifier": "a3",
            "price": 50.0
          }
        ]
      },
      {
        "userIdentifier": "Andre",
        "total": 449.0,
        "date": "2021-06-02T18:00:43.909+00:00",
        "items": [
          {
            "productIdentifier": "a1",
            "price": 100.0
          },
          {
            "productIdentifier": "a2",
            "price": 299.0
          },
          {
            "productIdentifier": "a3",
            "price": 50.0
          }
        ]
      }
    ]  
  ```
  
- get-shopsByUser

  [GET] `http://localhost:8082/shopping/shopByUser/Eduardo`
  #### Resposta: 
  ```bash   
    [
      {
        "userIdentifier": "Mario",
        "total": 449.0,
        "date": "2021-06-02T18:00:43.909+00:00",
        "items": [
          {
            "productIdentifier": "a1",
            "price": 100.0
          },
          {
            "productIdentifier": "a2",
            "price": 299.0
          },
          {
            "productIdentifier": "a3",
            "price": 50.0
          }
        ]
      },
      {
        "userIdentifier": "Mario",
        "total": 449.0,
        "date": "2021-06-02T18:01:05.332+00:00",
        "items": [
          {
            "productIdentifier": "b1",
            "price": 100.0
          },
          {
            "productIdentifier": "b2",
            "price": 299.0
          },
          {
            "productIdentifier": "b3",
            "price": 50.0
          }
        ]
      }
    ]
  ```

- get-shopById

  [GET] `http://localhost:8082/shopping/1`
  #### Resposta:
  ```bash   
    {
      "userIdentifier": "Mario",
      "total": 449.0,
      "date": "2021-06-02T18:00:43.909+00:00",
      "items": [
        {
          "productIdentifier": "a1",
          "price": 100.0
        },
        {
          "productIdentifier": "a2",
          "price": 299.0
        },
        {
          "productIdentifier": "a3",
          "price": 50.0
        }
      ]
    }
  ```
  Se colocar um Cpf que não esta cadastrado vai retorna **Null**

  - get-shopByDate

  [GET] `http://localhost:8082/shopping/shopByDate`
  #### Corpo da mensagem (json):
  ```bash   
  {
    "date": "2021-06-02T17:26:32.313+00:00"
  }
  ```
   #### Resposta:
  ```bash   
  [
    {
      "userIdentifier": "Mario",
      "total": 449.0,
      "date": "2021-06-02T17:57:01.959+00:00",
      "items": [
        {
          "productIdentifier": "a1",
          "price": 100.0
        },
        {
          "productIdentifier": "a2",
          "price": 299.0
        },
        {
          "productIdentifier": "a3",
          "price": 50.0
        }
      ]
    },
    {
      "userIdentifier": "Andre",
      "total": 449.0,
      "date": "2021-06-02T18:00:43.909+00:00",
      "items": [
        {
          "productIdentifier": "a1",
          "price": 100.0
        },
        {
          "productIdentifier": "a2",
          "price": 299.0
        },
        {
          "productIdentifier": "a3",
          "price": 50.0
        }
      ]
    }
  ]
  ```

- get-shoppingSearch

  [GET] `http://localhost:8082/shopping/search?dataInicio=01/01/2020&dataFim=01/01/2022&valorMinimo=250`
   #### Resposta:
  ```bash   
  [
    {
      "userIdentifier": "Mario",
      "total": 69.0,
      "date": "2021-06-07T12:05:29.437+00:00",
      "items": [
        {
          "productIdentifier": "h1",
          "price": 10.0
        },
        {
          "productIdentifier": "h2",
          "price": 9.0
        },
        {
          "productIdentifier": "h3",
          "price": 50.0
        }
      ]
    },
    {
      "userIdentifier": "Mario",
      "total": 80.0,
      "date": "2021-06-07T12:15:12.421+00:00",
      "items": [
        {
          "productIdentifier": "i1",
          "price": 10.0
        },
        {
          "productIdentifier": "i2",
          "price": 20.0
        },
        {
          "productIdentifier": "i3",
          "price": 50.0
        }
      ]
    }
  ]
  ```

  - get-shoppingReport

  [GET] `http://localhost:8082/shopping/report?dataInicio=01/01/2020&dataFim=01/07/2021`
   #### Resposta:
  ```bash   
  [
    {
      "count": 3,
      "total": 837.0,
      "mean": 279.0
    }
  ]
  ```

### Rota POST
- post-shopping

  [POST] `http://localhost:8082/shopping`
  #### Corpo da mensagem (json): 
  ```bash   
    {
      "userIdentifier":"Mario",
      "items": [
        {
          "productIdentifier":"d1",
          "price":"100"
        },
        {
          "productIdentifier":"d2",
          "price":"299"
        },
        {
          "productIdentifier":"d3",
          "price":"50"
        }
      ]
    }
  ```
  #### Resposta da mensagem (json): 
  ```bash   
    {
      "userIdentifier": "Mario",
      "total": 449.0,
      "date": "2021-06-02T17:57:01.959+00:00",
      "items": [
        {
          "productIdentifier": "d1",
          "price": 100.0
        },
        {
          "productIdentifier": "d2",
          "price": 299.0
        },
        {
          "productIdentifier": "d3",
          "price": 50.0
        }
      ]
    }
  ```

## :gear: Contribuição

Para contribuir com esse projeto faça os seguintes passos:

- Faça um fork desse repositório;
- Crie uma branch com a sua feature: `git checkout -b minha-feature`;
- Faça commit das suas alterações: `git commit -m 'feat: Minha nova feature'`;
- Faça push para a sua branch: `git push origin minha-feature`.

## :memo: Licença

Esse projeto está sob a licença MIT. Veja o arquivo [LICENSE](./LICENSE.md) para mais detalhes.





