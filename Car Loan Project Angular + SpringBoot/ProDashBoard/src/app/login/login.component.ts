import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
export interface user {
  username: string;
  password: string;
  repassword: string;
  email: string;
}
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  u: user = {
    username: "",
    password: "",
    repassword: "",
    email: ""
  };
  constructor(private router: Router) {}
  username: string='';
  password:string='';
  ngOnInit() {}
  login(u) {
    console.log("login called");
    console.log(u.username,u.password);
    
    if (u.username === 're' && u.password === 're') {
      console.log('in fileinitiliase');
      sessionStorage.setItem('role', 'fileinitiliase');
      this.router.navigateByUrl("role/fileinitiliase/filedash");
    }

    if (u.username === 'cm' && u.password === 'cm') {
      console.log('in sianctionletter');
      sessionStorage.setItem('role', 'sianctionletter');
      this.router.navigateByUrl("role/sianctionletter/sianctiondash");
    }
  }

}
