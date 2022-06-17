const cartas = document.querySelectorAll(".carta");/*seleciona todos os elementos com a classe carta*/
let CartaVirada=false;
let PrimeiraCartaObj, SegundaCartaObj ;
let PrimeiraCartaEnb = false, SegundaCartaEnb = false;
let BloqueiaTabuleiro=false;
let NumeroAcertos=0;

function Inicializar() { // muda a posição das cartas na inicialização e mostra as imagens rapidamente
    cartas.forEach((carta) => {
        let PosicaoAleatoria = Math.floor(Math.random() * 12);
        carta.style.order = PosicaoAleatoria;
        carta.classList.add('flip');
    });
    setTimeout(() => { 
        InitDesvira(); 
    }, 1000);
}

function AtribuiCartas(Carta){ /* atribui identificação das imagens as cartas viradas*/
    if(!PrimeiraCartaEnb){
        PrimeiraCartaEnb=true;
        PrimeiraCartaObj= Carta;
        PrimeiraCartaObj.removeEventListener("click",ViraCartas);
    }else if(!SegundaCartaEnb){
        SegundaCartaEnb=true;
        SegundaCartaObj= Carta;
        PrimeiraCartaObj.removeEventListener("click",ViraCartas);
        BloqueiaTabuleiro=true;
    }
}

function DesviraCartas(){ /* remove a classe para desvirar as cartas*/
    PrimeiraCartaObj.classList.remove('flip');
    SegundaCartaObj.classList.remove('flip');
    BloqueiaTabuleiro=false;
    PrimeiraCartaEnb=false;
    SegundaCartaEnb=false;
}

function ComparaCartas(){ /*compara as cartas viradas e bloqueia se forem iguais*/
    if (SegundaCartaEnb) {
        if (PrimeiraCartaObj.dataset.img === SegundaCartaObj.dataset.img ) {
            PrimeiraCartaObj.removeEventListener("click",ViraCartas);
            PrimeiraCartaObj.removeEventListener("click",ViraCartas);
            BloqueiaTabuleiro=false;
            PrimeiraCartaEnb=false;
            SegundaCartaEnb=false;
            NumeroAcertos ++;
        }else{
            setTimeout(DesviraCartas,1200);
            PrimeiraCartaObj.addEventListener("click",ViraCartas);
            PrimeiraCartaObj.addEventListener("click",ViraCartas);
        } 
        
    }
   
}


function ViraCartas(){
    if (BloqueiaTabuleiro) { return}
    this.classList.add('flip');/* quando clicado adiciona  a classe flip*/ 
    let Carta=this; // atribui o card atual à variavel carta
    AtribuiCartas(Carta);
    ComparaCartas();
    if (NumeroAcertos >= 6) {
        setTimeout(() => {
            cartas.forEach((carta) => {
                carta.classList.remove('flip');
                carta.addEventListener("click",ViraCartas);
            });
            setTimeout(() => {
                Inicializar();
            }, 800);
            NumeroAcertos=0;
            PrimeiraCartaEnb=false;
            SegundaCartaEnb=false;
            BloqueiaTabuleiro=false; 
        }, 1000);
       
    }
}
(function init() {
    Inicializar();
})();

function InitDesvira() { // desvira as cartas após inicialização
    cartas.forEach((carta) => {
        carta.classList.remove('flip');
    });
}


cartas.forEach(
    (carta)=>{ /* para cada elemento na lista adiciona uma função para o evento clique*/
        carta.addEventListener("click",ViraCartas);
    }
)