import { Injectable } from '@angular/core';
import {URL_BASE} from "../shared/utils";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Saga} from "../components/sagas/saga";
import {Book} from "../components/books/book";

@Injectable({
  providedIn: 'root'
})
export class SagaService {

	url: string = `${URL_BASE}/sagas`;

	constructor(private http: HttpClient) { }

	findAll(): Observable<Saga[]> {
		return this.http.get<Saga[]>(this.url);
	}

	findById(id: number): Observable<Saga> {
		return this.http.get<Saga>(`${this.url}/${id}`);
	}

	findBooksBySagaId(id: number | undefined): Observable<Book[]> {
		return this.http.get<Book[]>(`${this.url}/${id}/books`);
	}

	insert(saga: Saga): Observable<Saga> {
		return this.http.post<Saga>(this.url, saga);
	}

	update(saga: Saga): Observable<Saga> {
		return this.http.put<Saga>(`${this.url}/${saga.id}`, saga);
	}

	delete(id: number | undefined): Observable<any> {
		return this.http.delete<any>(`${this.url}/${id}`);
	}

}
