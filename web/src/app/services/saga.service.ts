import { Injectable } from '@angular/core';
import {URL_BASE} from "../shared/utils";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Saga} from "../components/sagas/saga";

@Injectable({
  providedIn: 'root'
})
export class SagaService {

	url: string = `${URL_BASE}/sagas`

	constructor(private http: HttpClient) { }

	findAll(): Observable<Saga[]> {
		return this.http.get<Saga[]>(this.url);
	}

	findById(id: number): Observable<Saga> {
		return this.http.get<Saga>(`${this.url}/${id}`);
	}

}
