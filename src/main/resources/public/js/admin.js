 /* The javascript to handle admin operations
 *
 * By: Freddy Acevedo @ WeeClo
 * Sep 23, 2018
 * */

 //Global variable used to dodge CORS issue
 // var serverAddress = "35.237.231.31";
 var serverAddress = "localhost";
 //TODO: Fix this, figure out a smoother deployment mechanism/method

 var user= document.getElementById("usernameForAdmin");
 var pass = document.getElementById("passwordForAdmin");
 var requestBodyObject = {username:user, password:pass}
 var requestBodyJson = JSON.stringify(requestBodyObject)
 // httpRequest(requestBodyJson, "", "POST")


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

 // var stubUser = {"zip":30303,"lastName":"user","profilePictureName":"Bootyhole","address2":"NULL","city":"Buckhead","address1":"1 Elm Street","stateId":"GA","dateJoined":"2018-08-23","dateOfBirth":"2018-08-23","firstName":"super","password":"wc","emailAddress":"su","systemName":"superuser","phone":"2302565676","id":1235,"neighborhood":1,"status":"Active","profilePicturePath":"undefined"}
 var stubUser = {zip:30303,lastName:'user',profilePictureName:"Bootyhole",address2:"NULL",city:"Buckhead",address1:"1 Elm Street",stateId:"GA",dateJoined:"2018-08-23",dateOfBirth:"2018-08-23",firstName:"super",password:"wc",emailAddress:"su",systemName:"superuser",phone:"2302565676",id:1235,neighborhood:1,status:"Active",profilePicturePath:"undefined"};

 function adminLogin() {
   userExists(user, pass)

 }
 // function httpRequest(requestBody, endpoint, requestMethod) {
 //   var httpRequest = new XMLHttpRequest();
 //   httpRequest.open(requestMethod, endpoint, true);
 //   httpRequest.setRequestHeader('Content-Type', 'application/json');
 //   httpRequest.onreadystatechange = function () {
 //     if(this.readyState!=4)return;
 //     if(this.status!=200){
 //       //error logging
 //       return "Exception occured"
 //     }
 //     else{
 //       httpRequest.send(requestBody)
 //     }
 //   }
 // }


 function userExists(userEmail, password){
   console.log("User email: "+userEmail.value);
   console.log(("User password: "+password.value));
   var httpRequest = new XMLHttpRequest();
   // httpRequest.open('GET', "http://localhost:5000/login/credentials/?email="+userEmail.value+"&password="+password.value, true);
   httpRequest.onreadystatechange = function () {
     if(this.readyState==4 && this.status==200) {
       insertHtml('adminDashboard.html', 'body');
       console.log("Entering callback")
       console.log(httpRequest.responseText)
       console.log("Validation Successful")


     }
   };
   httpRequest.open('GET', "http://"+serverAddress+":5000/login/credentials/?email="+userEmail.value+"&password="+password.value, true);
   httpRequest.setRequestHeader('Content-Type', 'application/json');
   httpRequest.send();
   console.log("Endpoint Hit: "+"http://"+serverAddress+":5000/login/credentials/?email="+userEmail.value+"&password="+password.value)
 }

//Using GET to insert HTML into a page
 var body = document.getElementById("body")

 function insertHtml(directory, id) {
   var xhr= new XMLHttpRequest();
   xhr.open('GET', directory, true);
   xhr.onreadystatechange= function() {
     if (this.readyState!==4) return;
     if (this.status!==200) return; // or whatever error handling you want
     document.getElementById(id).innerHTML= this.responseText;
   };
   xhr.send();
 }

 function openNav() {
   document.getElementById("mySidenav").style.width = "250px";
 }

 function closeNav() {
   document.getElementById("mySidenav").style.width = "0";
 }

 /*Create User functionality: Hits Endpoint by passing object created from UI form data*/
