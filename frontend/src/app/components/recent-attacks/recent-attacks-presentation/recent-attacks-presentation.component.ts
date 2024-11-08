import { Component } from '@angular/core';
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-recent-attacks-presentation',
  standalone: true,
	imports: [
		AsyncPipe
	],
  templateUrl: './recent-attacks-presentation.component.html',
  styleUrl: './recent-attacks-presentation.component.scss'
})
export class RecentAttacksPresentationComponent {

}
