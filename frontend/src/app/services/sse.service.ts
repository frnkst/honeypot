import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Logins} from "./login-service.service";

@Injectable({
  providedIn: 'root'
})
export class SseService {

  constructor() { }

  getServerSentEvent(url: string): Observable<Logins> {
    return new Observable(observer => {
      const eventSource = new EventSource(url);

      eventSource.onmessage = event => {
        observer.next(JSON.parse(event.data));
      };

      eventSource.onerror = error => {
        observer.error(error);
      };

      return () => eventSource.close();
    });
  }
}
