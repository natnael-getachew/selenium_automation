// import all necessary modules 
let express = require("express");
let bodyParser = require("body-parser");
let fs = require('fs');
let app = express();

app.use(express.static("public")); 
app.get('/tabloid/', function (request, response) {

    response.header('Content-Type', 'text/plain');

    let news_content = fs.readFileSync('C:\\Users\\user\\IdeaProjects\\WebAuto\\news_content.json', 'utf-8');

    let news = JSON.parse(news_content);

    let resp; // response container
    

    let result = news;
    
    if (result) {
        resp = result;
    } else {
        resp = 'No More News!';
    }

    response.send(resp);

});

app.listen(8000);