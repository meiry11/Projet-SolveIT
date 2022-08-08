import { Component, Input, OnInit } from "@angular/core";
import { UntypedFormBuilder, UntypedFormGroup } from "@angular/forms";
import { ActivatedRoute } from "@angular/router";
@Component({
  selector: 'app-buttons-modify',
  templateUrl: "buttons.component.html",
})
export class ButtonsModifyComponent implements OnInit {
  
/*  @Input()
  hidden: boolean=true;*/
  public checkboxGroupForm: UntypedFormGroup = Object.create(null);

  public radioGroupForm: UntypedFormGroup = Object.create(null);

  @Input()
  chemin!:string;

  @Input()
  num!:string;

  constructor(private formBuilder: UntypedFormBuilder,private route: ActivatedRoute) { }

  buttondata: any = 
    {
      btn: "warning",
      icon: "fa-list"
    };


  model = {
    left: true,
    middle: false,
    right: false,
  };

  model1 = 1;

  ngOnInit() {
    this.checkboxGroupForm = this.formBuilder.group({
      left: true,
      middle: false,
      right: false,
    });

    this.radioGroupForm = this.formBuilder.group({
      model: 1,
    });
    if(this.num != ""){
      //this.chemin = this.chemin+"?num='"+this.num+"'";

    }
  }
  toggle(i:number){
  //  this.hidden= !this.hidden;
}
}
