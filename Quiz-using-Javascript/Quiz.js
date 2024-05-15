//Quiz Prototye

function Quiz(questions){
    this.score=0;
    this.questionIndex=0;
    this.question=questions;
}


//fuction to return questions from current index number
Quiz.prototype.getQuestionByIndex=function(){
    return this.questions[this.questionIndex];
}

//function to check the end of the quiz
Quiz.prototype.isEnded=function(){
return this.questions.length===this.questionIndex;
}


//function to check the correct answer and incrememt score along with move to next question
Quiz.prototype.checkOptionWithAnswer=function(answer){
    if(this.getQuestionByIndex().isCorrectAnswer(answer)){
        this.score++;
    }
    this.questionIndex++;
}

//Question Prototype
function Question(text, choices, answer){
    this.text=text;
    this.choices=choices;
    this.answer=answer;
}

Question.prototype.isCorrectAnswer=function(choice){
    return this.answer===choice;

}

//To load questions on HTML page 1 by 1
 function loadQuestions(){
    if(quiz.isEnded()){
        showScores();
    }
    else{

        //show next question
        var element = document.getElementById("question");
        element.innerHTML=quiz.getQuestionByIndex().text;
        var choices= quiz.getQuestionByIndex().choices;
        for(var i=0;i<choices.length;i++){
            var element_choice=document.getElementById("choice"+i);
            element_choice.innerHTML=choices[i];
            handleOptionButton("btn"+i,choices[i]);
        }
        showProgress(); 
    }
 }

 function handleOptionButton(id, choice){
    var button = document.getElementById(id);
    button.onclick=function(){
        quiz.checkOptionWithAnswer(choice);
        loadQuestions();
    }
 }

 //show progress
 function showProgress(){
    var currentQuestionNumber=quiz.questionIndex+1;
    var progressbar=document.getElementById("progress");
    progressbar.innerHTML="Question"+currentQuestionNumber + "of" + quiz.question.length;
 }

 //showscore function
 function showScores(){
    var result = "<h1>Result<h1><h2 id = 'score'> Your Score ::";
    result+=quiz.score;
    result+="<br>Precentage is ::"+(quiz.score/question.length*100) +"%"
    var element=document.getElementById("quiz");
    element.innerHTML=result;
 }
//Array of Questions
var questions=[
     new Question("JavaScript supports?",["Function","XHTML","CSS","HTML"],"Functions"),
     new Question("Which language is used for styling web page?",["HTML","JQuery","CSS","XML"],"CSS"),
     new Question("Which is not a java framework?",["Python Query","Django","JQuery","Nodejs"],"Django"),
     new Question("Which is used fro connect to Database",["PHP","HTML","JS","ALL"],"PHP"),
     new Question("JavaScript is a?",["Language","Programming Language","Development","All"],"Programming Language")];


//create object of quiz
var quiz=new Quiz(questions);
loadQuestions();