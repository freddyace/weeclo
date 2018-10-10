/*-----------------------------------------------------------
                            INDEX
-------------------------------------------------------------*/


  //modals
  var loginModal = document.getElementById('login-modal');
  var forgotPasswordModal = document.getElementById('forget-password-modal');
  var logoutModal = document.getElementById('logout-modal');
  var welcomeModal = document.getElementById('welcome-modal');
  var loginButton = document.getElementById('loginButton');
  // var loginEmail = document.getElementById('loginEmail');
  // var loginPass = document.getElementById('loginPass');
  var loginForm = document.getElementById('loginForm');


  //This is where the validation for login can go
  function validateLogin(v1, v2) {
    // if(v1 == 'a' && v2 =='a') {
    //   return true;
    // }else {
    //   return false;
  // }
    return validateCredentials(v1,v2);
  }
  loginForm.addEventListener('submit', function(e) {
    var loginEmail = $('#loginEmail').val();
    var loginPass = $('#loginPass').val();
    if(loginEmail == '' || loginPass == '') {
      alert("Missing information");
      e.preventDefault();
    } else {
      var loginResponse = validateLogin(loginEmail, loginPass);
      if(loginResponse.toString()=="Successfully validated user!"){
        //TODO: handle success login
        alert("correct information");
        console.log(loginResponse.toString())
        // document.location = './search.html';
      }
      else if(loginResponse.toString()=="Incorrect credentials"){
        //TODO: Handle unsuccessful login
      }
      else if (loginResponse.toString()=="We've ran into a problem! Try again later."){
        //TODO: Handle issue
      }
      else{
        //TODO: Handle unhandled exception
      }
        // var correctInfo = validateLogin(loginEmail, loginPass);
        // if(!correctInfo){
        //   alert('incorrect information');
        //   e.preventDefault();
        // }else {
        //   alert("correct information");
        //   document.location = './search.html';
        // }
    }
  }, false);
  //reset login form when click out of modals
    $(function(){
      $("#login-modal").on('hidden.bs.modal', function(){
          $("#loginForm")[0].reset();
      });
    });
/*Triggered when User logs out*/
function logoutSubmit() {
  alert("Logout Successful");
  document.location.href='./index.html';
}
//Register Information

$("#step-1").show();$("#step-2, #step-3, #step-4").hide();
var step1NextBtn = $("#step1Next").prop('disabled', true);
var step2NextBtn = $("#step2Next").prop('disabled', true);
var step3NextBtn = $("#step3Next").prop('disabled', true);
var registerButton = $("#registerButton").prop('disabled', true);
var registerForm = document.getElementById('registerForm');

//This is where the validation for login can go
registerForm.addEventListener('submit', function(event) {
  var ownerType = $('input[name=ownerType]:checked').val();
  var itemCategory = $('input[name=itemCategory]:checked').val();
  var regLocation = $('input[name=regLocation]:checked').val();
  var regFirst = $('#regFirst').val();
  var regLast = $('#regLast').val();
  var regEmail = $('#regEmail').val();
  var regPassword = $('#regPassword').val();
  var regPassword2 = $('#regPassword2').val();
  alert(ownerType + ' ' + itemCategory + ' ' + regLocation + ' ' + regFirst +
    ' ' + regLast + ' ' + regEmail + ' ' + regPassword + ' ' + regPassword2);
  // alert("form submitted");
  if(regFirst == '' || regLast == '' || regEmail == '' ||
    regPassword == '' || regPassword2 == '') {
    alert("Missing information");
    event.preventDefault();
  } else {
    alert("filled in information");
      document.location = './search.html';
  }
}, false);

$(function(){
  $('#register-modal').on('hidden.bs.modal', function(){
    $(step1NextBtn, step2NextBtn, step3NextBtn).prop('disabled', true);
    $("#registerButton").prop('disabled', true);
    $("#registerForm")[0].reset();
    $(".form").hide('fast');
    $("#step-1").show('slow');
    });
});
//enable Button for next step
$(function(){
  $("input[name=ownerType]").on('click', function(){
    $(step1NextBtn).prop('disabled', false);

  });
});
//enable step2 button
$(function(){
  $("input[name=itemCategory]").on('click', function(){
    $(step2NextBtn).prop('disabled', false);
  });
});
//enable step3 button
$(function(){
  $("input[name=regLocation]").on('click', function(){
    $(step3NextBtn).prop('disabled', false);

  });
});
//Open Step 1 Page
$(function(){
    $(".open-step-1").click(function() {
      if($('input[name=ownerType]:checked').val() == '') {
        $(step1NextBtn).prop('disabled',true);
      } else {
        $(step1NextBtn).prop('disabled', false);
          $(".form").hide("fast");
          $("#step-1").show("slow");
      }
    });
});
//Open Step 2 Page
$(function() {
    $(".open-step-2").click(function() {
        $(".form").hide("fast");
        $("#step-2").show("slow");
   });
});
//Open Step 3 Page
$(function(){
    $(".open-step-3").click(function() {
        $(".form").hide("fast");
        $("#step-3").show("slow");
    });
});
//open step 4
$(function(){
    $(".open-step-4").click(function() {
      $("#registerButton").prop('disabled', false);
        $(".form").hide("fast");
        $("#step-4").show("slow");
    });
});
//reset Register Form
$(function(){
  $("#resetButton, .close").on('click', function(){
      $("#registerForm")[0].reset();
      $(step1NextBtn).prop('disabled', true);
      $(step2NextBtn).prop('disabled', true);
      $(step3NextBtn).prop('disabled', true);
      $("#registerButton").prop('disabled', true);
      alert("form cleared");
      $(".form").hide('fast');
      $("#step-1").show('slow');
  });
});


