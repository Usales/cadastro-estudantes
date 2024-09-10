package com.formulario.aula.Controller;


import com.formulario.aula.DTO.CadastroAlunoDTO;
import com.formulario.aula.Model.Aluno;
import com.formulario.aula.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/")
    public void salvar(@RequestBody CadastroAlunoDTO aluno) {
        this.alunoService.salvar(aluno);
    }
    @PutMapping("/")
    public void alterar(@RequestBody Aluno aluno) {
        this.alunoService.alterarAluno(aluno);
    }

    @GetMapping("/")
    public List<Aluno> pegarAlunos() {
        return this.alunoService.pegarTodosAlunos();
    }

    @DeleteMapping("/{id}")
    public void excluirAluno(@RequestParam("id") Long id) {
        this.alunoService.excluirAluno(id);
    }
    @GetMapping("/{id}")
    public Aluno buscarAlunoPorId(@RequestParam("id") Long id) {
        return this.alunoService.buscarPorId(id);
    }

    @GetMapping("/por-nome/{nome}")
    public List<Aluno> buscarAlunoPorNome(@PathVariable("nome") String nome) {
        return this.alunoService.buscarPorNome(nome);
    }

    @GetMapping("/por-situacao/{situacao}")
    public List<Aluno> buscarAlunosPorSituacao(@PathVariable("situacao") String situacao) {
        return this.alunoService.buscarPorSituacao(situacao);
    }

}
