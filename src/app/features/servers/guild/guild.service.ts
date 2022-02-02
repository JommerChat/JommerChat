import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../../environments/environment';
import {GuildInfo} from '../../../shared/models/GuildInfo';
import {BehaviorSubject, Observable, Subject} from 'rxjs';
import {take} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class GuildService {

  constructor(private httpClient: HttpClient) { }

  /*  Map that stores guild data locally
   *  it is populated with the initial request of guild info and when a user accesses a channel
   *  any new messages to existing channels are updated
   */
  guildDataMap = new Map();

  guildData = new BehaviorSubject<Map<string, GuildInfo>>(null);
  guildData$ = this.guildData.asObservable();

  manageGuildInfo(guildId: string): void {
    if (!this.guildDataMap.has(guildId)) {
      const initialInfoSubscription = this.fetchInitialGuildInfo(guildId).pipe(take(1)).subscribe(result => {
        this.guildDataMap.set(guildId, result);
        this.guildData.next(this.guildDataMap);
        initialInfoSubscription.unsubscribe();
      });
    }
  }

  fetchInitialGuildInfo(guildId: string): Observable < GuildInfo > {
    return this.httpClient.get(`${environment.guildOrchBaseUrl}/initialInfo?guildId=${guildId}`) as Observable<GuildInfo>;
  }

  fetchGuildsForMember(): Observable<GuildInfo[]> {
    return this.httpClient.get<GuildInfo[]>(`${environment.guildOrchBaseUrl}/fetchGuilds`);
  }


}
