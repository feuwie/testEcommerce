import { Cart } from './interfaces/cart';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Product } from './interfaces/product';
import { flatMap, map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class CartService {
    receivedCart: any = [];
    counter = 1;
    qtyNumber = [];
    cartItems: any;


    constructor(private http: HttpClient) { }

    getPromo() {
        return this.http.get('http://localhost:8080/promo', { responseType: 'json' }).pipe(
            map((result: any[]) => {
                let receivedCart: any = [];
                for (let item of result) {
                    receivedCart.push(item);
                }
                return receivedCart;
                // let cartItems: any = [];
                // for (let item of result) {
                //     let productExists = false;
                //     for (let i in cartItems) {
                //         if (cartItems[i].id === item.id) {
                //             cartItems[i].qty++;
                //             productExists = true;
                //             break;
                //         }
                //     }
                //     if (!productExists) {
                //         cartItems.push({
                //             id: item.id,
                //             title: item.title,
                //             qty: 1,
                //             price: item.price,
                //             article: item.article,
                //             img: item.img
                //         });
                //     }
                // }
                // return cartItems;
            })
        );
    }



    getCartItems() {
        return this.http.get('http://localhost:8080/cart', { responseType: 'json' }).pipe(
            map((result: any[]) => {
                let cartItems: any = [];
                for (let item of result) {
                    // let productExists = false;
                    // for (let i in cartItems) {
                    //     if (cartItems[i].id === item.id) {
                    //         cartItems[i].qty++;
                    //         productExists = true;
                    //         break;
                    //     }
                    // }
                    // if (!productExists) {
                    // cartItems.push(new CartItems(item.id, item.product));
                    cartItems.push({
                        id: item.id,
                        title: item.title,
                        qty: item.qty,
                        price: item.price,
                        article: item.article,
                        img: item.img
                    });
                }
                // }
                return cartItems;
            })
        );
    }

    changeQuantity(product?: Product, num?: any) {
        let body: any;
        if (num != null) {
            body = { id: product.id, qty: num };
        } else {
            body = { id: product.id, qty: product['qty'] };
        }
        return this.http.post('http://localhost:8080/updatecart', body);
    }

    addProductToCart(product?: Product, index?: any, prod?: any) {
        let ifExist = false;
        if (this.qtyNumber[index] == null) {
            this.qtyNumber[index] = 1;
        }
        for (let item of prod) {
            if (product.id == item.id) {
                ifExist = true;
                this.qtyNumber[index] = this.qtyNumber[index] + 1;
                const body = { id: product.id, qty: this.qtyNumber[index] };
                return this.http.post('http://localhost:8080/updatecart', body);
            }
        }
        if (!ifExist) {
            // tslint:disable-next-line: max-line-length
            const body = { id: product.id, img: product.img, title: product.title, price: product.price, article: product.article, qty: this.qtyNumber[index] };
            return this.http.post('http://localhost:8080/addcart', body);
        }
    }

    removeFromCart(productId) {
        return this.http.post('http://localhost:8080/delcart', { id: productId });
    }
}
