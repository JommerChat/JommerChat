import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CreateServerService {

  createServerPopupStatus = new BehaviorSubject<boolean>(false);
  $createServerPopupStatus = this.createServerPopupStatus.asObservable();

  constructor() { }
}
