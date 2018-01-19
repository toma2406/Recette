function compterRecette() {
    var requeteComptage = new XMLHttpRequest();
    requeteComptage.open("GET","CompterRecette",true);
    requeteComptage.responseType="text";

    requeteComptage.onload= function(){
        console.log("Nombre de recettes: " + this.response);
        var span = document.querySelector("span#nbrRecettes");
        span.textContent=this.response;
    }

    requeteComptage.send();
};


window.onload = function() {
    compterRecette();
}