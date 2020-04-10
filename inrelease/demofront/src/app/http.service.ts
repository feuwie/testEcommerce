import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './interfaces/user';
import { Product } from './interfaces/product';
import { Category } from './interfaces/category';

@Injectable()
export class HttpService {
    number: any;

    constructor(private http: HttpClient) { }

    // postAdd(user: User) {
    //     const body = { name: user.name, age: user.age };
    //     return this.http.post('http://localhost:8080/hello/add', body);
    // }

    // postDel(user: User) {
    //     const body = { id: user.id };
    //     return this.http.post('http://localhost:8080/hello/delete', body);
    // }

    // postUpd(user: User) {
    //     const body = { id: user.id, name: user.name, age: user.age };
    //     return this.http.post('http://localhost:8080/hello/update', body);
    // }
    // postListOne(user: User) {
    //     const body = { id: user.id };
    //     return this.http.post('http://localhost:8080/hello/{id}', body);
    // }
    // getListAll() {
    //     return this.http.get('http://localhost:8080/hello/all', { responseType: 'json' });
    // }




    // getProductAll() {
    //     return this.http.get('http://localhost:8080/products', { responseType: 'json' });
    // }

    postProductOneArticle(product: Product) {
        const body = { article: product.article };
        return this.http.post('http://localhost:8080/{article}', body);
    }

    postProductOneParent(product: Product) {
        this.number = Number(product);
        const body = { parent: this.number };
        return this.http.post('http://localhost:8080/{parent}', body);
    }

    postProductOneTitle(product: Product) {
        const body = { title: product.title };
        return this.http.post('http://localhost:8080/{title}', body);
    }

    getCategoryAll() {
        return this.http.get('http://localhost:8080/categories', { responseType: 'json' });
    }
}
