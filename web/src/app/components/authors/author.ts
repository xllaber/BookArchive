import {Pseudonym} from "./pseudonym";

export interface Author {

  id?: number;
  name: string;
  country: string;
  birthYear: number;
  deathYear?: number;
  image: string;
  pseudonyms?: Pseudonym[];

}
