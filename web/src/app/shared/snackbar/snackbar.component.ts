import {Component, Inject, inject} from '@angular/core';
import {MAT_SNACK_BAR_DATA, MatSnackBarLabel, MatSnackBarRef} from "@angular/material/snack-bar";

@Component({
  selector: 'app-snackbar',
  standalone: true,
	imports: [
		MatSnackBarLabel
	],
  template: `
    <p matSnackBarLabel class="padding-4 border border--rounded-2 font-size-7 color-black-5"
	   [class]="data.success ? 'bg-color-green-3 border--color-green-5' : 'bg-color-red-3 border--color-red-5' ">
        {{data.message}}
    </p>
  `,
  styles: ``
})
export class SnackbarComponent {

	snackBarRef = inject(MatSnackBarRef);

	constructor(@Inject(MAT_SNACK_BAR_DATA) public data: any) {
		console.log(data);
	}

}
