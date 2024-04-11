import {Component, OnInit} from '@angular/core';
import {Saga} from "../saga";
import {ActivatedRoute, Router} from "@angular/router";
import {SagaService} from "../../../services/saga.service";

@Component({
  selector: 'app-saga-detail',
  standalone: true,
  imports: [],
  templateUrl: './saga-detail.component.html',
  styleUrl: './saga-detail.component.scss'
})
export class SagaDetailComponent implements OnInit{

	saga!: Saga;

	constructor(private router: Router,
				private activatedRoute: ActivatedRoute,
				private sagaService: SagaService) {
	}

	ngOnInit(): void {
		this.sagaService.findById(this.activatedRoute.snapshot.params['id'])
			.subscribe(data => this.saga = data);
	}

}
