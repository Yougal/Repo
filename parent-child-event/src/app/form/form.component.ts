import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  name: string;
  dob: string;
  formValue: string;
  constructor() { }

  ngOnInit() {
  }

  onSubmit(myForm: NgForm) {
    this.formValue = JSON.stringify(myForm.value);
  }

}
