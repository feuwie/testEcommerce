import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpHeaders, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
// import { Product } from '../Model/product';
// import { User } from '../Model/user';
import { SESSION_STORAGE, StorageService } from 'angular-webstorage-service';
// import { Address } from '../Model/address';

@Injectable({
    providedIn: 'root'
})
export class ApiService {
    private REG_API = "http://localhost:8080/user/registration";
    private LOGU_API = "http://localhost:8080/user/login";
    private LOGA_API = "http://localhost:8080/admin/login";

    constructor(@Inject(SESSION_STORAGE) private storage: StorageService, private http: HttpClient) { }

    register(user: User): Observable<any> {
        return this.http.post(this.REG_API,
            JSON.stringify(user),
            {
                headers:
                    { 'Content-Type': 'application/json' }
            });
    }

    // userLogin(user: User): Observable<any> {
    //     return this.http.post(this.LOGU_API,
    //         JSON.stringify(user),
    //         {
    //             headers:
    //                 { 'Content-Type': 'application/json' }
    //         });
    // }
    userLogin(user: User): Observable<any> {
        const body = { email: user.email, password: user.password };
        return this.http.post(this.LOGU_API, body);
    }

    adminLogin(user: User): Observable<any> {
        return this.http.post(this.LOGA_API,
            JSON.stringify(user),
            {
                headers:
                    { 'Content-Type': 'application/json' }
            });
    }


    getProfile(auth: string): Observable<any> {
        const myheader = new HttpHeaders().set('AUTH_TOKEN', auth);
        return this.http.post<any>("http://localhost:8080/profile", null, { headers: myheader });
      }


    public isAuthenticated(): boolean {
        return this.getToken() !== null;
    }

    storeToken(token: string, auth_type: string) {
        this.storage.set("auth_token", token);
        this.storage.set("auth_type", auth_type);
    }

    getAuthType(): string {
        if (this.storage.get("auth_type") !== null) {
            return this.storage.get("auth_type");
        }
        return null;
    }

    getToken() {
        return this.storage.get("auth_token");
    }

    removeToken() {
        this.storage.remove("auth_type");
        return this.storage.remove("auth_token");
    }

}