import {Component, Input, OnInit} from '@angular/core';
import {Reread} from "./reread";
import {MatTab, MatTabGroup, MatTabLabel} from "@angular/material/tabs";
import {MatFormField} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {FormsModule} from "@angular/forms";
import {MatDialog} from "@angular/material/dialog";
import {RereadDialogComponent} from "./reread-dialog/reread-dialog.component";
import {Book} from "../book";

@Component({
  selector: 'app-reread',
  standalone: true,
	imports: [
		MatTabGroup,
		MatTab,
		MatFormField,
		MatInput,
		FormsModule,
		MatTabLabel
	],
  templateUrl: './reread.component.html',
  styleUrl: './reread.component.scss'
})
export class RereadComponent implements OnInit{

	@Input() rereads!: Reread[];
	@Input() book!: Book;
	rereadsWithIds!: {
		id: number,
		reread: Reread
	}[];
	rereadTest!: any;
	editMode: boolean = false;

	constructor(private dialog: MatDialog) {
	}

	ngOnInit(): void {
		this.rereadsWithIds = this.rereads.map(r => ({id: this.rereads.indexOf(r), reread: r}))
		this.rereadTest = this.rereads[0].impressions;

	}

	editReread(reread: Reread) {
		this.dialog.open(RereadDialogComponent, {
			enterAnimationDuration: 100,
			exitAnimationDuration: 100,
			autoFocus: true,
			data: {
				reread: reread,
				book: this.book,
				insert: false
			}
		});
	}

	newReread() {
		this.dialog.open(RereadDialogComponent, {
			enterAnimationDuration: 100,
			exitAnimationDuration: 100,
			autoFocus: true,
			data: {
				reread: null,
				book: this.book,
				insert: true
			}
		});
	}

}
