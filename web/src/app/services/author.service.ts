import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {URL_BASE} from "../shared/utils";
import {Observable} from "rxjs";
import {Author} from "../components/authors/author";

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

	url: string = `${URL_BASE}/authors`

	constructor(private http: HttpClient) { }

	findAll(name?: string): Observable<Author[]> {
		const options = name ? {params: new HttpParams().set('name', name)} : {};
		return this.http.get<Author[]>(this.url, options);
	}

	findById(id: number): Observable<Author> {
		return this.http.get<Author>(`${this.url}/${id}`);
	}

	insert(author: Author) {

	}

	update(author: Author) {

	}

	delete(id: number) {

	}

}
