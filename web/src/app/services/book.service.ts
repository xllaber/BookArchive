import {Injectable} from '@angular/core';
import {URL_BASE} from "../shared/utils";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Book} from "../components/books/book";
import {map, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BookService {

  url: string = `${URL_BASE}/books`;

  constructor(private http: HttpClient) { }

  findAll(year?: number): Observable<Book[]> {
	const options = year ? {params: new HttpParams().set('year', year)} :
		{params: new HttpParams().set('year', new Date().getFullYear())};

	return this.http.get<Book[]>(this.url, options);
  }

  findById(id: number): Observable<Book> {
	return this.http.get<Book>(`${this.url}/${id}`);
  }

  insert(book: Book) {

  }

  update(book: Book) {

  }

  delete(id: number) {

  }

}
