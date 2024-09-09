import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IAlunos } from './formulario.types';

@Injectable({
  providedIn: 'root'
})
export class FormularioService {

  apiUrl = 'http://localhost:8080/api/alunos/'

  private alunos: IAlunos[] = [];
  constructor(private http : HttpClient) { }

  getAlunos(): Observable<IAlunos[]> {
    return this.http.get<IAlunos[]>(this.apiUrl);
  }

  criarAluno(aluno: IAlunos): Observable<IAlunos> {
    return this.http.post<IAlunos>(this.apiUrl, aluno);
  }

  deletarAluno(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}${id}`);
  }
}
