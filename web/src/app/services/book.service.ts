import { Injectable } from '@angular/core';
import {URL_BASE} from "../shared/utils";
import {HttpClient} from "@angular/common/http";
import {Book} from "../components/books/book";

@Injectable({
  providedIn: 'root'
})
export class BookService {

  url: string = `${URL_BASE}/books`;

  constructor(private http: HttpClient) { }

  findAll() {

  }

  findById(id: number) {

  }

  insert(book: Book) {

  }

  update(book: Book) {

  }

  delete(id: number) {

  }

}
