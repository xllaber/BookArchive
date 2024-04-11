import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {Author} from "../author";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthorService} from "../../../services/author.service";

@Component({
  selector: 'app-author-detail',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './author-detail.component.html',
  styleUrl: './author-detail.component.scss'
})
export class AuthorDetailComponent implements OnInit{

	author!: Author;

	constructor(private router: Router,
				private activatedRoute: ActivatedRoute,
				private authorService: AuthorService) {
	}

	ngOnInit(): void {
		this.authorService.findById(this.activatedRoute.snapshot.params['id'])
			.subscribe(author => this.author = author);
	}

}
