import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.page.html',
  styleUrls: ['./navbar.page.scss'],
})
export class NavbarPage implements OnInit {

  displayCreateServerDialog = false;

  navTabSelectedList: boolean[] = [false, false, false, false, false, false];

  constructor(private router: Router) { }

  ngOnInit() {
  }

  navTabClicked(index: number): void {
    // replace logic to determine selected with a reference to a singleton service
    this.navTabSelectedList[index] = !this.navTabSelectedList[index];
    for (let i = 0; i < this.navTabSelectedList.length; i++) {
      if (i !== index && this.navTabSelectedList[i] === true ) {
        this.navTabSelectedList[i] = false;
      }
    }

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
    this.displayCreateServerDialog = true;
  }

}
