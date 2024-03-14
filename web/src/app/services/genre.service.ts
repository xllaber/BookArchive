import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Genre} from "../components/genres/genre";
import {URL_BASE} from "../shared/utils";

@Injectable({
  providedIn: 'root'
})
export class GenreService {

	url: string = `${URL_BASE}/genres`

	constructor(private http: HttpClient) { }

	findAll(): Observable<Genre[]> {
	  return this.http.get<Genre[]>(this.url);
	}

}
