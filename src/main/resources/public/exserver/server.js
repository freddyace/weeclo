const express= require('express');
const bodyParser = require('body-parser');
const cors = require('cors');


//constant for port number
const PORT = 3000;
//instance of express
const app = express();

//body parser to handle json data
app.use(bodyParser.json());

//parse package
app.use(cors());

//to test get request callback function
app.get('/', function(req, response ) {
  response.send("hello from server");
});

app.listen(PORT, function() {
  console.log("server is running on localhost: " + PORT);
});


//endpoint to which angular application will post data //
app.post('/enroll', function(request, response) {
  console.log(request.body); //contains user data submited
  response.status(401).send({"message": "Data received"})//response that sends an object that contains message
});
