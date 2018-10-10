import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';

@Component({
  selector: 'app-register-final',
  templateUrl: './register-final.component.html',
  styleUrls: ['./register-final.component.scss']
})
export class RegisterFinalComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $("#step-1").show();$("#step-2, #step-3, #step-4").hide();
    // $("#submit-btn").addClass("disabled");
    //Open Step 1 Page
    $(function(){
        $(".open-step-1").click(function() {
            $(".frm").hide("fast");
            $("#step-1").show("slow");
        });
    });
    //Open Step 2 Page
    $(function() {
        $(".open-step-2").click(function() {
            $(".frm").hide("fast");
            $("#step-2").show("slow");

       });
    });

    //Open Step 3 Page
    $(function(){
        $(".open-step-3").click(function() {
            $(".frm").hide("fast");
            $("#step-3").show("slow");
            // $("#submit-btn").removeClass("disabled");
        });
    });

    $(function(){
        $(".open-step-4").click(function() {
            $(".frm").hide("fast");
            $("#step-4").show("slow");
            $("#submit-btn").removeClass("disabled");
        });
    });
    //Reset Form
    $(function() {
        $(".reset-steps, .close").click(function() {
            $('#basicform')[0].reset();
            // alert("start over");
            $(".frm").hide("fast");
            $("#step-1").show("slow");
       });
    });
    // $(function(){//back step 1
    // // Binding back button on second step
    // $(".open-step-1").click(function() {
    //     $("#step-but2").removeClass("active");
    //     $("#step-but1").addClass("active");
    //  $(".frm").hide("fast");
    //  $("#step-1").show("slow");
    // });
    // });
    //
    // $(function(){//back step 2
    // // Binding back button on third step
    // $(".back3").click(function() {
    //     $("#step-but3").removeClass("active");
    //     $("#step-but2").addClass("active");
    //  $(".frm").hide("fast");
    //  $("#step-2").show("slow");
    // });
    // });
    $(function(){
        $(".open3").click(function() {
          alert("Submission completed");
          // if (v.form()) {
            // optional
            // used delay form submission for a seccond and show a loader image
          //   $("#loader").show();
          //    setTimeout(function(){
          //      $("#basicform").html('<h2>Thanks for your time.</h2>');
          //    }, 1000);
          //   // Remove this if you are not using ajax method for submitting values
          //   return false;
          // // }
        });
    });
    $(function() {
      $("#register-submit").click(function(){
        alert("Form submitted");
        // e.preventDefault();
      });
    });
    $(function() {
      $("#forgot-password-submit").click(function(){
        $("#pass-reset-modal").modal("show");
      });
    });

    $(function() {
      $("#login-submit").click(function(){
        $("#welcome-modal").modal("show");
      });
    });

  }

}
