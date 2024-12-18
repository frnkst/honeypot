import {Component, Input} from '@angular/core';
import {AsyncPipe} from "@angular/common";
import {Top, TopType} from "../../../services/test.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-top-presentation',
  standalone: true,
	imports: [
		AsyncPipe
	],
  templateUrl: './top-presentation.component.html',
  styleUrl: './top-presentation.component.scss'
})
export class TopPresentationComponent {
  @Input() top?: Observable<Top[]>
  @Input() type?: TopType
  @Input() title?: string
}
