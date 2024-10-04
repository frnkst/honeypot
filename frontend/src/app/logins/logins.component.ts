import { Component } from '@angular/core';
import {Logins, LoginServiceService} from "../services/login-service.service";
import {AsyncPipe} from "@angular/common";
import {Observable} from "rxjs";

@Component({
  selector: 'app-logins',
  standalone: true,
  imports: [
    AsyncPipe
  ],
  templateUrl: './logins.component.html',
  styleUrl: './logins.component.scss'
})
export class LoginsComponent {
  logins?: Observable<Logins[]>;

  constructor(private loginService: LoginServiceService) {
    this.getLogins();

  }

  getLogins() {
    console.log("frank")
    this.logins = this.loginService.getAllLogins();
    console.log("frank2", this.logins)
  }

}
