import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FlexLayoutModule } from '@angular/flex-layout';
import {ScrollingModule} from '@angular/cdk/scrolling';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomMaterialModule } from './material/custom-material.module';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { NavnsideWrapperComponent } from './navigation-contents/navnside-wrapper/navnside-wrapper.component';
import { SidebarComponent } from './navigation-contents/sidebar/sidebar.component';
import { TopNavigationComponent } from './navigation-contents/top-navigation/top-navigation.component';
import {LayoutComponent} from './navigation-contents/layout/layout.component'
import { CdkTableModule } from '@angular/cdk/table';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { WeekPickerComponent } from './week-picker/week-picker.component';
import{TablesComponent} from './tables/tables.component';
import { DataGetterPipe } from './pipes/data-getter.pipe';
import { NgxSpinnerModule } from 'ngx-spinner';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    CustomMaterialModule,
    FormsModule,
    CdkTableModule,
    HttpClientModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    ScrollingModule,
    NgbModule,
    NgxSpinnerModule,
   
  ],
  declarations: [
    NavnsideWrapperComponent,SidebarComponent,TopNavigationComponent,LayoutComponent, WeekPickerComponent,TablesComponent,DataGetterPipe
  ],
  exports: [
    FormsModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    CustomMaterialModule,
    ScrollingModule,
    NgbModule,
    NavnsideWrapperComponent,SidebarComponent,TopNavigationComponent,LayoutComponent,
    WeekPickerComponent,
    TablesComponent,NgxSpinnerModule,
    
  ],
  entryComponents: [



  ]
})
export class SharedModule { }
