import { Component, OnInit } from "@angular/core";
import { UntypedFormBuilder, UntypedFormGroup } from "@angular/forms";
@Component({
  selector: 'app-buttons-delete',
  templateUrl: "buttons.component.html",
})
export class ButtonsDeleteComponent implements OnInit {
  public checkboxGroupForm: UntypedFormGroup = Object.create(null);

  public radioGroupForm: UntypedFormGroup = Object.create(null);

  constructor(private formBuilder: UntypedFormBuilder) { }

  buttondata: any = 
    {
      btn: "danger",
      icon: "fa-envelope"
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
  }
}
