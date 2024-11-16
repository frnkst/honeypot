import {Component, OnInit} from '@angular/core';
import {AllStats, AttackService} from "../../services/test.service";
import {Observable, switchMap, timer} from "rxjs";
import {
  AllStatsPresentationComponent
} from "./all-stats-presentation/all-stats-presentation.component";

@Component({
  selector: 'app-all-stats-container',
  standalone: true,
  imports: [
    AllStatsPresentationComponent,
    AllStatsPresentationComponent
  ],
  styleUrl: './all-stats-container.component.scss',
  templateUrl: './all-stats-container.component.html',
})
export class AllStatsContainerComponent implements OnInit {
  protected allStats?: Observable<AllStats>;

  constructor(private attackService: AttackService) {}

  ngOnInit() {
    this.allStats = timer(0, 5000)
    .pipe(switchMap(() => this.attackService.getAllStats())) ;
  }
}
