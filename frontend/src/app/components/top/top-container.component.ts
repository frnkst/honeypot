import {Component, OnInit} from '@angular/core';
import {Observable, of, switchMap, timer} from "rxjs";
import {AttackService, Top} from "../../services/attack.service";
import {
  TopPresentationComponent
} from "./top-presentation/top-presentation.component";

@Component({
  selector: 'app-top-container',
  standalone: true,
  imports: [
    TopPresentationComponent
  ],
  templateUrl: './top-container.component.html',
  styleUrl: './top-container.component.scss'
})
export class TopContainerComponent implements OnInit {
  protected top: Observable<Top[]> = of([]);

  constructor(private attackService: AttackService) {}

  ngOnInit() {
    this.top = timer(0, 5000)
    .pipe(switchMap(() => this.attackService.getTop('password'))) ;
  }
}



