import {Component, OnInit} from '@angular/core';
import {Author} from "../author";
import {Router, RouterLink} from "@angular/router";
import {AuthorService} from "../../../services/author.service";
import {MatCard, MatCardContent, MatCardHeader, MatCardLgImage} from "@angular/material/card";

@Component({
  selector: 'app-author-list',
  standalone: true,
	imports: [
		MatCard,
		MatCardHeader,
		MatCardContent,
		MatCardLgImage,
		RouterLink
	],
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
		this.authorService.findAll(this.name).subscribe(data => {
			this.authors = data;
			console.log(this.authors);
		});
	}

	authorDetail(authorId: number | undefined) {
		if (authorId) this.router.navigate([`/authors/${authorId}`]);
	}

}
