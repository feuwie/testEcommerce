import { WishlistService } from './../wishlist.service';
import { CartService } from './../cart.service';
import { Component, OnInit, Input } from '@angular/core';
import { Category } from '../interfaces/category';
import { Product } from '../interfaces/product';
import { HttpService } from '../http.service';
import { Router, ActivatedRoute } from '@angular/router';
import { MessengerService } from './../messenger.service';
import { HttpClient } from '@angular/common/http';
import { ThrowStmt } from '@angular/compiler';
import { map } from 'rxjs/operators';

@Component({
    selector: 'app-catalog',
    templateUrl: './catalog.component.html',
    styleUrls: ['./catalog.component.css'],
    providers: [HttpService]
})
export class CatalogComponent implements OnInit {

    lol: any;
    receivedProducts: any = null;
    receivedTest: any = null;
    receivedCategories: Category = null;
    config: any;
    addedToWishlist: any[] = [];
    cartItems: any;

    constructor(private httpService: HttpService, private router: Router, public route: ActivatedRoute, private msg: MessengerService, private cartService: CartService, private wishlistService: WishlistService, private http: HttpClient) {
        this.config = {
            currentPage: 1,
            itemsPerPage: 2
        };
        route.queryParams.subscribe(params => this.config.currentPage = params.page ? params.page : 1);
    }

    pageChange(newPage: number) {
        this.router.navigate(['category/' + this.route.snapshot.params.id], { queryParams: { page: newPage } });
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
            this.receivedProducts.sort((a: Product, b: Product) => {
                return a.price - b.price;
            });
        }
        if (val === 'Сначала дорогие') {
            this.receivedProducts.sort((a: Product, b: Product) => {
                return b.price - a.price;
            });
        }
    }

    groups = ['44', '11', '333'];
    groupOne = ['1', '2', '3'];
    groupValue: any[] = [];
    changeGroup(event) {
        const group = event.target.value;
        const index = this.groupValue.indexOf(Number(group));
        if (index < 0) {
            this.groupValue.push(group);
        } else {
            this.groupValue.splice(index, 1);
        }
        const newGroupValue = [];
        newGroupValue.push.apply(newGroupValue, this.groupValue);
        this.groupValue = newGroupValue;
        // if (this.groups.includes(group)) {
        this.groupValue = this.groupValue.map(parseFloat);
        // }
    }

    ngOnInit() {
        this.handeSubscription();
        this.httpService.postProductOneParent(this.route.snapshot.params.id)
            .subscribe(
                (data: Product) => {
                    this.receivedProducts = data;
                    this.wishlistService.getWishlist().subscribe(productIds => {
                        for (let i = 0; i < this.receivedProducts.length; i++) {
                            for (let j = 0; j < productIds.length; j++) {
                                if (this.receivedProducts[i].id == productIds[j].id) {
                                    this.addedToWishlist[i] = true;
                                }
                            }
                        }
                    });
                },
                error => console.log(error)
            );
        this.httpService.getCategoryAll()
            .subscribe(
                (data: Category) => { this.receivedCategories = data; },
                error => console.log(error)
            );
        this.loadCart();
    }

    handeSubscription() {
        this.msg.getMsg().subscribe((product: Product) => {
            this.loadCart();
        });
    }

    loadCart() {
        this.cartService.getCartItems().subscribe((items) => {
            this.cartItems = items;
        });
    }

    handleAddToCart(index: any) {
        this.cartService.addProductToCart(this.receivedProducts[index], index, this.cartItems).subscribe(() => {
            this.msg.sendMsg(this.receivedProducts[index]);
        });
    }

    handleAddToWishlist(index: any) {
        this.wishlistService.addToWishlist(this.receivedProducts[index]).subscribe(() => {
            this.msg.sendMsg(this.receivedProducts[index]);
            this.addedToWishlist[index] = true;
        });
    }

    handleDelFromWishlist(index: any) {
        this.wishlistService.removeFromWishlist(this.receivedProducts[index].id).subscribe(() => {
            this.msg.sendMsg(this.receivedProducts[index]);
            this.addedToWishlist[index] = false;
        });
    }
}
