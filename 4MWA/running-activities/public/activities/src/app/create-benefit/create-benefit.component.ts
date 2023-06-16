import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';

import { Benefit, BenefitsDataService } from '../benefits-data.service';


@Component({
  selector: 'app-create-benefit',
  templateUrl: './create-benefit.component.html',
  styleUrls: ['./create-benefit.component.css']
})
export class CreateBenefitComponent {
  public benefitForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private benefitsDataService: BenefitsDataService,
    private toastrService: ToastrService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    this.benefitForm = this.formBuilder.group({
      name: ['', Validators.required],
      duration: ['', Validators.required],
      description: ['', Validators.required],
    })
  }

  create() {
    const activityId = this.activatedRoute.snapshot.params['activityId'];
    const newBenefit = new Benefit();
    newBenefit.name = this.benefitForm.value.name;
    newBenefit.description = this.benefitForm.value.description;
    this.benefitsDataService.create(activityId, newBenefit).subscribe({
      next: () => {
        this.toastrService.success("Benefit created!")
        this.router.navigate([`activity/${activityId}/`])
      },
      error: (error) => {
        this.toastrService.error(error.error.message);
      }
    })
  }
}
