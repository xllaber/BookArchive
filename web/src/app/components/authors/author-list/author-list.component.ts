import {Component, OnInit} from '@angular/core';
import {Author} from "../author";
import {Router} from "@angular/router";
import {AuthorService} from "../../../services/author.service";

@Component({
  selector: 'app-author-list',
  standalone: true,
  imports: [],
  templateUrl: './author-list.component.html',
  styleUrl: './author-list.component.scss'
})
export class AuthorListComponent implements OnInit{

	authors!: Author[];
	name: string = '';

	constructor(private router: Router,
				private authorService: AuthorService) {
	}

	ngOnInit(): void {
		this.authorService.findAll(this.name).subscribe(data => this.authors = data);
	}

}