//FORGOT PASSWORD
// var searchButton = document.getElementById('searchButton');
// var forgetPassButton = document.getElementById('forgotPassButton');
// var forgotPassForm = document.getElementById('forgotPassForm');
//
//
// forgotPassForm.addEventListener('submit' , function (e) {
//   var forgotPassEmail = $("#forgotPassEmail").val();
//   alert('email' + forgotPassEmail);
//   // alert("password email resent");
//   // e.preventDefault();
//   // if(forgotPassEmail == '') {
//   //   alert("Missing Email");
//   //   e.preventDefault();
//   // } else {
//   //     alert("filled in information");
//   //     document.location = './index.html';
//   // }
//   if(forgotPassEmail == '') {
//     alert("Missing information");
//     e.preventDefault();
//   } else {
//       // var correctInfo = validateLogin(loginEmail, loginPass);
//       // if(!correctInfo){
//         alert('incorrect information');
//         e.preventDefault();
//       }else {
//         alert("correct information");
//         document.location = './search.html';
//       }
//   }
// }, false);


//
// $("#se").click(function(){
//   alert("asdasdsadasd");
//     $.ajax({url: "https://google.com", success: function(result){
//         $("#displayContent").html(result);
//     }});
// });
// });
// function searching(){
//   alert("searching");
//   // var xhttp = new XMLHttpRequest();
//   // xhttp.open('GET', 'search.html', true);
//   // alert("1");
//   // xhttp.onreadystatechange = function() {
//   //   alert("2");
//   //   //it stops working here
//   //   if (this.readyState == 4 && this.status == 200) {
//   //     alert('3');
//   //    document.getElementById("displayContent").innerHTML = this.responseText;
//   //   }
//   // };
//   // xhttp.send();
// }

//Dashboard script to toggle the boxes for the checkboxes in the search.html page
$(function () {
  $(".dashComp").on("click", function(){
    $checkbox = $(this).attr('id');
    $("#" + $checkbox + "Dash").toggle();
  });
});

//toggles the list of the categories on the search.html page
$(function () {
    $(".catDrop").click(function(){
      var $dropdown = $(this).attr('id');
      // $("#" + $dropdown + 'space').collapse('toggle');
      $("i", this).toggleClass("fa-chevron-up fa-chevron-down");
    });
});


















/*--------------------------INDEX-----------------------------*/

//changes the navbar when scrolling
$(function(){
  $(window).scroll(function(){
    if($(this).scrollTop() > 20) {
      $('#index-navbar').addClass('bg-color border-bottom shadow-sm ');
      // $("#index-navbar").
      // $('#index-navbar .navbar-nav .nav-item a').css('color', 'black');
    } else {
      $('#index-navbar').removeClass('bg-color');
      // $('#index-navbar .navbar-nav .nav-item a').css('color', 'white');
    }
  });
});

/* -------------------------DASHBOARD -----------------------*/

//Sidebar
$(function(){
  $('#sidebarCollapse').on('click', function () {
      $('#sidebar').toggleClass('active');
      $("#sidebar-header").toggle();
  });
});

//Account Tabs
$(function(){
  $("#editPerButton").click(function(){
     $("#editPersonalForm input").prop("disabled", false);
   });
});
$(function(){
   $("#savePerButton").click(function(){
     alert("Saving....");
     $("#editPersonalForm input").prop("disabled", true);
   });
});
$(function(){
  $('#editCCButton').click(function(){
      // alert("Editing CC Information");
    $("#editFinancialForm input").prop("disabled", false);

  });
});
$(function(){
  $('#saveCCButton').click(function(){
    alert("Saving CC Information");
    $("#editFinancialForm input").prop("disabled", true);

  });
});
$(function(){
  $("#editConButton").click(function(){
     $("#editContactForm input").prop("disabled", false);
   });
});
$(function(){
   $("#saveConButton").click(function(){
     alert("Saving....");
     $("#editContactForm input").prop("disabled", true);
   });
});

  /*----------------------------RESULTS-----------------------------*/



  /*------------------WEB SERVICE CALLS-----------------------------*/


function validateCredentials(username, password){

  var httpRequest = new XMLHttpRequest();
  httpRequest.open('POST', 'http://localhost:5000/login/credentials/?email='+username+"&&"+"/password="+password,true);
  httpRequest.setRequestHeader('Content-Type', 'application/json');
  httpRequest.onreadystatechange = function(){
    if(this.readyState!==4) return;
    if(this.status!=200)return;
    //error logging TODO: Display error to UI for user to see
    // document.getElementById('modalContent').innerHTML = this.responseText;
  };
  return httpRequest.responseText;

}
