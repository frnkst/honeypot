import {Component, Input} from '@angular/core';
import {AllStats} from "../../../services/attack.service";
import {Observable} from "rxjs";
import {AsyncPipe, JsonPipe} from "@angular/common";

@Component({
  selector: 'app-all-stats-presentation',
  standalone: true,
  imports: [
    AsyncPipe,
    JsonPipe
  ],
  templateUrl: './all-stats-presentation.component.html',
  styleUrl: './all-stats-presentation.component.scss'
})
export class AllStatsPresentationComponent {
  @Input() allStats?: Observable<AllStats>
}
