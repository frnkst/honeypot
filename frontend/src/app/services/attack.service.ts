import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export type TopPasswords = {
  password: string;
  count: number;
}

export type TopUsernames = {
  username: string;
  count: number;
}

export type TopIPs = {
  ip: string;
  count: number;
}

@Injectable({
  providedIn: 'root'
})
export class AttackService {

  constructor(private httpClient: HttpClient) { }

  getTopPasswords() {
    return this.httpClient.get<TopPasswords[]>("http://localhost:8080/top-passwords")
  }

  getTopUsernames() {
    return this.httpClient.get<TopUsernames[]>("http://localhost:8080/top-usernames")
  }

  getTopIps() {
    return this.httpClient.get<TopIPs[]>("http://localhost:8080/top-ips")
  }
}
