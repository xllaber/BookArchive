import {Component, OnInit} from '@angular/core';
import {Genre} from "../genre";
import {GenreService} from "../../../services/genre.service";

@Component({
  selector: 'app-genre-list',
  standalone: true,
  imports: [],
  templateUrl: './genre-list.component.html',
  styleUrl: './genre-list.component.scss'
})
export class GenreListComponent implements OnInit{

	genres!: Genre[];

	constructor(private genreService: GenreService) {
	}

	ngOnInit(): void {
		this.genreService.findAll().subscribe(data => this.genres = data);
	}

}
