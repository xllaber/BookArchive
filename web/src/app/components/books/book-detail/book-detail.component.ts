import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {BookService} from "../../../services/book.service";
import {Book} from "../book";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-book-detail',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './book-detail.component.html',
  styleUrl: './book-detail.component.scss'
})
export class BookDetailComponent implements OnInit{

	book!: Book;

	constructor(private router: Router,
				private activatedRoute: ActivatedRoute,
				private bookService: BookService) {
	}

	ngOnInit(): void {
		this.bookService.findById(this.activatedRoute.snapshot.params['id'])
			.subscribe(book => this.book = book);
	}

}
