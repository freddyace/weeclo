
// When the user scrolls the page, execute myFunction
window.onscroll = function() {myFunction()};
// Get the navbar
var navbar = document.getElementById("gifSearch");
// Get the offset position of the navbar
var sticky = navbar.offsetTop;

//User form information:

var User={"firstname":null,
    "lastname":null,
    "email_address":null,
    "address1":null,
    "address2":null,
    "zip":null,
    "systemName":null,
    "password":null,
    "neighborhood":null,
    "phone":null,
    "dateJoined":null,
    "dateOfBirth":null,
    "status":null,
    "city":null
};

// Add the sticky class to the navbar when you reach its scroll position. Remove "sticky" when you leave the scroll position

//This function keeps the serch bar from the landing page available when scrolling....
function myFunction() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}

//forgot what this does...
$(window).bind('scroll', function() {
     if ($(window).scrollTop() > 1000) {
         $('#navbar').show();
     }
     else {
         $('#navbar').hide();
     }
});
          $(document).ready(function () {
            $("#navbar").hide();    // just add this

        });


// for every slide in carousel, copy the next slide's item in the slide.
// Do the same for the next, next item.
function slide() {

}



$(document).ready(function () {
    var itemsMainDiv = ('.MultiCarousel');
    var itemsDiv = ('.MultiCarousel-inner');
    var itemWidth = "";

    $('.leftLst, .rightLst').click(function () {
        var condition = $(this).hasClass("leftLst");
        if (condition)
            click(0, this);
        else
            click(1, this)
    });

    ResCarouselSize();




    $(window).resize(function () {
        ResCarouselSize();
    });

    //this function define the size of the items
    function ResCarouselSize() {
        var incno = 0;
        var dataItems = ("data-items");
        var itemClass = ('.item');
        var id = 0;
        var btnParentSb = '';
        var itemsSplit = '';
        var sampwidth = $(itemsMainDiv).width();
        var bodyWidth = $('body').width();
        $(itemsDiv).each(function () {
            id = id + 1;
            var itemNumbers = $(this).find(itemClass).length;
            btnParentSb = $(this).parent().attr(dataItems);
            itemsSplit = btnParentSb.split(',');
            $(this).parent().attr("id", "MultiCarousel" + id);


            if (bodyWidth >= 1200) {
                incno = itemsSplit[3];
                itemWidth = sampwidth / incno;
            }
            else if (bodyWidth >= 992) {
                incno = itemsSplit[2];
                itemWidth = sampwidth / incno;
            }
            else if (bodyWidth >= 768) {
                incno = itemsSplit[1];
                itemWidth = sampwidth / incno;
            }
            else {
                incno = itemsSplit[0];
                itemWidth = sampwidth / incno;
            }
            $(this).css({ 'transform': 'translateX(0px)', 'width': itemWidth * itemNumbers });
            $(this).find(itemClass).each(function () {
                $(this).outerWidth(itemWidth);
            });

            $(".leftLst").addClass("over");
            $(".rightLst").removeClass("over");

        });
    }


    //this function used to move the items
    function ResCarousel(e, el, s) {
        var leftBtn = ('.leftLst');
        var rightBtn = ('.rightLst');
        var translateXval = '';
        var divStyle = $(el + ' ' + itemsDiv).css('transform');
        var values = divStyle.match(/-?[\d\.]+/g);
        var xds = Math.abs(values[4]);
        if (e == 0) {
            translateXval = parseInt(xds) - parseInt(itemWidth * s);
            $(el + ' ' + rightBtn).removeClass("over");

            if (translateXval <= itemWidth / 2) {
                translateXval = 0;
                $(el + ' ' + leftBtn).addClass("over");
            }
        }
        else if (e == 1) {
            var itemsCondition = $(el).find(itemsDiv).width() - $(el).width();
            translateXval = parseInt(xds) + parseInt(itemWidth * s);
            $(el + ' ' + leftBtn).removeClass("over");

            if (translateXval >= itemsCondition - itemWidth / 2) {
                translateXval = itemsCondition;
                $(el + ' ' + rightBtn).addClass("over");
            }
        }
        $(el + ' ' + itemsDiv).css('transform', 'translateX(' + -translateXval + 'px)');
    }

    //It is used to get some elements from btn
    function click(ell, ee) {
        var Parent = "#" + $(ee).parent().attr("id");
        var slide = $(Parent).attr("data-slide");
        ResCarousel(ell, Parent, slide);
    }

});


