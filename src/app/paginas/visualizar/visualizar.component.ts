import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ButtonModule } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';
import { FloatLabelModule } from 'primeng/floatlabel';
import { InputMaskModule } from 'primeng/inputmask';
import { InputTextModule } from 'primeng/inputtext';
import { ToastModule } from 'primeng/toast';
import { FormularioService } from '../formulario.service';
import { IAlunos } from '../formulario.types';

@Component({
  selector: 'app-visualizar',
  standalone: true,
  imports: [FormsModule,
    InputTextModule,
    FloatLabelModule,
    ButtonModule,
    DropdownModule,
    InputMaskModule,
    RouterModule,
    ToastModule,],
    providers: [MessageService],
  templateUrl: './visualizar.component.html',
  styleUrl: './visualizar.component.scss'
})
export class VisualizarComponent {
  constructor(
    private route: ActivatedRoute,
    private formularioService: FormularioService,
    private messageService: MessageService
  ) {}

  aluno: IAlunos | undefined;

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    if (id) {
      this.formularioService.getAlunos().subscribe((alunos) => {
        this.aluno = alunos.find((p) => p.id === parseInt(id));
      });
    }
  }

  excluirAluno(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.formularioService.deletarAluno(id).subscribe(
        () => {
          this.messageService.add({
            severity: 'success',
            summary: 'Concluído!',
            detail: `Aluno foi removido com sucesso!`,
          });
        },
        (error) => {
          this.messageService.add({
            severity: 'error',
            summary: 'Erro!',
            detail: 'Falha ao excluir o Aluno.',
          });
        }
      );
    }
  }
}
