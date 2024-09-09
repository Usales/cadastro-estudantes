import { Component, OnInit } from '@angular/core';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule } from '@angular/forms';
import { FloatLabelModule } from 'primeng/floatlabel';
import { MenubarModule } from 'primeng/menubar';
import { ToastModule } from 'primeng/toast';
import { ButtonModule } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { InputMaskModule } from 'primeng/inputmask';
import { MessageService } from 'primeng/api';
import { FormularioService } from '../formulario.service';
import { IAlunos } from '../formulario.types';


@Component({
  selector: 'app-formulario',
  standalone: true,
  imports: [FormsModule,
    InputTextModule,
    FloatLabelModule,
    MenubarModule,
    ToastModule,
    ButtonModule,
    DropdownModule,
    InputMaskModule,
    RouterModule],
    providers: [MessageService],
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.scss'
})
export class FormularioComponent {

  formDesabilitado = false;

  alunos: IAlunos[] = [];

  aluno: IAlunos = { id: null, nome: '', idade: null, nota: null , situacao: '' };

  constructor(
    private formularioService: FormularioService,
    private route: ActivatedRoute,
    private messageService: MessageService
  ) {}

  ngOnInit() {
  }

  cadastrar(): void {
    this.formularioService.criarAluno(this.aluno).subscribe(
      (resposta) => {
        this.messageService.add({ severity: 'success', summary: 'Concluido!', detail: 'Aluno: '+ this.aluno.nome+', foi cadatrado com sucesso!' });
        this.aluno = { id: null, nome: '', idade: null, nota: null , situacao: '' };

      }, error => {
        this.messageService.add({ severity: 'error', summary: 'Erro!', detail: 'Falha ao cadastrar o usuário.' });
      });
  }

  validateAgeInput(event: KeyboardEvent) {
    const input = event.target as HTMLInputElement;
    if (input.value.length >= 2 && event.key !== 'Backspace') {
      event.preventDefault();
    }
  }

}
