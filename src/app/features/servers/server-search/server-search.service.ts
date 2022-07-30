import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../../environments/environment';
import {Subject} from 'rxjs';
import {ServerCardDetails} from '../../../shared/models/ServerCardDetails';

@Injectable({
  providedIn: 'root'
})
export class ServerSearchService {

  constructor(private httpClient: HttpClient) { }

  private guildCardSubject = new Subject<ServerCardDetails>();
  guildCardObservable = this.guildCardSubject.asObservable();

  findAllGuilds() {
    this.httpClient.get<ServerCardDetails>(environment.guildOrchBaseUrl + '/fetchServerCards').subscribe(result => {
      this.guildCardSubject.next(result);
    });
  }

}
