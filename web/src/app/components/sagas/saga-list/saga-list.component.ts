import {Component, OnInit} from '@angular/core';
import {Saga} from "../saga";
import {Router} from "@angular/router";
import {SagaService} from "../../../services/saga.service";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {BookService} from "../../../services/book.service";
import {MatDialog} from "@angular/material/dialog";
import {SagaDetailComponent} from "../saga-detail/saga-detail.component";

@Component({
  selector: 'app-saga-list',
  standalone: true,
	imports: [
		MatCard,
		MatCardHeader,
		MatCardContent,
		MatCardTitle
	],
  templateUrl: './saga-list.component.html',
  styleUrl: './saga-list.component.scss'
})
export class SagaListComponent implements OnInit{

	sagas!: Saga[];

	constructor(private dialog: MatDialog,
				private sagaService: SagaService) {
	}

	ngOnInit(): void {
		this.sagaService.findAll().subscribe(data => this.sagas = data);
	}

	openDetail(saga?: Saga) {
		const ref = this.dialog.open(SagaDetailComponent, {
			enterAnimationDuration: 100,
			exitAnimationDuration: 100,
			autoFocus: true,
			data: {saga: saga}
		});
		ref.afterClosed().subscribe(() => this.ngOnInit());
	}

}
