import { Routes } from '@angular/router';
import {BookListComponent} from "./components/books/book-list/book-list.component";
import {BookDetailComponent} from "./components/books/book-detail/book-detail.component";
import {AuthorDetailComponent} from "./components/authors/author-detail/author-detail.component";
import {AuthorListComponent} from "./components/authors/author-list/author-list.component";
import {SagaListComponent} from "./components/sagas/saga-list/saga-list.component";
import {SagaDetailComponent} from "./components/sagas/saga-detail/saga-detail.component";
import {GenreListComponent} from "./components/genres/genre-list/genre-list.component";
import {HomeComponent} from "./components/home/home.component";
export const routes: Routes = [
	{path: 'home', component: HomeComponent},
	{path: 'books', component: BookListComponent},
	{path: 'books/:id', component: BookDetailComponent},
	{path: 'authors', component: AuthorListComponent},
	{path: 'authors/:id', component: AuthorDetailComponent},
	{path: 'sagas', component: SagaListComponent},
	{path: 'sagas/:id', component: SagaDetailComponent},
	{path: 'genres', component: GenreListComponent},
	{path: "**", pathMatch: "full", redirectTo: "home"}
];
