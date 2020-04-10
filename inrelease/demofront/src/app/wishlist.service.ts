import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from './interfaces/product';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class WishlistService {

    constructor(private http: HttpClient) { }

    getWishlist() {
        return this.http.get('http://localhost:8080/wishlist', { responseType: 'json' }).pipe(
            map((result: any[]) => {
                let productIds = [];
                // result.forEach(item => productIds.push(item.id));
                for (let item of result) {
                    productIds.push({
                        id: item.id,
                        title: item.title,
                        price: item.price,
                        article: item.article,
                        img: item.img
                    });
                }
                return productIds;
            })
        );
    }

    addToWishlist(product: Product) {
        const body = { id: product.id, img: product.img, title: product.title, price: product.price, article: product.article };
        return this.http.post('http://localhost:8080/addwishlist', body);
    }

    removeFromWishlist(productId) {
        return this.http.post('http://localhost:8080/delwishlist', { id: productId });
    }
}
