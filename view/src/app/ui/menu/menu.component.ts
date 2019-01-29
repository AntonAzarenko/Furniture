import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../../auth/token-storage.service";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  public roles: string[];
  public authority: string;
  public modules: string;

  setModules(value: string) {
    this.modules = value;
    console.log(this.modules);
  }

  constructor(private tokenStorage: TokenStorageService) {
  }

  ngOnInit() {
    this.modules = 'user';
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        } else if (role === 'ROLE_PM') {
          this.authority = 'pm';
          return false;
        }
        this.authority = 'user';
        console.log(this.modules);
        return true;
      });
    }
  }

}
