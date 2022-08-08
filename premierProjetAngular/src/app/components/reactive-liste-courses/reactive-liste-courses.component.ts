import { Component, OnInit } from '@angular/core';
import { UntypedFormControl,UntypedFormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-reactive-liste-courses',
  templateUrl: './reactive-liste-courses.component.html',
  styleUrls: ['./reactive-liste-courses.component.scss']
})
export class ReactiveListeCoursesComponent implements OnInit {
  article: UntypedFormGroup;
  articles: any[] = [];

  constructor() {
    this.article = new UntypedFormGroup({
      designation: new UntypedFormControl('',Validators.required),
      prix: new UntypedFormControl('',Validators.required)
    });
   }

  ngOnInit(): void {
  }

  addArticle(){
    this.articles.push(this.article.value);
    this.article.reset();
  }

  get totalPrice():number{
    return this.articles.reduce((total,article)=>total + article.prix,0);
  }

}
