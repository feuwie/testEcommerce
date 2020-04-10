import { ApiService } from './auth/login/api.service';
import { FormatPipe } from './format.pipe';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { FavouritesComponent } from './favourites/favourites.component';
import { MainComponent } from './main/main.component';
import { CartComponent } from './cart/cart.component';
import { CatalogComponent } from './catalog/catalog.component';
import { ProductComponent } from './product/product.component';
import { OrderComponent } from './order/order.component';
import { AppRoutingModule } from './app-routing.module';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { ProfileComponent } from './profile/profile.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { FilterPipe } from './filter.pipe';
import { SearchComponent } from './search/search.component';
import { CategoryComponent } from './category/category.component';
import { LoginComponent } from './auth/login/login.component';
import { RegistrationComponent } from './auth/registration/registration.component';
import { StorageServiceModule } from 'angular-webstorage-service';

@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        FooterComponent,
        FavouritesComponent,
        MainComponent,
        CartComponent,
        CatalogComponent,
        ProductComponent,
        OrderComponent,
        PagenotfoundComponent,
        ProfileComponent,
        FilterPipe,
        SearchComponent,
        CategoryComponent,
        FormatPipe,
        LoginComponent,
        RegistrationComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        ReactiveFormsModule,
        FormsModule,
        AppRoutingModule,
        RouterModule,
        NgxPaginationModule,
        StorageServiceModule
    ],
    providers: [ApiService],
    bootstrap: [AppComponent]
})
export class AppModule { }
