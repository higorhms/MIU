import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

import { AuthenticationService } from '../authentication.service';
import { Benefit, BenefitsDataService } from '../benefits-data.service';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-benefit',
  templateUrl: './benefit.component.html',
  styleUrls: ['./benefit.component.css']
})
export class BenefitComponent implements OnInit {
  public activityId!: string;
  public benefit: Benefit = new Benefit();

  get isSignedIn() { return this._authenticationService.isSignedIn }

  constructor(
    private _benefitsDataService: BenefitsDataService,
    private _authenticationService: AuthenticationService,
    private _toastrService: ToastrService,
    private _activatedRoute: ActivatedRoute,
    private _route: Router,
  ) { }


  delete() {
    this._benefitsDataService.delete(this.activityId, this.benefit._id).subscribe({
      next: () => {
        this._toastrService.success(environment.SUCCESS_MESSAGE);
        this._route.navigate([`/activity/${this.activityId}`]);
      },
      error: (error) => this._toastrService.error(error.error.message)
    })
  }

  _getBenefit(benefitId: string) {
    this._benefitsDataService.getOne(this.activityId, benefitId).subscribe({
      next: (benefit) => {
        this.benefit = benefit;
      },
      error: (error) => this._toastrService.error(error.error.message)
    })
  }

  ngOnInit(): void {
    this.activityId = this._activatedRoute.snapshot.params['activityId'];
    const benefitId = this._activatedRoute.snapshot.params['benefitId'];
    this._getBenefit(benefitId);
  }
}
