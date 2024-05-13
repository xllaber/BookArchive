import {Component, OnInit} from '@angular/core';
import {Author} from "../author";
import {Router, RouterLink} from "@angular/router";
import {AuthorService} from "../../../services/author.service";
import {MatCard, MatCardContent, MatCardHeader, MatCardLgImage} from "@angular/material/card";
import {MatDialog} from "@angular/material/dialog";
import {AuthorDetailComponent} from "../author-detail/author-detail.component";

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

	constructor(private dialog: MatDialog,
				private authorService: AuthorService) {
	}

	ngOnInit(): void {
		this.authorService.findAll(this.name).subscribe(data => {
			this.authors = data;
			console.log(this.authors);
		});
	}

	openDetail(author?: any) {
		const ref = this.dialog.open(AuthorDetailComponent, {
			enterAnimationDuration: 100,
			exitAnimationDuration: 100,
			autoFocus: true,
			data: {author: author}
		})

		ref.afterClosed().subscribe(() => this.ngOnInit());
	}

}
