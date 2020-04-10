import { CartService } from './../cart.service';
import { Product } from '../interfaces/product';
import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Category } from '../interfaces/category';
import { Router, ActivatedRoute } from '@angular/router';
import { MessengerService } from '../messenger.service';

@Component({
    selector: 'app-product',
    templateUrl: './product.component.html',
    styleUrls: ['./product.component.css'],
    providers: [HttpService]
})
export class ProductComponent implements OnInit {

    isAbout = true;
    isSpec = false;
    receivedProduct: Product = null;
    receivedProducts: any = null;
    receivedCategories: Category = null;
    articleSlug: any;
    cartItems: any;

    constructor(private httpService: HttpService, public router: Router, private route: ActivatedRoute, private cartService: CartService, private msg: MessengerService) { }

    ngOnInit() {
        this.handeSubscription();
        this.httpService.postProductOneArticle(this.route.params['_value'])
            .subscribe(
                (data: Product) => { this.receivedProduct = data; },
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

    handleAddToCart() {
        this.cartService.addProductToCart(this.receivedProduct[0], 0, this.cartItems).subscribe(() => {
            this.msg.sendMsg(this.receivedProduct[0]);
        });
    }
}
