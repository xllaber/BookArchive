import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {URL_BASE} from "../shared/utils";
import {Observable} from "rxjs";
import {Reread} from "../components/books/reread/reread";

@Injectable({
  providedIn: 'root'
})
export class RereadService {

	url: string = `${URL_BASE}/rereads`;

  	constructor(private http: HttpClient) { }

	getById(id: number): Observable<Reread> {
		  return this.http.get<Reread>(`${this.url}/${id}`);
	}

	insert(reread: Reread): Observable<Reread> {
		  return this.http.post<Reread>(this.url, reread);
	}

	update(reread: Reread): Observable<Reread> {
		  return this.http.put<Reread>(`${this.url}/${reread.id}`, reread);
	}

}
