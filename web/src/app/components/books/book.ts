import {Saga} from "../sagas/saga";
import {Reread} from "../rereads/reread";
import {Author} from "../authors/author";
import {Genre} from "../genres/genre";

export interface Book {

  id?: number;
  title: string;
  pages: number;
  publishYear: number;
  sagaNum?: number;
  fave: boolean;
  image: string;
  saga?: Saga;
  rereads: Reread[];
  authors: Author[];
  genre: Genre[];

}
