import { Component, OnInit } from '@angular/core';
import {VERSION} from "../../app.constants";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isNavbarCollapsed: boolean;
  version: string;
  constructor() {
    this.version = VERSION;
    this.isNavbarCollapsed = true;
  }

  ngOnInit() {
  }

  collapseNavbar() {
    this.isNavbarCollapsed = true;
  }

  toggleNavbar() {
    this.isNavbarCollapsed = !this.isNavbarCollapsed;
  }

}
