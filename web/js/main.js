/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global fetch */

//API to determine if a given block of text has a positive, negative, or neutral tone
const MY_API_KEY = 'fc784b62c5mshff084e05cd1bc72p1c8f61jsn82865c409549';

const data = JSON.stringify({
	"language": "english",
	"text": " "
});

const xhttp = new XMLHttpRequest();
xhttp.withCredentials = true;

xhttp.addEventListener("readystatechange", function () {
	if (this.readyState === this.DONE) {
                const data = JSON.parse(xhttp.response);
		console.log(data);
	}
});

xhttp.open("POST", "https://text-analysis12.p.rapidapi.com/sentiment-analysis/api/v1.1");
xhttp.setRequestHeader("content-type", "application/json");
xhttp.setRequestHeader("x-rapidapi-host", "text-analysis12.p.rapidapi.com");
xhttp.setRequestHeader("x-rapidapi-key", MY_API_KEY);

xhttp.send(data);


//Fetch comments from comment form
function fetchComments(str) {
    var xhttp;
    if (str == "") {
        document.getElementById("rating").innerHTML = "";
        return;
    }
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("rating").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "Comment_Servlet" + str, true);
    xhttp.send();
}


//Adding user comments
var post= document.getElementById("post");
    post.addEventListener("click", function(){
    var commentBoxValue= document.getElementById("comment-box").value;
 
    var li = document.createElement("li");
    var text = document.createTextNode(commentBoxValue + "\n");
    li.appendChild(text);
    document.getElementById("unordered").appendChild(li);
 
});

