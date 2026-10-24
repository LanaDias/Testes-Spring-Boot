package dev.lana.teste;

import jakarta.persistence.Entity; //importa a anotação @Entity do JPA, que indica que essa classe é uma entidade do banco de dados.
import jakarta.persistence.GeneratedValue; //importa a notação @GeneratedValue do JPA, que indica que o valor do campo será gerado automaticamente pelo banco de dados.
import jakarta.persistence.GenerationType;//importa a anotação @GenerationType do JPA, que indica o tipo de geração do valor do campo.
import jakarta.persistence.Id; //importa a anotação @Id do JPA, que indica que o campo é a chave primária da tabela.


@Entity 

public class Usuario {

    //As anotações jpa se aplicam á proxima declaração que está logo abaixo, que é o campo id.
    @Id //indica que o campo id é a chave primária da tabela.
    @GeneratedValue (strategy= GenerationType.IDENTITY) //banco gera o id automaticamente.
    private Long id; //id do usuário, gerado pelo banco

    private String nome;

    //construtor vazio para o JPA(conversa com o banco, cria um obj vazio, e só depois preenche os campos com o que leu) protected para que o código não use "sem quere" criando um user sem nome.
    protected Usuario(){}

    public Usuario(String nome){
        this.nome = nome;
    }

    public Long getId() { return id; } //pega o id do banco de dados e retorna 
    public String getNome() { return nome; } //pega o nome do banco de dados e retorna

}
