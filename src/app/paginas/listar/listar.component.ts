import { Component, OnInit } from '@angular/core';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { TagModule } from 'primeng/tag';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { RouterModule } from '@angular/router';
import { DialogModule } from 'primeng/dialog';
import { FormsModule } from '@angular/forms';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';
import { IAlunos } from '../formulario.types';
import { FormularioService } from '../formulario.service';
@Component({
  selector: 'app-listar',
  standalone: true,
  imports: [ButtonModule,
    TagModule,
    CommonModule,
    CardModule,
    TableModule,
    RouterModule,
    DialogModule,
    FormsModule,
    ToastModule],
    providers: [MessageService],
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.scss'
})
export class ListarComponent implements OnInit{
  alunos: IAlunos[] = [];

  constructor(private formularioService: FormularioService
  ) {}

  ngOnInit() {
    this.formularioService.getAlunos().subscribe((data: IAlunos[]) => {
      this.alunos = data;
    });
  }
}
