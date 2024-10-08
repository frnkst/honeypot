import {Component, OnInit} from '@angular/core';
import {Observable, of, switchMap, timer} from "rxjs";
import {AttackService, TopPasswords, TopUsernames} from "../../services/attack.service";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-top-usernames',
  standalone: true,
  imports: [
    AsyncPipe
  ],
  templateUrl: './top-usernames.component.html',
  styleUrl: './top-usernames.component.scss'
})
export class TopUsernamesComponent implements OnInit {
  protected topUsernames: Observable<TopUsernames[]> = of([]);

  constructor(private attackService: AttackService) {}

  ngOnInit() {
    this.topUsernames = timer(0, 5000).pipe(switchMap(() => this.attackService.getTopUsernames()));
  }
}
