import { Component, OnInit } from '@angular/core';
import { CalcService } from "../calc-service/calc.service";
import { FormGroup, FormBuilder, FormArray } from '@angular/forms';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  calculations: FormArray;
  calcForm: FormGroup;
  result: number[];

  constructor(
    private calcService: CalcService,
    private formBuilder: FormBuilder) {
    this.calcForm = this.formBuilder.group({
      calculations: this.formBuilder.array([this.buildCalculation()])
    })
    this.calculations = this.calcForm.get("calculations") as FormArray;
  }

  ngOnInit(): void {
  }

  get calculationControls() {
    return this.calcForm.get("calculations")["controls"];
  }

  calculate(): void {
    if (this.calcForm.status === "INVALID") {
      alert("Please fill all fields correctly.");
    } else {
      this.calcService.calculate(this.calculations.value)
      .subscribe(r => this.result = r, e => alert("An error occurred while calling the web service."));
    }
  }

  addCalculation(): void {
    this.calculations.push(this.buildCalculation());
  }

  private buildCalculation(): FormGroup {
    return this.formBuilder.group({
      leftNumber: null,
      rightNumber: null,
      operator: "+"
    });
  }
}
