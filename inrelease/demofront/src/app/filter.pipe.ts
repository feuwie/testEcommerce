import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'filter'
})
export class FilterPipe implements PipeTransform {
    // transform(check: any, checked: any): any {
    //     return checked ? check.filter(user => user.age == "44") : check;
    // }
    groups = [44, 11, 333];
    groupOne = [1, 2, 3];
    lol: any[] = null;
    check = 0;

    contains(target, pattern) {
        var value = 0;
        pattern.forEach(function (word) {
            value = value + target.includes(word);
        });
        return (value === 1)
    }

    // transform(items?: any[], field?: string, fields?: string, value?: any[]): any[] {
    //     if (this.lol == null) {
    //         this.lol = items;
    //     }
    //     if (!items) {
    //         return [];
    //     }
    //     if (!field || !fields || !value || value.length <= 0) {
    //         return items;
    //     }
    //     console.log(this.lol);
    //     if (this.contains(value, this.groups)) {
    //         this.lol = items.filter(singleItem => {
    //             return (singleItem != null && singleItem[field] != null && singleItem[field] != undefined && value.indexOf(singleItem[field]) >= 0);
    //         });
    //         return this.lol;
    //         // return items.filter(singleItem => {
    //         //     // tslint:disable-next-line: max-line-length
    //         //     return (singleItem != null && singleItem[field] != null && singleItem[field] != undefined && value.indexOf(singleItem[field]) >= 0);
    //         // });
    //     }

    //     if (this.contains(value, this.groupOne)) {
    //         this.lol = items.filter(singleItem => {
    //             return (singleItem != null && singleItem[fields] != null && singleItem[fields] != undefined && value.indexOf(singleItem[fields]) >= 0);
    //         });
    //         return this.lol;
    //         // return items.filter(singleItem => {
    //         //     // tslint:disable-next-line: max-line-length
    //         //     return (singleItem != null && singleItem[fields] != null && singleItem[fields] != undefined && value.indexOf(singleItem[fields]) >= 0);
    //         // });
    //     }
    // }
    transform(items?: any[], field?: string, fields?: string, value?: any[]): any[] {
        if (this.lol == null) {
            this.lol = items;
        }
        if (!this.lol) {
            return [];
        }
        if (!field || !fields || !value || value.length <= 0) {
            return items;
        }
        console.log(this.lol);
        console.log(value);
        if (value.includes(11) && this.check == 0) {
            this.check++;
            console.log('here 1');
            this.lol = this.lol.filter(singleItem => {
                return (singleItem != null && singleItem[field] != null && singleItem[field] != undefined && value.indexOf(singleItem[field]) >= 0);
            });
            console.log(this.lol);
            return this.lol;
        }

        if (value.includes(1)) {
            console.log('here 2');
            this.lol = this.lol.filter(singleItem => {
                return (singleItem != null && singleItem[fields] != null && singleItem[fields] != undefined && value.indexOf(singleItem[fields]) >= 0);
            });
            return this.lol;
        }
    }
}
