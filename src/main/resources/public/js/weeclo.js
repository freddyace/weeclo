console.log("WeeClo Page Opens");
var serverAddress = 'localhost';
var user, pass;
var body = document.getElementById('body');

// var theUser = {"firstname":null, "lastname":null, "email_address":null, "address1":null, "address2":null,
//   "zip":null, "systemName":null, "password":null, "neighborhood":null, "phone":null, "dateJoined":null,
//   "dateOfBirth":null, "status":null,"city":null};
//
// var stubUser = {zip:30303,lastName:'user',profilePictureName:"Bootyhole",
//   address2:"NULL",city:"Buckhead",address1:"1 Elm Street",stateId:"GA",
//   dateJoined:"2018-08-23",dateOfBirth:"2018-08-23",firstName:"super",
//   password:"wc",emailAddress:"su",systemName:"superuser",phone:"2302565676",
//   id:1235,neighborhood:1,status:"Active",profilePicturePath:"undefined"};


function insertHTMLFile(directory, id) {
  var xhr= new XMLHttpRequest();
  xhr.open('GET', directory, true);
  xhr.onreadystatechange= function() {
    if (this.readyState!==4) return;
    if (this.status!==200) return; // or whatever error handling you want
    document.getElementById(id).innerHTML= this.responseText;
  };
  xhr.send();
}
/*--------------------------------------------------
*                     Index
*--------------------------------------------------*/

//LOGIN USER VALIDATION
function userLogin() {
  var loginEmail = $('#loginEmail').val();var loginPass = $('#loginPass').val();
  if(loginEmail == '' || loginPass == '') {
    alert('Missing information. Try again.');
    return;
  } else {
      var httpRequest = new XMLHttpRequest();
      httpRequest.onreadystatechange = function () { //called after the send as a call back
        console.log('Entering callback');
        if(this.readyState!==4) return;
        if(this.status!==200) {
          console.log('Incorrect Credentials.');
          alert("Incorrect Credentials.");
          $("#loginForm")[0].reset();
          return;
        } else {
          insertHTMLFile('dashboard.html', 'body');
          console.log('validation successful');
          console.log(this.responseText);
          return;
        }
      };
      httpRequest.open('GET', "http://"+serverAddress+":5000/login/credentials/?email="+loginEmail +"&password="+ loginPass, true);
      httpRequest.setRequestHeader('Content-Type','application/json');
      httpRequest.send();
      console.log("Endpoint Hit: "+"http://"+serverAddress+":5000/login/credentials/?email="+loginEmail+"&password="+loginPass);
  }
}

