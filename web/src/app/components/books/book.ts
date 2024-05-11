import {Saga} from "../sagas/saga";
import {Author} from "../authors/author";
import {Genre} from "../genres/genre";
import {Reread} from "./reread/reread";

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
  genres: Genre[];
  lastReread: Reread;
  readTime: number;
}
