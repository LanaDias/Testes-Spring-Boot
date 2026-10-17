package dev.lana.teste;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Usuario {

    //id gerado pelo banco
    @Id 
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Long id;

    private String nome;

    //construtor vazio para o JPA(conversa com o banco, cria um obj vazio, e só depois preenche os campos com o que leu) protected para que o código não use "sem quere" criando um user sem nome.
    protected Usuario(){} 

    public Usuario(String nome){
        this.nome = nome;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }

    
}
