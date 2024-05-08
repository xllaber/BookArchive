import { Injectable } from '@angular/core';
import {URL_BASE} from "../shared/utils";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class MultimediaService {

	urlBase: string = `${URL_BASE}/multimedia`;

  	constructor(private http: HttpClient) { }

	upload(file: any) {
		  this.http.post(`${this.urlBase}/upload`, file);
	}

}
