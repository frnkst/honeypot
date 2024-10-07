import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export type Logins = {
  username: string,
  password: string
  timestamp: string
}

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private httpClient: HttpClient) { }

  getAllLogins() {
    return this.httpClient.get<Logins[]>("http://localhost:8080/logins")
  }
}
