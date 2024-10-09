import {TopPasswords} from "../../../services/attack.service";
import {Observable} from "rxjs";

export interface TopPasswordsPresentation {
  passwords: Observable<TopPasswords[]>
}
