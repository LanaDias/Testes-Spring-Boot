package dev.lana.teste;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//avisa ao JPA queessa classe vira uma tabela, onde cada objeto vira uma linha da tabela e cada campo é uma coluna da tabela.
@Entity 

public class Usuario {

    @Id //id gerado pelo banco
    @GeneratedValue (strategy= GenerationType.IDENTITY) //banco gera o id automaticamente, não precisa informar.
    private Long id; //id do usuário, gerado pelo banco

    private String nome;

    //construtor vazio para o JPA(conversa com o banco, cria um obj vazio, e só depois preenche os campos com o que leu) protected para que o código não use "sem quere" criando um user sem nome.
    protected Usuario(){}

    public Usuario(String nome){
        this.nome = nome;
    }

    public Long getId() { return id; } //retorna o id do usuário
    public String getNome() { return nome; } //retorna o nome do usuário

    
}
