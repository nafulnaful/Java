//사용 변수
let score=0;
let time =9;

const wordInput = document.querySelector('.word-input');
const wordDisplay =document.querySelector('.word-display');
const scoreDisplay =document.querySelector('.score');

wordInput.addEventListener('input',() => {
    if(wordInput.value.toLowerCase() === wordDisplay.innerText.toLowerCase()){
        score++;
        scoreDisplay.innerText = score;
        wordInput.value = "";
    }
})


fuction countDown(){
    
    time > 0? time --
}