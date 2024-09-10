package com.formulario.aula.DTO;

import java.util.Objects;

public class CadastroAlunoDTO {
    private String nome;
    private Integer idade;
    private Float nota;

    public CadastroAlunoDTO(){

    }

    public CadastroAlunoDTO(String nome, Integer idade, Float nota) {
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CadastroAlunoDTO that = (CadastroAlunoDTO) o;
        return Objects.equals(nome, that.nome) && Objects.equals(idade, that.idade) && Objects.equals(nota, that.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, nota);
    }
}