//resets login form when close modal
$(function(){
  $("#login-modal").on('hidden.bs.modal', function(){
    $("#loginForm")[0].reset();
  });
});
//REGISTER USER INFORMATION
$(".step-1").show();$(".step-2, .step-3, .step-4").hide();
var step1NextBtn = $("#step1Next").prop('disabled', true);
var step2NextBtn = $("#step2Next").prop('disabled', true);
var registerButton = $("#registerButton").prop('disabled', true);
var regFirst = '',regLast = '', regPhone = '',regBirthday = '';
var regAddress = '', regNeighborhood = '', regZip = '';
var regEmail = '',regUsername = '',regPassword = '', regPassword2 = '';
//checks register first section validity
function checkRegFirst(){
  regFirst = $('#regFirst').val();regLast = $('#regLast').val();
  regPhone = $('#regPhone').val(); regBirthday = $('#regBirthday').val();
  if(regFirst == '' || regLast == '' || regPhone == '' || regBirthday == '') {
    console.log("Something is missing");
    $(step1NextBtn).prop('disabled', true);
  } else {
    var firstIsValid = validateRegFirst(regFirst, regLast, regPhone, regBirthday);
    if(!firstIsValid) {
      $(step1NextBtn).prop('disabled', true);
      console.log('incorrect information');
    } else {
      console.log('correct information. Going to step 2');
      $(step1NextBtn).prop('disabled', false);
    }
  }
}
function validateRegFirst(fname, lname, phone, birthday) {
  //here is where the validation of the form happens
  // var lettersOnly = /^[a-zA-Z]+$/;
  // // var numbersOnly = /[0-9+]+$/;
  // // var firstCheck = false;
  // if(!fname.match(lettersOnly)) {
  //   console.log("Incorrect First Name");
  //   return false;
  // }
  // if(!lname.match(lettersOnly)) {
  //   console.log("Incorrect Last Name");
  //   return false;
  // }
  // if(phone.match(numbersOnly)) {
  //   console.log("Incorrect Phone Number");
  //   return false;
  // }
  // return true;

  if(fname != '' && lname != '' && phone != '' && birthday != '') {
    return true;
  } else {
    return false;
  }
}
function checkRegSecond(){
  regAddress = $('#regAddress').val();regNeighborhood = $('#regNeighborhood').val();regZip = $('#regZip').val();
  if(regAddress == '' || regNeighborhood == '' || regZip == '') {
    $(step2NextBtn).prop('disabled', true);
  } else {
    var secondIsValid = validateRegSecond(regAddress, regNeighborhood, regZip);
    if(!secondIsValid) {
      console.log('incorrect info');
    } else {
      console.log('correct information. Going to step 3');
      $(step2NextBtn).prop('disabled', false);
    }
  }
}
function validateRegSecond(address, neighborhood, zip) {
  if(address != '' && neighborhood != '' && zip != '') {
    return true;
  } else {
    return false;
  }
}
function checkRegFinal(){
  regEmail = $('#regEmail').val();regUsername = $("#regUsername").val();
  regPassword = $('#regPassword').val();regPassword2 = $('#regPassword2').val();
  if(regEmail == '' || regUsername == '' || regPassword == '' || regPassword2 == '') {
    $(registerButton).prop('disabled', true);
  } else {
    var finalIsValid = validateRegFinal(regEmail, regUsername, regPassword, regPassword2);
    if(!finalIsValid) {
      console.log('incorrect information');
    } else {
      console.log('correct info. Completed form!');
      $(registerButton).prop('disabled', false);
    }
  }
}
function validateRegFinal(email, username, password, password2) {
  if(email != '' && username != '' && password != '' && password2 != '') {
    return true;
  } else {
    return false;
  }
}
/*
* var theUser = {"firstname":null, "lastname":null,
* "email_address":null, "address1":null, "address2":null,
  "zip":null, "systemName":null, "password":null,
  "neighborhood":null, "phone":null, "dateJoined":null,
  "dateOfBirth":null, "status":null,"city":null};

var stubUser = {zip:30303,lastName:'user',
profilePictureName:"Bootyhole",
  address2:"NULL",city:"Buckhead",
  address1:"1 Elm Street",stateId:"GA",
  dateJoined:"2018-08-23",dateOfBirth:"2018-08-23",
  firstName:"super",
  password:"wc",emailAddress:"su",
  systemName:"superuser",phone:"2302565676",
  id:1235,neighborhood:1,status:"Active",profilePicturePath:"undefined"};

*/
var defaultUser = {zip:30303,lastName:'user',
  profilePictureName:"Bootyhole",
  address2:"NULL",city:"Buckhead",
  address1:"1 Elm Street",stateId:"GA",
  dateJoined:"2018-08-23",dateOfBirth:"2018-08-23",
  firstName:"super",
  password:"wc",emailAddress:"su",
  systemName:"superuser",phone:"2302565676",
  id:1234567,neighborhood:1,status:"Active",profilePicturePath:"undefined"};
