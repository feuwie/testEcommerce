import { CartService } from './../cart.service';
import { Product } from './../interfaces/product';
import { MessengerService } from './../messenger.service';
import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Cart } from '../interfaces/cart';
import { WishlistService } from '../wishlist.service';
import { HttpClient } from '@angular/common/http';
import { Category } from '../interfaces/category';
import { Promo } from '../interfaces/promo';

@Component({
    selector: 'app-cart',
    templateUrl: './cart.component.html',
    styleUrls: ['./cart.component.css'],
    providers: [HttpService]
})
export class CartComponent implements OnInit {

    cartTotal = 0;
    cartQty = 0;
    cartPromo = 0;
    discount = 0;
    promo = false;
    cartItems = [];

    savedGenderExample = [];
    receivedProducts: any = null;
    receivedPromos: any = null;
    receivedTest: any = null;
    addedToWishlist: any[] = [];

    constructor(private httpService: HttpService, private msg: MessengerService, private cartService: CartService, private wishlistService: WishlistService, private http: HttpClient) { }

    ngOnInit() {
        this.handeSubscription();
        this.loadCartItems();
        this.loadPromo();
        this.savedGenderExample[0] = 3;
    }

    handeSubscription() {
        this.msg.getMsg().subscribe((product: Product) => {
            this.loadCartItems();
        });
    }

    loadCartItems() {
        this.cartService.getCartItems().subscribe(items => {
            this.cartItems = items;
            this.loadWishlist();
            this.loadPromo();
            this.calcCartTotal();
            this.calcQty();
        });
    }

    loadWishlist() {
        this.wishlistService.getWishlist().subscribe(productIds => {
            for (let i = 0; i < this.cartItems.length; i++) {
                for (let j = 0; j < productIds.length; j++) {
                    if (this.cartItems[i].id == productIds[j].id) {
                        this.addedToWishlist[i] = true;
                    }
                }
            }
        });
    }

    loadPromo() {
        // this.http.get('http://localhost:8080/promo', { responseType: 'json' })
        //     .subscribe(
        //         (data: Promo) => {
        //             this.receivedPromos = data;
        //         },
        //         error => console.log(error)
        //     );
        this.cartService.getPromo().subscribe(items => {
            this.receivedPromos = items;
            this.addTodo(localStorage.getItem('title'));
        });
    }

    calcCartTotal() {
        this.cartTotal = 0;
        this.cartItems.forEach(item => {
            this.cartTotal += (item.qty * item.price);
        });
        this.cartPromo = this.cartTotal;
    }

    calcQty() {
        this.cartQty = 0;
        this.cartItems.forEach(item => {
            this.cartQty += Number(item.qty);
        });
    }

    handleDelFromCart(index: any) {
        this.cartService.removeFromCart(this.cartItems[index].id).subscribe(() => {
            this.msg.sendMsg(this.cartItems[index]);
        });
    }

    chooseQty(val: string, index: any) {
        this.cartItems[index].qty = val;
        this.calcCartTotal();
        this.calcQty();
    }

    handleAddToWishlist(index: any) {
        this.wishlistService.addToWishlist(this.cartItems[index]).subscribe(() => {
            this.msg.sendMsg(this.cartItems[index]);
            this.addedToWishlist[index] = true;
        });
    }

    handleDelFromWishlist(index: any) {
        this.wishlistService.removeFromWishlist(this.cartItems[index].id).subscribe(() => {
            this.msg.sendMsg(this.cartItems[index]);
            this.addedToWishlist[index] = false;
        });
    }

    addTodo(title: string) {
        localStorage.setItem('title', title);
        for (let item of this.receivedPromos) {
            if (item.code == title) {
                if (item.type == 'nominal') {
                    if (item.value < this.cartTotal) {
                        this.discount = item.value;
                        this.cartPromo = this.cartTotal - this.discount;
                    } else {
                        console.log('error');
                    }
                }
                if (item.type == 'percentage') {
                    this.discount = Math.round(this.cartTotal / 100 * item.value);
                    this.cartPromo = this.cartTotal - this.discount;
                }
            }
        }
    }

    delPromo() {
        localStorage.removeItem('title');
        if (document.getElementById('titleInput') != null) {
            (document.getElementById('titleInput') as HTMLInputElement).value = '';
        }
        this.cartPromo = this.cartTotal;
        this.discount = 0;
    }

    change(num: any, product: any) {
        if (num.srcElement.value > 0 && num.srcElement.value <= 10) {
            this.cartService.changeQuantity(product, num.srcElement.value).subscribe(() => {
                this.msg.sendMsg(num.srcElement.value);
            });
        } else {
            console.log('Неверное значение!');
        }
    }

    plus(index: any) {
        if (this.cartItems[index].qty < 10) {
            this.cartItems[index].qty++;
        }
        this.cartService.changeQuantity(this.cartItems[index]).subscribe(() => {
            this.msg.sendMsg(this.cartItems[index]);
        });
    }

    minus(index: any) {
        if (this.cartItems[index].qty > 1) {
            this.cartItems[index].qty--;
        }
        this.cartService.changeQuantity(this.cartItems[index]).subscribe(() => {
            this.msg.sendMsg(this.cartItems[index]);
        });
    }
}