//MODAL
var loginButton = document.getElementById("landingPageLoginButton");
var joinWeecloButton = document.getElementById("joinWeecloButton");
var modalNextButton = document.getElementById("innerButton");
var video = document.getElementById("myVideo");
var modalBackButton = document.getElementById("modalBackButton");
var modal = document.getElementById('myModal');
var loginModal = document.getElementById('loginModal');
var signUpButton = document.getElementById("myBtn");
var span = document.getElementsByClassName("close")[0];
var loginLink = document.getElementById("loginLink");
var modalCloseButton = document.getElementById("modalCloseButton");
var mainModalCloseButton = document.getElementById("mainModalCloseButton");

var loginModalContent = "<center><h1>Welcome back!</h1></center><center><form action='/action_page.php'><input id='email' type='email' name='email' placeholder='Email' style='width:300px'><br><input id='password' type='password' name='password' placeholder='Password' style='width:300px'><br><br><br><br><center><a class='button' id='loginEventButton' >Let's Go!</a></center></form></center>";

mainModalCloseButton.onclick=function(){
  modal.style.display="none";
  console.log("clicked the span for main modal");
}

modalCloseButton.onclick=function(){
      loginModal.style.display = "none";
        console.log("clicked the span for login modal");

}

loginLink.onclick = function(){
     $(window).scrollTop(0);
  loginModal.style.display = "block";
  document.getElementById("loginModalContent").innerHTML = loginModalContent;
}

// When the user clicks the button, open the modal
loginButton.onclick = function(){
  loginModal.style.display = "block";
  document.getElementById("loginModalContent").innerHTML = loginModalContent;

}


joinWeecloButton.onclick = function() {

    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:3001/listOfAllUsers");
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    console.log("Response string is: "+'\n');

    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log(xhttp.responseText);
            var jsonObject = xhttp.responseText;
            var userEmail = JSON.parse(jsonObject)
            console.log(userEmail.users[0].user_email);
        }
    }

}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

console.log("Step State:"+stepState)
var stepState;
var innerButtonClickCount = 0;

function onClickNext(){
    modal.style.display = "block";

    console.log("innerButtonClickCount: "+innerButtonClickCount)
      if (innerButtonClickCount == 0 || stepState == 0){
          stepState = 1;
          innerButtonClickCount++
          console.log("Step State: "+stepState)
      // document.getElementById("modalContent").innerHTML = userTypeForm;
      var xhr = new XMLHttpRequest();
      xhr.open('GET', 'userType.html', true);
      xhr.onreadystatechange = function () {
          if (this.readyState !== 4) return;
          if (this.status !== 200) return; // or whatever error handling you want
          document.getElementById('modalContent').innerHTML = this.responseText;
      };
      xhr.send();
  }


else if(innerButtonClickCount==1||stepState==1){
  console.log("Click Count: "+innerButtonClickCount);
  console.log("Step State: "+stepState)

    var xhr= new XMLHttpRequest();
    xhr.open('GET', 'modalForm.html', true);
    xhr.onreadystatechange= function() {
        if (this.readyState!==4) return;
        if (this.status!==200) return; // or whatever error handling you want
        document.getElementById('modalContent').innerHTML= this.responseText;
    };
    xhr.send();
          stepState++;
          innerButtonClickCount++;
}
else if(innerButtonClickCount==2||stepState==2){
console.log("Click Count: "+innerButtonClickCount);
console.log("Step State: "+stepState)

    var xhr= new XMLHttpRequest();
    xhr.open('GET', 'categoryTable.html', true);
    xhr.onreadystatechange= function() {
        if (this.readyState!==4) return;
        if (this.status!==200) return; // or whatever error handling you want
        document.getElementById('modalContent').innerHTML= this.responseText;
    };
    xhr.send();
          stepState++;
          innerButtonClickCount++;

}
else if(innerButtonClickCount==3||stepState==3){
console.log("Click Count: "+innerButtonClickCount);
console.log("Step State: "+stepState)

    var xhr= new XMLHttpRequest();
    xhr.open('GET', 'neighborhoodTable.html', true);
    xhr.onreadystatechange= function() {
        if (this.readyState!==4) return;
        if (this.status!==200) return; // or whatever error handling you want
        document.getElementById('modalContent').innerHTML= this.responseText;
    };
    xhr.send();
          stepState++;
          innerButtonClickCount++;
    console.log("Click Count is now: "+innerButtonClickCount)
}
}

