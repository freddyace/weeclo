import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-reg-form',
  templateUrl: './reg-form.component.html',
  styleUrls: ['./reg-form.component.scss']
})
export class RegFormComponent implements OnInit {

  /*
  registerForm: FormGroup;
  constructor(private fb:FormBuilder, private router: Router) {}
  ngOnInit(){
    this.registerForm = this.fb.group({
      fname: ['', Validators.required],
      lname: ['', Validators.required]
    });
  }
  get f() {return this.registerForm.controls};
  submitRegister(data){
    alert(data.fname);
    // submitRegister(data) {
      if(data.fname == 'a' && data.lname =='a') {
        alert("Register Successful");
        this.router.navigate(['/home']);
      }else {
        alert("Register Unsuccessful");
        return;
      }
  }*/
  constructor() { }

  ngOnInit() {
    $(function () {
        var navListItems = $('div.setup-panel div a'),
            allWells = $('.setup-content'),
            allPrevBtn = $('.prevBtn'),
            allNextBtn = $('.nextBtn');

        allWells.hide();

        navListItems.click(function (e) {
            e.preventDefault();
            var $target = $($(this).attr('href')),
                $item = $(this);

            if (!$item.hasClass('disabled')) {
                navListItems.removeClass('btn-success').addClass('btn-default');
                $item.addClass('btn-success');
                allWells.hide();
                $target.show();
                $target.find('input:eq(0)').focus();
            }
        });
        allNextBtn.click(function () {
            var curStep = $(this).closest(".setup-content"),
                curStepBtn = curStep.attr("id"),
                nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
                curInputs = curStep.find("input[type='text'],input[type='url']"),
                isValid = true;

            // $(".form-group").removeClass("has-error");
            // for (var i = 0; i < curInputs.length; i++) {
            //     if (!curInputs[i].validity.valid) {
            //         isValid = false;
            //         $(curInputs[i]).closest(".form-group").addClass("has-error");
            //     }
            // }

            // if (isValid)
              nextStepWizard.removeAttr('disabled').trigger('click');
        });

        allPrevBtn.click(function () {
            var curStep = $(this).closest(".setup-content"),
                curStepBtn = curStep.attr("id"),
                prevStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().prev().children("a"),
                curInputs = curStep.find("input[type='text'],input[type='url']"),
                isValid = true;

            // $(".form-group").removeClass("has-error");
            // for (var i = 0; i < curInputs.length; i++) {
            //     if (!curInputs[i].validity.valid) {
            //         isValid = false;
            //         $(curInputs[i]).closest(".form-group").addClass("has-error");
            //     }
            // }

            // if (isValid)
              prevStepWizard.removeAttr('disabled').trigger('click');
        });

        $('div.setup-panel div a.btn-success').trigger('click');
    });
  }

}
