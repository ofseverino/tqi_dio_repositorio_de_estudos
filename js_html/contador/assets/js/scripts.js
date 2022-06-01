var ValorMostrado= document.getElementById("ValorAtual");
var Counter=document.getElementById("counter");
var MudaValor=0;
function incrementa(){
    if (MudaValor<9) {
        MudaValor= MudaValor+1;
        Counter.style.backgroundColor="white";
    
    } else{
       if(MudaValor<10){
        MudaValor= MudaValor+1;
        Counter.style.backgroundColor="red";
       }
    }
    ValorMostrado.innerHTML=MudaValor;
}
function decrementa(){
    if (MudaValor>1) {
        MudaValor= MudaValor-1;
        Counter.style.backgroundColor="white";
    } else {
        if(MudaValor>0){
            MudaValor= MudaValor-1;
            Counter.style.backgroundColor="red";
           }
    }
    ValorMostrado.innerHTML=MudaValor;
}
