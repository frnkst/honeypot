import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {Logins, LoginServiceService} from "../services/login-service.service";
import {AsyncPipe, JsonPipe, NgIf} from "@angular/common";
import {Observable} from "rxjs";
import {SseService} from "../services/sse.service";

@Component({
  selector: 'app-logins',
  standalone: true,
  imports: [
    AsyncPipe,
    NgIf,
    JsonPipe
  ],
  templateUrl: './logins.component.html',
  styleUrl: './logins.component.scss'
})
export class LoginsComponent implements OnInit {
  logins?: Observable<Logins[]>;
  liveLogins: Logins[] = [];

  constructor(private loginService: LoginServiceService, private sseService: SseService, private cdr: ChangeDetectorRef) {
    this.getLogins();

  }

  getLogins() {
    console.log("frank")
    this.logins = this.loginService.getAllLogins();
    console.log("frank2", this.logins)
  }

  ngOnInit(): void {
    this.sseService.getServerSentEvent('http://localhost:8080/stream-flux')
    .subscribe(data => {
        this.liveLogins = [...this.liveLogins, data];
        console.log("sse: ", this.liveLogins);
        this.cdr.detectChanges();
      });
  }

}
