import { AfterViewInit, Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { TableColumn } from "./TableColumn";
import { MatSort, Sort } from "@angular/material/sort";
import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";

@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.scss']
})
export class TablesComponent implements OnInit {



  id: any;
  @Input() tableName: any;

  public tableDataSource = new MatTableDataSource([]);
  public displayedColumns: string[];
  @ViewChild(MatPaginator, { static: false }) matPaginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) matSort: MatSort;
  @Input() tableSpec: string;
  @Input() isPageable = false;
  @Input() isSortable = false;
  @Input() isFilterable = false;
  @Input() tableColumns: TableColumn[];
  @Input() rowActionIcon: string;
  @Input() rowTimesheetAppIcon: string;
  @Input() employeeIcon: string;
  @Input() projectIcon: string;
  @Input() timesheetReportIcon: string;
  @Input() paginationSizes: number[] = [5, 10, 15];
  @Input() defaultPageSize = this.paginationSizes[1];
  @Output() sort: EventEmitter<Sort> = new EventEmitter();
  @Output() delete: EventEmitter<any> = new EventEmitter<any>();
  @Output() view: EventEmitter<any> = new EventEmitter<any>();
  @Output() update: EventEmitter<any> = new EventEmitter<any>();

  // this property needs to have a setter, to dynamically get changes from parent component
  @Input() set tableData(data: any[]) {
    this.setTableDataSource(data);
  }

  constructor() {
  }

  ngOnInit(): void {

    const columnNames = this.tableColumns.map((tableColumn: TableColumn) => tableColumn.name);
    if (this.tableSpec == "individualTimesheet") {
      this.displayedColumns = [...columnNames, this.rowActionIcon];
    }
    if (this.tableSpec == "timesheetApproval") {
      this.displayedColumns = [...columnNames, this.rowTimesheetAppIcon];
    }
    if (this.tableSpec == "employeeList") {
      this.displayedColumns = [...columnNames,this.employeeIcon];
    }
    if (this.tableSpec == "projectList") {
      this.displayedColumns = [...columnNames,this.projectIcon];
    }
    if (this.tableSpec == "timesheetReport") {
      this.displayedColumns = [...columnNames];
    }

  }
  // we need this, in order to make pagination work with *ngIf
  ngAfterViewInit(): void {
    this.tableDataSource.paginator = this.matPaginator;
  }
  setTableDataSource(data: any) {
    this.tableDataSource = new MatTableDataSource<any>(data);
    this.tableDataSource.paginator = this.matPaginator;
    this.tableDataSource.sort = this.matSort;
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.tableDataSource.filter = filterValue.trim().toLowerCase();
  }
  sortTable(sortParameters: Sort) {
    // defining name of data property, to sort by, instead of column name
    sortParameters.active = this.tableColumns.find(column => column.name === sortParameters.active).dataKey;
    this.sort.emit(sortParameters);
  }
  callUpdate(data: any) {

    console.log("Update clicked");
    if (this.tableSpec == "individualTimesheet") {
      this.update.emit(data);  
    }
    else if (this.tableSpec == "timesheetApproval") {
      this.update.emit(data.timesheetId);  
    }
    else if (this.tableSpec == "employeeList") {
      this.update.emit(data.employeeId);  
    }
    else if (this.tableSpec == "projectList") {
      this.update.emit(data.projectId);  
    }
   
  }

  callView(data) {
    console.log("View clicked");
    if (this.tableSpec == "individualTimesheet") {
      this.view.emit(data);  
    }
    else if (this.tableSpec == "timesheetApproval") {
      this.view.emit(data);  
    }
    else if (this.tableSpec == "employeeList") {
      this.view.emit(data.employeeId);  
    }
    else if (this.tableSpec == "projectList") {
      this.view.emit(data.projectId);  
    }
  }
  callDelete(data) {
    console.log("Delete clicked");
    if (this.tableSpec == "individualTimesheet") {
      this.delete.emit(data.timesheetId);  
    }
    else if (this.tableSpec == "timesheetApproval") {
      this.delete.emit(data.timesheetId);  
    }
    else if (this.tableSpec == "employeeList") {
      this.delete.emit(data.employeeId);  
    }
    else if (this.tableSpec == "projectList") {
      this.delete.emit(data.projectId);  
    }
  }

}