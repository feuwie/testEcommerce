import { Component, OnInit } from '@angular/core';
import { ApiService } from './auth/login/api.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
})
export class AppComponent {

    // constructor(private auth: ApiService, private router: Router) { }

    // ngOnInit() {
    //     if (this.auth.isAuthenticated != null) {
    //         if (this.auth.isAuthenticated && this.auth.getAuthType() == "customer") {
    //             // this.router.navigate(["/home"]);
    //             this.router.navigate([""]);
    //         } else if (this.auth.isAuthenticated && this.auth.getAuthType() == "admin") {
    //             // this.router.navigate(["/admin"]);
    //             this.router.navigate([""]);
    //         }
    //     } else if (this.auth.isAuthenticated == null) {
    //         this.router.navigate(["/login"]);
    //     }
    // }
}
