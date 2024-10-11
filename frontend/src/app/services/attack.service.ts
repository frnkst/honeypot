import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export type Top = {
  item: string;
  count: number;
}

export type TopType = 'password' | 'username' | 'ip'

@Injectable({
  providedIn: 'root'
})
export class AttackService {

  constructor(private httpClient: HttpClient) { }

  getTop(type: TopType) {
    return this.httpClient.get<Top[]>(`http://localhost:8080/top?type=${type}`)
  }
}
