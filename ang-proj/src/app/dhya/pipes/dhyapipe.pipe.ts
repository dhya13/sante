import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dhyapipe'
})
export class DhyapipePipe implements PipeTransform {

  transform(value:string, isMedecin:boolean= true): string {
    if (isMedecin){
     return 'Le Medecin ' + value;
    }else{
     return 'L\'infirmier ' + value;
    }
   }

}
