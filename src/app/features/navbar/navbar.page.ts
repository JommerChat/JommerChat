import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.page.html',
  styleUrls: ['./navbar.page.scss'],
})
export class NavbarPage implements OnInit {

  navTabSelectedList: boolean[] = [false, false, false, false, false, false];

  constructor() { }

  ngOnInit() {
  }

  navTabClicked(index: number): void {
    this.navTabSelectedList[index] = !this.navTabSelectedList[index];
    for (let i = 0; i < this.navTabSelectedList.length; i++) {
      if (i !== index && this.navTabSelectedList[i] === true ) {
        this.navTabSelectedList[i] = false;
      }
    }
  }

}
