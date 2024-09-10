package com.formulario.aula.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Aluno {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private Float nota;

    @Column
    private Integer idade;

    @Column
    private String situacao;


    public Aluno(Long id, String nome, Float nota, Integer idade, String situacao) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.idade = idade;
        this.situacao = situacao;
    }

    public Aluno(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id) && Objects.equals(nome, aluno.nome) && Objects.equals(nota, aluno.nota) && Objects.equals(idade, aluno.idade) && Objects.equals(situacao, aluno.situacao);
    }
    

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, nota, idade, situacao);
    }
}
