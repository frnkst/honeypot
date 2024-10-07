import {Injectable, NgZone} from '@angular/core';
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

  constructor(private _zone: NgZone) { }

  getServerSentEvent(url: string): Observable<AttackEvent> {
    return new Observable(observer => {
      const eventSource = new EventSource(url);
      eventSource.onmessage = event => {
        const attackEvent = JSON.parse(event.data);
        attackEvent.ipDetails = JSON.parse(attackEvent.ipDetails);

        this._zone.run(() => {
          observer.next(attackEvent);
        });
      };

      eventSource.onerror = error => {
        this._zone.run(() => {
          observer.error(error);
        });
      };

      return () => eventSource.close();
    });
  }
}
