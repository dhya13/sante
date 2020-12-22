import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-childtest',
  templateUrl: './childtest.component.html',
  styleUrls: ['./childtest.component.css']
})
export class ChildtestComponent implements OnInit, OnChanges {

   @Input() testInputFather: string ;
   // @Input() testInputFather: string;


  constructor() { }
  ngOnChanges(changes: SimpleChanges): void {debugger
    console.log('ngOnChanges ' + changes);
  }

  ngOnInit(): void {
  }

}
