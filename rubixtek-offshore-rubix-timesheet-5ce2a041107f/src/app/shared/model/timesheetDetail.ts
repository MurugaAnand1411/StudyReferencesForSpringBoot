import { DateRange } from "./dateRange";
export class Holidaytimeoff {
    holidaytimeoffId:String;
    date: String;
   hours:String;
}
export class Applytimeoff {
    applytimeoffId:String;
    date: String;
   hours:String;
}
export class TimesheetDetail{
    projectname: number;
    task: string;
    daterange:DateRange[];
    holidaytimeoff:Holidaytimeoff[];
    applytimeoff:Applytimeoff[];
}