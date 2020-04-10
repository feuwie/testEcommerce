import { Product } from './product';

export class Cart {
    id?: number;
    productId: number;
    title?: string;
    qty: number;
    price: number;
    img?: string;

    constructor(id: number, product: Product, qty = 1) {
        this.id = id;
        this.productId = product.id;
        this.title = product.title;
        this.qty = qty;
        this.price = product.price;
        this.img = product.img;
    }
}