import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {GuildInfo} from '../../../shared/models/GuildInfo';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CreateServerService {

  createServerPopupStatus = new BehaviorSubject<boolean>(false);
  $createServerPopupStatus = this.createServerPopupStatus.asObservable();

  createServer(iconFile, name, description): Observable<GuildInfo> {
    const formData = new FormData();
    formData.append('icon', iconFile);
    formData.append('name', name);
    formData.append('description', description);
    return this.httpClient.post<GuildInfo>(`${environment.guildOrchBaseUrl}/createServer`, formData);
  }

  constructor(private httpClient: HttpClient) { }
}
