import {Component, OnInit} from '@angular/core';
import {Observable, of, switchMap, timer} from "rxjs";
import {AttackService, TopPasswords} from "../../services/attack.service";
import {
  TopPasswordsPresentationComponent
} from "./top-passwords-presentation/top-passwords-presentation.component";
import {
  TopPasswordsPresentation
} from "./top-passwords-presentation/top-passwords-presentation.interface";

@Component({
  selector: 'app-top-passwords-container',
  standalone: true,
  imports: [
    TopPasswordsPresentationComponent
  ],
  templateUrl: './top-passwords-container.component.html',
  styleUrl: './top-passwords-container.component.scss'
})
export class TopPasswordsContainerComponent implements OnInit {
  protected topPasswords: Observable<TopPasswords[]> = of([]);

  constructor(private attackService: AttackService) {}

  ngOnInit() {
    this.topPasswords = timer(0, 5000)
    .pipe(switchMap(() => this.attackService.getTopPasswords())) ;
  }
}