/* Binds the data passed from user to JS object, then eventually, JSON value */
 function populateFormAndPersist(){
   console.log("****************************");
   var firstnameValue = document.getElementById('firstname').value;
   console.log("first name: "+firstnameValue);
   var lastnameValue = document.getElementById('lastname').value;
   console.log("last name: "+lastnameValue);
   var emailValue = document.getElementById('emailAddress').value;
   console.log("email: "+emailValue);
   var addressLine1Value = document.getElementById('addressLine1').value;
   console.log("Address (line 1): "+addressLine1Value);
   var addressLine2Value = document.getElementById('addressLine2').value;
   console.log("Address (line 2): "+addressLine2Value);
   var zipcodeValue = document.getElementById('zipcode').value;
   console.log("Zip: "+zipcodeValue);
   var desiredUsernameValue = document.getElementById('username').value;
   console.log("Desired Username: "+desiredUsernameValue);
   var intendedPasswordValue = document.getElementById('password').value;
   console.log("Password Entered: "+intendedPasswordValue);
   var intendedPasswordConfirmationValue = document.getElementById('passwordConfirmation').value;
   console.log("Password Confirmation: "+intendedPasswordConfirmationValue);
   var uniqueIDValue = document.getElementById("uniqueID").value;
   console.log("Unique ID value entered: "+ uniqueIDValue);


   User.firstname=firstnameValue; stubUser.firstName=firstnameValue;
   User.lastname=lastnameValue; stubUser.lastName = lastnameValue;
   User.email=emailValue; stubUser.emailAddress = emailValue;
   User.address1=addressLine1Value; stubUser.address1 = addressLine1Value;
   User.address2=addressLine2Value; stubUser.address1 = addressLine2Value;
   User.zip=zipcodeValue; stubUser.zip = zipcodeValue;
   User.systemName=desiredUsernameValue; stubUser.systemName = desiredUsernameValue;
   User.password=intendedPasswordValue; stubUser.password = intendedPasswordValue;
   User.city="Atlanta"; stubUser.city = "Atlanta";
   User.dateJoined = Date.now();
   User.dateOfBirth=Date.now();
   User.status = "Active";
   User.neighborhood=4
   stubUser.id = uniqueIDValue;
   validateModalForm(firstnameValue,lastnameValue,emailValue,addressLine1Value,zipcodeValue,desiredUsernameValue, intendedPasswordValue,intendedPasswordConfirmationValue, uniqueIDValue);

 }
/* Validates the data from the modal */
 function validateModalForm(firstnameValue,lastnameValue,emailValue,addressLine1Value,
                            zipcodeValue,desiredUsernameValue, intendedPasswordValue,
                            intendedPasswordConfirmationValue, idValue){
   var missedFieldsArray = [];
   if(firstnameValue.length==0||lastnameValue.length==0||
     emailValue.length==0||addressLine1Value.length==0||
     zipcodeValue.length==0||desiredUsernameValue.length==0||
     intendedPasswordValue.length==0||intendedPasswordConfirmationValue.length==0||idValue.length==0){
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
     if(idValue.length==0){
       missedFieldsArray.push(" Unique ID")
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
     persist(stubUser);

   }
 }

 function persist(toBecomeUser){
   console.log("Attempting to persits user with info as:"+toBecomeUser);
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

 function persistStubUser() {
   var jsonUser = JSON.stringify(stubUser)
   var httpRequest = new XMLHttpRequest();
   httpRequest.open('POST', "http://"+serverAddress+":5000/createWeeCloUser",true);
   httpRequest.setRequestHeader('Content-Type', 'application/json');
   httpRequest.onreadystatechange = function(){
     if(this.readyState!==4) return;
     if(this.status!=200) {
       document.getElementById('body').innerText = this.responseText;
       setTimeout(function(){insertHtml('adminDashboard.html', 'body'); }, 3000);
       return;
     }
     //error logging
     document.getElementById('body').innerHTML = this.responseText;
     setTimeout(function(){insertHtml('adminDashboard.html', 'body'); }, 3000);
   };
   httpRequest.send(jsonUser);
 }



 /********************/

function navigateToCreateUserPage(){
  insertHtml("/endpoints/createUserTH.html", 'body');
}
function navigateToAdminDashboard() {
  insertHtml('adminDashboard.html', 'body');
}

 function navigateToUserSignInPage(){
  insertHtml("userSignIn.html", 'body');
 }
