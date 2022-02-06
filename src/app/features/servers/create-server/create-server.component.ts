import {Component, OnInit, ViewChild} from '@angular/core';
import {FileChangeEvent} from '@angular/compiler-cli/src/perform_watch';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {CreateServerService} from './create-server.service';
import {GuildService} from '../guild/guild.service';

@Component({
  selector: 'app-create-server',
  templateUrl: './create-server.component.html',
  styleUrls: ['./create-server.component.scss'],
})
export class CreateServerComponent implements OnInit {

  publicServerFlag = false;

  createServerDisplayed = false;
  joinServerDisplayed = false;

  createServerFormGroup: FormGroup;
  joinServerFormGroup: FormGroup;

  imageToUpload: File;
  iconImageUrl: string | ArrayBuffer;

  invalidIconFileType = false;
  invalidInviteLink = false;


  constructor(private router: Router, private createServerService: CreateServerService, private guildDataService: GuildService) { }

  ngOnInit() {
    this.createServerFormGroup = new FormGroup({
      serverName: new FormControl(null, [Validators.required, Validators.maxLength(50)]),
      serverDescription: new FormControl(null, [Validators.maxLength(250)]),
    });
    this.joinServerFormGroup = new FormGroup({
      inviteLink: new FormControl(null, [Validators.required])
    });
  }

  createAServerClicked() {
    this.createServerDisplayed = true;
  }

  customizeServerBackClicked() {
    this.createServerDisplayed = false;
  }

  joinServerBackClicked() {
    this.joinServerDisplayed = false;
  }

  onFileChange(event) {
    if (event.target.files[0].type.includes('image')) {
      this.invalidIconFileType = false;
      this.imageToUpload = event.target.files[0];
      const fileReader = new FileReader();
      fileReader.readAsDataURL(this.imageToUpload);
      fileReader.onload = (fileEvent) => {
        this.iconImageUrl = fileEvent.target.result;
      };
    } else {
      this.invalidIconFileType = true;
    }
  }

  get serverName() {
    return this.createServerFormGroup.get('serverName');
  }

  get serverDescription() {
    return this.createServerFormGroup.get('serverDescription');
  }

  get inviteLink() {
    return this.joinServerFormGroup.get('inviteLink');
  }

  joinAServerClicked() {
    this.joinServerDisplayed = true;
  }

  findServerClicked() {
    this.router.navigateByUrl('/navbar/servers');
    this.createServerService.createServerPopupStatus.next(false);
  }

  createServer() {
    this.createServerService.createServer(this.imageToUpload, this.createServerFormGroup.get('serverName').value,
      this.createServerFormGroup.get('serverDescription').value).subscribe(result => {
        this.guildDataService.addGuild(result.id, result);
        this.router.navigate(['navbar', 'server', result.id]);
        this.createServerService.createServerPopupStatus.next(false);
    });
  }

}
