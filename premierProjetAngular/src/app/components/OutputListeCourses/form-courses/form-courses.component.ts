import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { UntypedFormGroup,UntypedFormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-form-courses',
  templateUrl: './form-courses.component.html',
  styleUrls: ['./form-courses.component.scss']
})
export class FormCoursesComponent implements OnInit {
  @Output()
  onAddArticleEvent: EventEmitter<any> = new EventEmitter();
  article: UntypedFormGroup = this.formBuilder.group({
    designation: ['',Validators.required],
    prix: ['',Validators.required]
  });

  submitted: boolean = false;

  constructor(private formBuilder:UntypedFormBuilder) { }

  ngOnInit(): void {
  }

  private resetForm(){
    this.article.reset();
    this.submitted = false;
  }

  public onSubmit(){
    this.submitted=true;
    if(this.article.valid){
      this.onAddArticleEvent.emit(this.article.value);
      this.resetForm();
    }else{
      alert("formulaire invalide");
    }
  } 

  private addArticle(){

  }

  get form(){
    return this.article.controls;
  }

}
