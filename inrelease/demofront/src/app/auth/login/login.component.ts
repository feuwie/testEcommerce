import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';
import { FormBuilder } from '@angular/forms';
import { SESSION_STORAGE, StorageService } from 'angular-webstorage-service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    model: any = {};

    // constructor(
    //     private route: ActivatedRoute,
    //     private router: Router,
    //     private http: HttpClient
    // ) { }


    private loginForm: any;
    error = false;
    constructor(private apiService: ApiService,
        private router: Router,
        private formBuilder: FormBuilder) {
        this.createForm();
    }

    ngOnInit() {
    }
    createForm() {
        this.loginForm = this.formBuilder.group({
            email: '',
            password: ''
        });
    }
    login(): void {
        this.apiService.userLogin(this.loginForm.value).
            subscribe(res => {
                if (res.status == "200") {
                    this.apiService.storeToken(res.auth_TOKEN, "customer");
                    this.router.navigate(['']);
                    this.error = false;
                } else if (res.status == "500") {
                    this.apiService.adminLogin(this.loginForm.value).
                        subscribe(res => {
                            if (res.status == "200") {
                                this.apiService.storeToken(res.auth_TOKEN, "admin");
                                // this.router.navigate(['/admin']);
                                this.router.navigate(['']);
                            } else {
                                // this.router.navigate(['/login']);
                                this.router.navigate(['']);
                            }
                            this.error = false;
                        },
                            err => {
                                console.log(err);
                            });
                }
            },
                err => {
                    console.log(err);
                });
    }

    // ngOnInit() {
    //     sessionStorage.setItem('token', '');
    // }

    // login() {
    //     let url = 'http://localhost:8080/login';
    //     this.http.post<Observable<boolean>>(url, {
    //         userName: this.model.username,
    //         password: this.model.password
    //     }).subscribe(isValid => {
    //         if (isValid) {
    //             sessionStorage.setItem('token', btoa(this.model.username + ':' + this.model.password));
    //             this.router.navigate(['']);
    //         } else {
    //             alert("Authentication failed.")
    //         }
    //     });
    // }

}
