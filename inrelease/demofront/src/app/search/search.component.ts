import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../interfaces/product';
import { HttpService } from '../http.service';

@Component({
    selector: 'app-search',
    templateUrl: './search.component.html',
    styleUrls: ['./search.component.css'],
    providers: [HttpService]
})
export class SearchComponent implements OnInit {

    search: Product = {};
    receivedProducts: Product = null;

    constructor(private route: ActivatedRoute, private httpService: HttpService) {
    }

    ngOnInit() {
        this.search.title = this.route.snapshot.queryParams.text;
        this.httpService.postProductOneTitle(this.search)
            .subscribe(
                (data: Product) => { this.receivedProducts = data; },
                error => console.log(error)
            );
    }
}
