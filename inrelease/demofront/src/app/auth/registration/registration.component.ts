import { Component, OnInit } from '@angular/core';
import { ApiService } from '../login/api.service';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';

@Component({
    selector: 'app-registration',
    templateUrl: './registration.component.html',
    styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

    private registerForm: any;
    constructor(private apiService: ApiService,
        private router: Router,
        private formBuilder: FormBuilder) {
        this.createForm();
    }

    ngOnInit() {
    }
    createForm() {
        this.registerForm = this.formBuilder.group({
            email: '',
            password: '',
            username: '',
            age: '',
            usertype: 'customer'
        });
    }
    register(): void {
        this.apiService.register(this.registerForm.value).
            subscribe(res => {
                if (res.status == "400") {
                    console.log("Details cannot be empty");
                } else {
                    this.router.navigate(['']);
                }
            },
                err => {
                    alert("An error has occured, Please try again !!!");
                });
    }

}
