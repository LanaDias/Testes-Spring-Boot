# Testes-Spring-Boot

Projeto de estudo de testes em Java com Spring Boot, JUnit 5, Mockito e JaCoCo, usando um cadastro de usuário como exemplo.

## Tecnologias

**Spring Boot**: framework que monta a aplicação e gerencia as classes (`@Service`, `@Entity`...). Sua função é subir a aplicação e entregar o `UsuarioRepository` ao `UsuarioService`.

**Gradle**: ferramenta de build. Baixa as bibliotecas, compila o código, inicia os testes e mostra o resultado final (`BUILD SUCCESSFUL` ou `BUILD FAILED`).

**JUnit 5**: executa cada teste e confere os resultados. É o "fiscal": quem decide se um teste passou ou falhou. O Gradle só o inicia e informa o que ele concluiu.

**Mockito**: cria objetos falsos (mocks) para isolar o que está sendo testado. Aqui, finge ser o `UsuarioRepository`, então os testes unitários não precisam de banco de dados.

**JaCoCo**: mede quanto do código foi executado pelos testes e gera um relatório em HTML.

## Como as peças se encaixam

```
Gradle        → compila o código e inicia os testes
   ↓
JUnit         → executa cada teste e confere os resultados
   ↓
Mockito       → dentro dos testes, substitui dependências (como o banco) por dublês
   ↓
JaCoCo        → mostra quais partes do código os testes cobriram
```

## Como rodar os testes

Dentro da pasta `Task`:

```
.\gradlew clean test      # Windows (PowerShell)
./gradlew clean test      # Linux / macOS
```
