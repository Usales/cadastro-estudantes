package com.formulario.aula.Repository;

import com.formulario.aula.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    public List<Aluno> findAlunoByNomeContaining(String nome);

    public List<Aluno> findAlunosBySituacao(String situacao);
}