//Gathers all the information from the form and submit the the DB as new user
function userRegister() {
  console.log("user is registering");
  defaultUser.firstName = regFirst;defaultUser.lastName = regLast; defaultUser.phone = regPhone;
  defaultUser.address1 = regAddress; defaultUser.emailAddress = regEmail; defaultUser.password = regPassword;
  defaultUser.zip = regZip;

  console.log(defaultUser.firstName+" "+defaultUser.lastName+" "+defaultUser.phone);
  console.log(defaultUser.address1+" "+defaultUser.zip+" "+defaultUser.emailAddress+" "+defaultUser.password);


  var newUser = JSON.stringify(defaultUser);
  console.log(newUser);
  console.log("First: " + regFirst + '\nLast: '+ regLast + '\nPhone: ' + regPhone +
    'Birthday: ' + regBirthday + "\nAddress: " + regAddress + '\nNeighborhood: ' +
    regNeighborhood + '\nZip: ' + regZip + '\nEmail: ' + regEmail + '\nUsername: ' +
    regUsername + '\nPassword: ' + regPassword + '\nPassword Confirm: ' + regPassword2);

  var httpRequest = new XMLHttpRequest();
  httpRequest.open('POST', "http://"+serverAddress+":5000/createWeeCloUser",true);
  httpRequest.setRequestHeader('Content-Type', 'application/json');
  httpRequest.setRequestHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
  httpRequest.onreadystatechange = function(){
    console.log("Entering register callback");
    if(this.readyState!==4) return;
    if(this.status!==200) {
      console.log(this.responseText);
      alert("Something is wrong registering the user. Please try again.");
      return;
    } else {
      setTimeout(function(){insertHTMLFile('dashboard.html', 'body'); }, 3000);
      // insertHTMLFile('dashboard.html', 'body');
      console.log('registration was successful');
      return;
    }
  };
  httpRequest.send(newUser);

  // alert("REGISTRATION SUCCESSFUL!");
}

/*
* //replicate this garbage
 function persist(toBecomeUser){
   console.log("Attempting to persist user with info as:"+toBecomeUser);
   var newUser = JSON.stringify(toBecomeUser)
   var httpRequest = new XMLHttpRequest();
   httpRequest.open('POST', "http://"+serverAddress+":5000/createWeeCloUser",true);
   httpRequest.setRequestHeader('Content-Type', 'application/json');
   httpRequest.setRequestHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
   httpRequest.onreadystatechange = function(){
     if(this.readyState!==4) return;
     if(this.status!=200){
       document.getElementById('body').innerText = this.responseText;
       setTimeout(function(){insertHtml('adminDashboard.html', 'body'); }, 3000);
       return;
     }
     //error logging
     document.getElementById('body').innerHTML = this.responseText;
     setTimeout(function(){insertHtml('adminDashboard.html', 'body'); }, 3000);

   };
   httpRequest.send(newUser);

 }
 */
$(function(){
  $(".open-step-1").click(function() {
    $(".form").hide("fast");
    $(".step-1").show("slow");
  });
});
//Open Step 2 Page
$(function() {
  $(".open-step-2").click(function() {
    $(".form").hide("fast");
    $(".step-2").show("slow");
  });
});
//Open Step 3 Page
$(function(){
  $(".open-step-3").click(function() {
    $(".form").hide("fast");
    $(".step-3").show("slow");
  });
});
//open step 4
$(function(){
  $(".open-step-4").click(function() {
    $(".form").hide("fast");
    $(".step-4").show("slow");
  });
});

$(function(){
  $('#register-modal').on('hidden.bs.modal', function(){
    $(step1NextBtn, step2NextBtn).prop('disabled', true);
    $("#registerButton").prop('disabled', true);
    $("#registerForm")[0].reset();
    $(".form").hide('fast');
    $(".step-1").show('slow');
  });
});


//reset Register Form
$(function(){
  $("#resetButton, .close").on('click', function(){
    $("#registerForm")[0].reset();
    $(step1NextBtn).prop('disabled', true);
    $(step2NextBtn).prop('disabled', true);
    $("#registerButton").prop('disabled', true);
    alert("form cleared");
    $(".form").hide('fast');
    $(".step-1").show('slow');
  });
});

