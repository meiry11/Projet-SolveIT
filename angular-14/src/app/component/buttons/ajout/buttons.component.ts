import { Component, Input, OnInit } from "@angular/core";
import { UntypedFormBuilder, UntypedFormGroup } from "@angular/forms";
@Component({
  selector: 'app-buttons',
  templateUrl: "buttons.component.html",
})
export class ButtonsComponent implements OnInit {
  @Input()
  chemin: string="";
  public checkboxGroupForm: UntypedFormGroup = Object.create(null);

  public radioGroupForm: UntypedFormGroup = Object.create(null);

  constructor(private formBuilder: UntypedFormBuilder) { }

  buttondata: any = 
    {
      btn: "info",
      icon: "fa-heart"
    };



    // buttonSuuce: any =
    //   {
    //     btn: "success",
    //     icon: "fa-check"
    //   };

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
  }
  onClick(){
    alert("gffhdh"+this.chemin);
  }
}
