import {AfterViewInit, Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CreateServerService} from '../servers/create-server/create-server.service';
import {GuildService} from '../servers/guild/guild.service';
import {AuthService} from '../../shared/auth/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.page.html',
  styleUrls: ['./navbar.page.scss'],
})
export class NavbarPage implements OnInit, AfterViewInit {

  displayCreateServerDialog = false;
  removeCreateServerLayout = false;
  displayedServer: Array<{icon: string, name: string, id: string, selected: boolean}> = [];

  navTabSelectedList: boolean[] = [false, false, false, false, false, false];

  constructor(private router: Router, private createServerService: CreateServerService, private guildService: GuildService,
              private authService: AuthService) { }

  ngOnInit() {
    this.createServerService.$createServerPopupStatus.subscribe(result => {
      if (result !== this.displayCreateServerDialog) {
        this.displayCreateServerDialog = !this.displayCreateServerDialog;
        this.removeCreateServerLayout = false;

        if (!this.displayCreateServerDialog) {
          setTimeout(() => {
            this.removeCreateServerLayout = true;
          }, 500);
        }
      }
    });
    console.log(`The OKTA access token is: ${this.authService.getAccessToken()}`);
  }

  ngAfterViewInit() {
    this.guildService.fetchGuildsForMember().subscribe(result => {
      for (const i of result) {
        const icon = i.icon;
        const name = i.name;
        const id = i.id;
        const selected = false;
        this.displayedServer.push({icon, name, id, selected});
      }
      console.log(`Contents of displayedServer after pushing elements: ${JSON.stringify(this.displayedServer)}`);
    });
  }

  navTabClicked(index: number, serverId?: string): void {
    // replace logic to determine selected with a reference to a singleton service

    for (let i = 0; i < this.navTabSelectedList.length; i++) {
      if (i !== index ) {
        this.navTabSelectedList[i] = false;
      }
    }

    if (serverId) {
      for (const i of this.displayedServer) {
        if (i.selected === true && i.id === serverId) {
          return;
        }
        i.selected = i.id === serverId;
      }
      this.router.navigate(['navbar', 'server', serverId]);
      return;
    } else {
      for (const i of this.displayedServer) {
        i.selected = false;
      }
    }

    this.navTabSelectedList[index] = !this.navTabSelectedList[index];

    switch (index) {
      case 0:
        this.router.navigateByUrl('/navbar/mentions');
        break;
      case 1:
        this.router.navigateByUrl('/navbar/chat/friend-view');
        break;
      case 2:
        this.router.navigateByUrl('/navbar/explore');
        break;
      case 3:
        this.router.navigateByUrl('/navbar/servers');
        break;
      default:
        this.router.navigate(['navbar', 'server', index]);
    }
  }

  createServer() {
    this.createServerService.createServerPopupStatus.next(!this.displayCreateServerDialog);
  }

}
