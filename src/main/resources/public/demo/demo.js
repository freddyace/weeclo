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
