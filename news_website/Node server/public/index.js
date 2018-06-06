window.onload = function(){
let main_content = document.getElementById("news"); 
news_list = ""; 
let display_news = function () {

    if (this.readyState == XMLHttpRequest.DONE) {

        if (this.status == 200) {
            let news = JSON.parse(this.responseText);
            let x="";
            for(let i = 2; i < 40; i++){
                x = news[i];
                news_list += `<div class='news'> ${ x } </div>`

            }
            main_content.innerHTML = news_list;

        }

    }

};

let httpRequest = new XMLHttpRequest();
httpRequest.onreadystatechange = display_news;
httpRequest.open('GET', '/tabloid', true);
httpRequest.send();

};