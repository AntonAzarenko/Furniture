import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../../auth/token-storage.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
    private token: TokenStorageService,
    private router: Router
  ) { }

  ngOnInit() {
    this.token.signOut();
    this.router.navigate(['/greeting']);
    window.location.reload();
  }

}
