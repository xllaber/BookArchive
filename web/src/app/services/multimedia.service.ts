import { Injectable } from '@angular/core';
import {URL_BASE} from "../shared/utils";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MultimediaService {

	urlBase: string = `${URL_BASE}/multimedia`;
	httpHeaders = new HttpHeaders().set('Access-Control-Allow-Origin', '*')
		.set('content-type', 'multipart/form-data');

  	constructor(private http: HttpClient) { }

	upload(request: any, fileName: string): Observable<string> {
		let formData = new FormData();
		formData.append('image', request, fileName);
		return this.http.post<string>(`${this.urlBase}/upload`, {formData, fileName}, {headers: this.httpHeaders});
	}

}
