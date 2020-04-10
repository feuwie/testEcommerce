import { CartService } from './../cart.service';
import { HttpService } from './../http.service';
import { WishlistService } from './../wishlist.service';
import { Component, OnInit } from '@angular/core';
import { Product } from '../interfaces/product';
import { ActivatedRoute } from '@angular/router';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { MessengerService } from '../messenger.service';

@Component({
    selector: 'app-favourites',
    templateUrl: './favourites.component.html',
    styleUrls: ['./favourites.component.css'],
    providers: [HttpService]
})
export class FavouritesComponent implements OnInit {

    wishlistItems = [];
    addedToWishlist: any[] = [];
    receivedProducts: any = null;
    cartItems: any;

    constructor(private wishlistService: WishlistService, private httpService: HttpService, public route: ActivatedRoute, private http: HttpClient, private msg: MessengerService, private cartService: CartService) { }

    ngOnInit() {
        this.handeSubscription();
        this.load();
        this.loadCart();
    }

    sortBy(val: string): void {
        // if (val === 'Сначала новые') {
        //     this.receivedProducts.sort(function (a, b) {
        //         return a.price - b.price;
        //     });
        // }
        // if (val === 'Сначала старые') {
        //     this.receivedProducts.sort(function (a, b) {
        //         return b.price - a.price;
        //     });
        // }
        if (val === 'Сначала дешевые') {
            this.wishlistItems.sort((a: Product, b: Product) => {
                return a.price - b.price;
            });
        }
        if (val === 'Сначала дорогие') {
            this.wishlistItems.sort((a: Product, b: Product) => {
                return b.price - a.price;
            });
        }
    }

    load() {
        this.wishlistService.getWishlist().subscribe(items => {
            this.wishlistItems = items;
        });
    }

    loadCart() {
        this.cartService.getCartItems().subscribe((items) => {
            this.cartItems = items;
        });
    }

    handeSubscription() {
        this.msg.getMsg().subscribe((product: Product) => {
            this.load();
            this.loadCart();
        });
    }

    handleAddToCart(index: any) {
        this.cartService.addProductToCart(this.wishlistItems[index], index, this.cartItems).subscribe(() => {
            this.msg.sendMsg(this.wishlistItems[index]);
        });
    }

    handleDelFromWishlist(index: any) {
        this.wishlistService.removeFromWishlist(this.wishlistItems[index].id).subscribe(() => {
            this.msg.sendMsg(this.wishlistItems[index]);
            this.addedToWishlist[index] = false;
        });
    }
}
