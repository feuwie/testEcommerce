import { Component, OnInit } from '@angular/core';
import { Category } from '../interfaces/category';
import { HttpService } from '../http.service';

@Component({
    selector: 'app-category',
    templateUrl: './category.component.html',
    styleUrls: ['./category.component.css'],
    providers: [HttpService]
})
export class CategoryComponent implements OnInit {

    receivedCategories: Category = null;

    constructor(private httpService: HttpService) { }

    ngOnInit() {
        this.httpService.getCategoryAll()
            .subscribe(
                (data: Category) => { this.receivedCategories = data; },
                error => console.log(error)
            );
    }
}
