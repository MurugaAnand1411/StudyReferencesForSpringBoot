import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dataGetter'
})
export class DataGetterPipe implements PipeTransform {
  transform(object: any, keyName: string, ...args: unknown[]): unknown {
    return object[keyName];
    }
}
