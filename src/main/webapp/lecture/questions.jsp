<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="/js/lecture/addQuestion.js"></script>
  <title>Quiz Generator</title>
</head>
<body>


 <!-- Main Content -->
 <div class="container" id="container">
  <!-- Quiz Form -->
  
  <div id="formContainer">
    <form id="quizForm" class="col s12">
      <!-- Title -->
      <div class="row">
        <div class="input-field col s12 m6">
          <input placeholder="Enter the question" type="text" class="validate" id="question_desc">
          <label for="question_title">Question Title</label>
        </div>
      </div>
      <!-- User Input 1 -->
      <div class="row">
        <div class="input-field col s12 m6">
          <input  placeholder="Enter answer" id="option1" type="text" class="validate">
          <label>Option A</label>
        </div>
      </div>
      <!-- User Input 2 -->
      <div class="row">
        <div class="input-field col s12 m6">
          <input  placeholder="Enter answer" type="text" id="option2" class="validate">
          <label>Option B</label>
        </div>
      </div>

      <!--User Input 3 -->
      <div class="row">
        <div class="input-field col s12 m6">
          <input " placeholder="Enter answer" type="text" id="option3" class="validate">
          <label>Option C</label>
        </div>
      </div>

      <!--Correct Answer-->
      <div class="row">
        <div class="input-field col s12 m6">
          <input id="correctValue" placeholder="Enter the correct answer. 1,2,3?" type="text" class="validate">
          <label>Correct Answer</label>
        </div>
      </div>

      <!-- Submit Button -->
      <div id="submitBtn" class="col s6">
        <a id="submit" class="waves-effect waves-light btn-small" onclick="addQuestions()">Add to bank</a>
		 <a id="submit" class="waves-effect waves-light btn-small">Back</a>
		  <a id="submit" class="waves-effect waves-light btn-small">Complete</a>
      </div>
	  
	   
    </form>
  </div>

  <!-- Quiz -->
  <form id="quiz" class="hide" action="#">
    <h5 id="qTitle"></h5>
    <!-- Choice 1 -->
    <p>
      <label>
        <input id="check1" class="with-gap" type="radio" name='choices' value="A"/>
        <span id="option1"></span>
      </label>
    </p>
    <!-- Choice 2 -->
    <p>
      <label>
        <input id="check2" class="with-gap" type="radio" name='choices' value="B"/>
        <span id="option2"></span>
      </label>
    </p>
    <!-- Choice 3 -->
    <p>
      <label>
        <input id="check3" class="with-gap" type="radio" name='choices' value="C"/>
        <span id="option3"></span>
      </label>
    </p>
    <a id="submitAnswer" class="waves-effect waves-light btn-small">Next Question</a>
  </form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>

</body>
</html>