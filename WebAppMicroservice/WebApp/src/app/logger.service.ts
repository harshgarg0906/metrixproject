import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoggerService {

  constructor() { }

  static log(value: any, ...rest: any[]) {
    if (!environment.production) {
      console.log(value, ...rest);
    }
  }

  static error(value: any, ...rest: any[]) {
    if (!environment.production) {
      console.error(value, ...rest);
    }
  }

  static warn(value: any, ...rest: any[]) {
    if (!environment.production) {
      console.warn(value, ...rest);
    }
  }

  log(value: any, ...rest: any[]) {
    LoggerService.log(value, ...rest);
  }

  error(value: any, ...rest: any[]) {
    LoggerService.error(value, ...rest);
  }

  warn(value: any, ...rest: any[]) {
    LoggerService.warn(value, ...rest);
  }
}
