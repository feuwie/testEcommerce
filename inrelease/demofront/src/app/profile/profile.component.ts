import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../auth/login/api.service';

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

    auth: string;
    receivedUser: any;

    constructor(private api: ApiService, private route: Router) { }

    ngOnInit() {
        this.auth = this.api.getToken();
        this.api.getProfile(this.auth).subscribe(res => { this.receivedUser = res.user; console.log(res); }, err => {
            console.log(err);
        });
    }

}
