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
  ngOnInit(): void {
    this.activityId = this.activatedRoute.snapshot.params['activityId'];
    this.benefitId = this.activatedRoute.snapshot.params['benefitId'];

    this.benefitsDataService.getOne(this.activityId, this.benefitId).subscribe({
      next: (benefit: Benefit) => {
        this.benefitForm = this.formBuilder.group({
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
    this.benefitsDataService.update(this.activityId, this.benefitId, newBenefit).subscribe({
      next: () => {
        this.toastrService.success("Benefit Updated")
        this.router.navigate([`activity/${this.activityId}/`])
      },
      error: (error) => {
        this.toastrService.error(error.error.message);
      }
    })
  }
}
