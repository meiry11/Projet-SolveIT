import { Component, OnInit } from '@angular/core';
import {UntypedFormBuilder,UntypedFormGroup,Validators} from '@angular/forms'

@Component({
  selector: 'app-formbuiled-liste-courses',
  templateUrl: './formbuiled-liste-courses.component.html',
  styleUrls: ['./formbuiled-liste-courses.component.scss']
})
export class FormbuiledListeCoursesComponent implements OnInit {
  article: UntypedFormGroup=this.formBuilder.group({
    designation: ['',Validators.required],
    prix: ['',Validators.required]
  });

  submitted: boolean=false;

  articles: any[] =[];

  constructor(private formBuilder: UntypedFormBuilder) {

   }

  ngOnInit(): void {
  }

  onSubmit():boolean{
    this.submitted=true;
    if(this.article.invalid){
      return false;
    }else{
      this.addArticle();
      return true;
    }
  }

  addArticle(){
    this.articles.push(this.article.value);
    this.article.reset();
    this.submitted=false;
  }

  get totalPrice(): number{
    return this.articles.reduce((total,article)=> total+article.prix,0);
  }

  get form(){
    return this.article.controls;
  }

}
