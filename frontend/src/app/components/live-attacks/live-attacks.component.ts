import {Component} from '@angular/core';
import {AttackEvent, SseService} from "../../services/sse.service";
import {fromUnixTime} from "date-fns";

@Component({
  selector: 'app-live-attacks',
  standalone: true,
  imports: [],
  templateUrl: './live-attacks.component.html',
  styleUrl: './live-attacks.component.scss'
})
export class LiveAttacksComponent {
  attackEvents: AttackEvent[] = [];

  constructor(private sseService: SseService) {
    this.sseService.getServerSentEvent('http://localhost:8080/attack-events')
    .subscribe(event => {
      this.attackEvents = [event, ...this.attackEvents]
    });
  }

  protected readonly fromUnixTime = fromUnixTime;
  protected readonly Number = Number;
}
