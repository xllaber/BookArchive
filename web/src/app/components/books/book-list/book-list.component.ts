import { Component, OnInit } from '@angular/core';
import { CommonModule } from "@angular/common";
import {BookService} from "../../../services/book.service";
import {Book} from "../book";
import {Router} from "@angular/router";

@Component({
  	selector: 'app-book-list',
  	standalone: true,
  	imports: [CommonModule],
	// template: ``,
  	templateUrl: './book-list.component.html',
	styleUrl: './book-list.component.scss'
})
export class BookListComponent implements OnInit {

	books!: Book[];
	year: number = new Date().getFullYear();

	constructor(private router: Router, private bookService: BookService) {
	}

	ngOnInit(): void {
		this.bookService.findAll(this.year).subscribe(data => {
			this.books = data;
		});
	}

}
