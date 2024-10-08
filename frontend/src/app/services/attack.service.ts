import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export type TopPasswords = {
  password: string;
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
}
