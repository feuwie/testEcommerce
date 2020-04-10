import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { ApiService } from 'src/app/auth/login/api.service';

@Injectable({
    providedIn: 'root'
})
export class AuthguardGuard implements CanActivate {

    constructor(private auth: ApiService, private router: Router) {
    }
    canActivate(): boolean {
        console.log(this.auth);
        console.log(this.auth.isAuthenticated);
        if (!this.auth.isAuthenticated) {
            console.log('im here');
            this.router.navigate(['/login']);
            return false;
        }
        return true;
    }
}
