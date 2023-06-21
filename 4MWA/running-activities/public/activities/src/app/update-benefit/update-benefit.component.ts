import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

import { BenefitsDataService, Benefit } from '../benefits-data.service';

@Component({
  selector: 'app-update-benefit',
  templateUrl: './update-benefit.component.html',
  styleUrls: ['./update-benefit.component.css']
})
export class UpdateBenefitComponent implements OnInit {
  public benefitForm!: FormGroup;
  public activityId!: string;
  public benefitId!: string;

  constructor(
    private _formBuilder: FormBuilder,
    private _benefitsDataService: BenefitsDataService,
    private _toastrService: ToastrService,
    private _router: Router,
    private _activatedRoute: ActivatedRoute
  ) {
    this.benefitForm = this._formBuilder.group({
      name: ['', Validators.required],
      duration: ['', Validators.required],
      description: ['', Validators.required],
    })
  }
  ngOnInit(): void {
    this.activityId = this._activatedRoute.snapshot.params['activityId'];
    this.benefitId = this._activatedRoute.snapshot.params['benefitId'];

    this._benefitsDataService.getOne(this.activityId, this.benefitId).subscribe({
      next: (benefit: Benefit) => {
        this.benefitForm = this._formBuilder.group({
          name: [benefit.name, Validators.required],
          description: [benefit.description, Validators.required],
        })
      }
    })
  }

  update() {
    const newBenefit = new Benefit();
    newBenefit.name = this.benefitForm.value.name;
    newBenefit.description = this.benefitForm.value.description;
    this._benefitsDataService.update(this.activityId, this.benefitId, newBenefit).subscribe({
      next: () => {
        this._toastrService.success("Benefit Updated")
        this._router.navigate([`activity/${this.activityId}/`])
      },
      error: (error) => {
        this._toastrService.error(error.error.message);
      }
    })
  }
}
