import { Product } from './../interfaces/product';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../auth/login/api.service';

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

    // auth = 0;
    product: Product = new Product();

    private loggedType: string;
    constructor(private auth: ApiService, private router: Router) {

        if (this.auth.getAuthType() == null) {
            this.loggedType = "";
        } else {
            if (this.auth.getAuthType() == "customer") {
                this.loggedType = "customer";
            } else if (this.auth.getAuthType() == "admin") {
                this.loggedType = "admin";
            }
        }
    }

    ngOnInit() {
    }

    logout() {
        this.loggedType = "";
        this.auth.removeToken();
        this.router.navigate(['']);
    }

    search() {
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
            this.router.navigate(['search'], { queryParams: { text: this.product.title } }));
    }
}
