import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export type Top = {
  item: string;
  count: number;
}

export type AllStats = {
  value1: number;
  value15: number;
  value60: number;
  value1440: number;
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

  getAllStats() {
    return this.httpClient.get<AllStats>(`http://localhost:8080/all-stats`)
  }
}