function restartModal(){
    console.clear();
  console.log("restartModal clicked");
  console.log("Step State: "+stepState)
  innerButtonClickCount = 0;
  stepState=0;
  console.log("click count: "+innerButtonClickCount);

    onClickNext();
}


function isRenter(){
    document.getElementById('renterCardID').style.backgroundColor = "#90EE90";
    document.getElementById('ownerCardID').style.backgroundColor = "white";
    console.log("User-type selection: Renter");
    serializeUserType("renter");

}
function isOwner(){
    document.getElementById('ownerCardID').style.backgroundColor = "#90EE90";
    document.getElementById('renterCardID').style.backgroundColor = "white";
    console.log("User-type selection: Owner");
    serializeUserType("owner");
}


function populateForm(){
    console.log("****************************");
    var firstnameValue = document.getElementById('firstname').value;
    console.log("first name: "+firstnameValue);
    var lastnameValue = document.getElementById('lastname').value;
    console.log("last name: "+lastnameValue);
    var emailValue = document.getElementById('email').value;
    console.log("email: "+emailValue);
    var addressLine1Value = document.getElementById('addressLine1').value;
    console.log("Address (line 1): "+addressLine1Value);
    var addressLine2Value = document.getElementById('addressLine2').value;
    console.log("Address (line 2): "+addressLine2Value);
    var zipcodeValue = document.getElementById('zipcode').value;
    console.log("Zip: "+zipcodeValue);
    var desiredUsernameValue = document.getElementById('desiredUsername').value;
    console.log("Desired Username: "+desiredUsernameValue);
    var intendedPasswordValue = document.getElementById('password').value;
    console.log("Password Entered: "+intendedPasswordValue);
    var intendedPasswordConfirmationValue = document.getElementById('passwordConfirmation').value;
    console.log("Password Confirmation: "+intendedPasswordConfirmationValue);

    User.firstname=firstnameValue;
    User.lastname=lastnameValue;
    User.email=emailValue;
    User.address1=addressLine1Value;
    User.address2=addressLine2Value;
    User.zip=zipcodeValue;
    User.systemName=desiredUsernameValue;
    User.password=intendedPasswordValue;
    User.city="random";
    User.dateJoined = Date.now();
    User.dateOfBirth=Date.now();
    User.status = "active";
    validateModalForm(firstnameValue,lastnameValue,emailValue,addressLine1Value,zipcodeValue,desiredUsernameValue, intendedPasswordValue,intendedPasswordConfirmationValue);

}

