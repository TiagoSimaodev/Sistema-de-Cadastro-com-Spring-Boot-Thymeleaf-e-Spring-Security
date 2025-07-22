# 📚 Sistema de Cadastro com Spring Boot, Thymeleaf e Spring Security

Este projeto é uma aplicação web completa desenvolvida com **Spring Boot**, seguindo a arquitetura **MVC**, utilizando **Thymeleaf** para renderização de páginas, **Spring Data JPA** para persistência no banco de dados, **Spring Security** para autenticação/autorização, **Materialize CSS** para o design responsivo, além de integração com **Web Services REST**, **upload de arquivos**, **relatórios PDF com JasperReports**, **validações client/server**, **paginação** e muito mais.

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- Thymeleaf
- PostgreSQL (ou outro banco relacional)
- Hibernate
- Materialize CSS (via CDN)
- JavaScript e AJAX
- JasperReports
- API ViaCEP (consumo de web service REST)
- Lombok
- Maven

## 🔧 Funcionalidades Implementadas

### 📁 Cadastro e Consulta

- Cadastro completo de pessoas com validações
- Filtro de busca por nome e sexo
- Relacionamento um-para-muitos com telefones
- Cadastro, edição e exclusão de telefones por pessoa
- Exibição de detalhes da pessoa
- Consulta dinâmica com filtros

### 🛡️ Segurança

- Spring Security com autenticação via banco de dados
- Criptografia de senha com BCrypt
- Controle de acesso por perfil (ROLE)
- Login customizado com Materialize

### 📦 Recursos Avançados

- Upload e download de arquivos (como currículos)
- Proteção contra download de arquivos inexistentes
- Placeholder em campos de formulário
- Combos dinâmicos (sexo, perfis, enums)
- Paginação de resultados com filtros
- Calendário de data com Materialize

### 📑 Relatórios

- Geração de relatórios em PDF com JasperReports
- Impressão de relatórios com filtros de busca
- Exportação para download

### 🌐 Integrações

- Consumo de API ViaCEP para preenchimento automático de endereço
- Integração com JavaScript para validações em tempo real

## 📂 Estrutura do Projeto (Arquitetura MVC)

