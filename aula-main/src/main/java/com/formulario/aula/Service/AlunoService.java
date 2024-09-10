package com.formulario.aula.Service;


import com.formulario.aula.DTO.CadastroAlunoDTO;
import com.formulario.aula.Model.Aluno;
import com.formulario.aula.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {


    @Autowired
    private AlunoRepository alunoRepository;

    private String retornarSituacao(float nota){
        if(nota >= 6.0){
            return "Aprovado";
        }
        else{
            return "Reprovado";
        }
    }

    public void salvar(CadastroAlunoDTO aluno) {
        Aluno alunoSalvo = new Aluno();
        alunoSalvo.setNome(aluno.getNome());
        alunoSalvo.setIdade(aluno.getIdade());
        alunoSalvo.setNota(aluno.getNota());
        String situacao = retornarSituacao(aluno.getNota());
        alunoSalvo.setSituacao(situacao);

        this.alunoRepository.save(alunoSalvo);
    }

    public List<Aluno> pegarTodosAlunos(){
        return this.alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return this.alunoRepository.findById(id).orElseThrow();
    }

    public List<Aluno> buscarPorNome(String nome) {
    return this.alunoRepository.findAlunoByNomeContaining(nome);
    }

    public void alterarAluno(Aluno aluno) {
        this.alunoRepository.save(aluno);
    }

    public void excluirAluno(Long id) {
        this.alunoRepository.deleteById(id);
    }

    public List<Aluno> buscarPorSituacao(String situacao) {
        return this.alunoRepository.findAlunosBySituacao(situacao);
    }



}
