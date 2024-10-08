import { Component } from '@angular/core';
import {Observable, of, switchMap, timer} from "rxjs";
import {AttackService, TopIPs, TopPasswords} from "../../services/attack.service";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-top-ips',
  standalone: true,
  imports: [
    AsyncPipe
  ],
  templateUrl: './top-ips.component.html',
  styleUrl: './top-ips.component.scss'
})
export class TopIpsComponent {
  protected topIPs: Observable<TopIPs[]> = of([]);

  constructor(private attackService: AttackService) {}

  ngOnInit() {
    this.topIPs = timer(0, 5000)
    .pipe(switchMap(() => this.attackService.getTopIps())) ;
  }
}
