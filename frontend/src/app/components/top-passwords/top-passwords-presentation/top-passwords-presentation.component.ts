import {Component, Input} from '@angular/core';
import {AsyncPipe} from "@angular/common";
import {TopPasswords} from "../../../services/attack.service";
import {Observable, of} from "rxjs";
import {TopPasswordsPresentation} from "./top-passwords-presentation.interface";

@Component({
  selector: 'app-top-passwords-presentation',
  standalone: true,
	imports: [
		AsyncPipe
	],
  templateUrl: './top-passwords-presentation.component.html',
  styleUrl: './top-passwords-presentation.component.scss'
})
export class TopPasswordsPresentationComponent {
  @Input() topPasswords?: TopPasswordsPresentation

}
