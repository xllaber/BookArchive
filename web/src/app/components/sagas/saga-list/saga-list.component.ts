import {Component, OnInit} from '@angular/core';
import {Saga} from "../saga";
import {Router} from "@angular/router";
import {SagaService} from "../../../services/saga.service";

@Component({
  selector: 'app-saga-list',
  standalone: true,
  imports: [],
  templateUrl: './saga-list.component.html',
  styleUrl: './saga-list.component.scss'
})
export class SagaListComponent implements OnInit{

	sagas!: Saga[];

	constructor(private router: Router,
				private sagaService: SagaService) {
	}

	ngOnInit(): void {
		this.sagaService.findAll().subscribe(data => this.sagas = data);
	}

}