function serializeUserType(userType){
    console.log("****************************");
    console.log("Saving user type....");
    //User.type=userType;
}
function validateUserTypeSelection(){

}
function validateModalForm(firstnameValue,lastnameValue,emailValue,addressLine1Value,zipcodeValue,desiredUsernameValue, intendedPasswordValue,intendedPasswordConfirmationValue){
    var missedFieldsArray = [];
    if(firstnameValue.length==0||lastnameValue.length==0||
        emailValue.length==0||addressLine1Value.length==0||
        zipcodeValue.length==0||desiredUsernameValue.length==0||
        intendedPasswordValue.length==0||intendedPasswordConfirmationValue.length==0 ){
        //redo form by re-routing user back to step 2
        if(firstnameValue.length==0){
            missedFieldsArray.push(" First Name");
        }
        if(lastnameValue.length==0){
            missedFieldsArray.push(" Last Name");
        }
        if(emailValue.length==0){
            missedFieldsArray.push(" Email");
        }
        if(addressLine1Value.length==0){
            missedFieldsArray.push(" Address");
        }
        if(zipcodeValue.length==0){
            missedFieldsArray.push(" Zip");
        }
        if(desiredUsernameValue.length==0){
            missedFieldsArray.push(" Desired Username");
        }
        if(intendedPasswordValue.length==0){
            missedFieldsArray.push(" Password");
        }
        if(intendedPasswordConfirmationValue.length==null){
            missedFieldsArray.push(" Password Confirmation");
        }
        console.log(emailValue.value)
        console.error("Must enter necessary fields...");
        document.getElementById('ErrorMessage').innerHTML="Oops, looks like you forgot these things: "+"<p id='errorContent'>"+missedFieldsArray.toString()+"</p>";
    }
    else if(intendedPasswordValue.valueOf()!=intendedPasswordConfirmationValue.valueOf()){
        console.error("Passwords entered do not match...");
        document.getElementById('ErrorMessage').innerHTML="<p id='errorContent'> Passwords entered do not match...</p>";
    }
    else{
        console.log("Necessary fields entered successfully...");
        onClickNext();

    }
}

function completeSignUp() {
    var radios = document.getElementsByName('radio');

    for (var i = 0, length = radios.length; i < length; i++)
    {
        if (radios[i].checked)
        {
            User.neighborhood=radios[i].value;

            break;
        }
    }
    console.log("Neighborhood Selected: "+User.neighborhood);

    var xhr= new XMLHttpRequest();
    xhr.open('GET', 'loadingPage.html', true);
    xhr.onreadystatechange= function() {
        if (this.readyState!==4) return;
        if (this.status!==200) return; // or whatever error handling you want
        document.getElementById('modalContent').innerHTML= this.responseText;
    };
    xhr.send();
    stepState++;
    innerButtonClickCount++;
    console.log("Click Count is now: "+innerButtonClickCount);

    console.log("Final User JS object: "+JSON.stringify(User));

    persist(User);

    setTimeout(function(){

        var xhr= new XMLHttpRequest();
        xhr.open('GET', 'signupComplete.html', true);
        xhr.onreadystatechange= function() {
            if (this.readyState!==4) return;
            if (this.status!==200) return; // or whatever error handling you want
            document.getElementById('modalContent').innerHTML= this.responseText;
        };
        xhr.send();
        stepState++;
        innerButtonClickCount++;
        console.log("Click Count is now: "+innerButtonClickCount)



    }, 3000);
}
function persist(user){

    var httpRequest = new XMLHttpRequest();
    httpRequest.open('POST', 'http://localhost:3001/createWeeCloUser',true);
    httpRequest.setRequestHeader('Content-Type', 'application/json');
    httpRequest.onreadystatechange = function(){
        if(this.readyState!==4) return;
        if(this.status!=200)return;
        //error logging
        document.getElementById('modalContent').innerHTML = this.responseText;
    };
    httpRequest.send(user);

}

function validateUserLogin(){
    var userEmail = document.getElementById();
    var password = document.getElementById();
    if(userEmail(userEmail)){

    }

}
function login(){

}
function userExists(userEmail){
    var exists = false;
    var httpRequest = new XMLHttpRequest();
    httpRequest.open('POST', 'http://localhost:3001/userEmailExists', true);
    httpRequest.setRequestHeader('Content-Type', 'application/json');
    httpRequest.onreadystatechange = function () {
        if(this.readyState!=4)return;
        if(this.status!=200){
            //error logging
            return "Exception occured"
        }
        else{
            httpRequest.send(userEmail)
            if(httpRequest.status!='200'){
                //handle this
                return false;
            }else{
                return true;
            }
        }
    }
}


//END OF MODAL
