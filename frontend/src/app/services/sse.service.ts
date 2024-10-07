import {Injectable} from '@angular/core';
import {Observable} from "rxjs";

export type AttackEvent = {
  timestamp: string,
  username: string,
  password: string,
  ip: string,
  ipDetails: IPDetails
}

export type IPDetails = {
  city: string,
  country: string,
  isp: string,
}

@Injectable({
  providedIn: 'root'
})
export class SseService {

  constructor() { }

  getServerSentEvent(url: string): Observable<AttackEvent> {
    return new Observable(observer => {
      const eventSource = new EventSource(url);
      eventSource.onmessage = event => {
        const attackEvent = JSON.parse(event.data);
        attackEvent.ipDetails = JSON.parse(attackEvent.ipDetails);
        observer.next(attackEvent);
      };

      eventSource.onerror = error => {
        observer.error(error);
      };

      return () => eventSource.close();
    });
  }
}
