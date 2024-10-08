import {Component, OnInit} from '@angular/core';
import {AttackService, TopPasswords} from "../../services/attack.service";
import {Observable, of} from "rxjs";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-top-passwords',
  standalone: true,
  imports: [
    AsyncPipe
  ],
  templateUrl: './top-passwords.component.html',
  styleUrl: './top-passwords.component.scss'
})
export class TopPasswordsComponent implements OnInit {
  protected topPasswords: Observable<TopPasswords[]> = of([]);

  constructor(private attackService: AttackService) {}

  ngOnInit() {
    this.topPasswords = this.attackService.getTopPasswords();
    this.topPasswords.subscribe((a) => {
      console.log("frank", a)
    })

  }
}
