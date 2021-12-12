import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-guild',
  templateUrl: './guild.page.html',
  styleUrls: ['./guild.page.scss'],
})
export class GuildPage implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.router.navigate(['channel', '5'], {relativeTo: this.route});
  }

}
