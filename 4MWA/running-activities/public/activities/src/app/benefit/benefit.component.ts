import { Component, OnInit } from '@angular/core';
import { Benefit, BenefitsDataService } from '../benefits-data.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-benefit',
  templateUrl: './benefit.component.html',
  styleUrls: ['./benefit.component.css']
})
export class BenefitComponent implements OnInit {
  public activityId!: string;
  public benefit: Benefit = new Benefit();

  get isSignedIn() { return this.authenticationService.isSignedIn }

  constructor(
    private benefitsDataService: BenefitsDataService,
    private authenticationService: AuthenticationService,
    private toastrService: ToastrService,
    private _activatedRoute: ActivatedRoute,
    private _route: Router,
  ) { }


  delete() {
    this.benefitsDataService.delete(this.activityId, this.benefit._id).subscribe({
      next: () => {
        this._route.navigate([`/activity/${this.activityId}`]);
        this.toastrService.success("Successfully deleted");
      },
      error: (error) => {
        this.toastrService.error(error.error.message);
      }
    })
  }

  _getBenefit(benefitId: string) {
    this.benefitsDataService.getOne(this.activityId, benefitId).subscribe({
      next: (benefit) => {
        this.benefit = benefit;
        console.log(benefit)
      },
      error: (error) => {
        console.log(error)
      }
    })
  }


  ngOnInit(): void {
    this.activityId = this._activatedRoute.snapshot.params['activityId'];
    const benefitId = this._activatedRoute.snapshot.params['benefitId'];
    this._getBenefit(benefitId);
  }
}
