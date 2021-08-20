<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
  <link rel="stylesheet" href="/js/dateTime/jquery-timepicker.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/js/lecture/generate.js"></script>

<script src="/js/dateTime/datetimepicker.js"></script>

  <title>Quiz Generator</title>
</head>
<body>
 <!-- Main Content -->
 <input type="hidden" id="testid"  value="${testid}"> 
 <div class="container" id="container">
 <div class="column1">
 <div class="col s12">
 
   <!-- Configue Quiz -->
   <div class="row" id="quizConfig">
    <form class="col s12">
      <div class="row">
        <div class="input-field col m7 s12">
          <input placeholder="Student name/number" id="sname" type="text" class="validate">
          <label for="questions">Start typing student name or id</label>
        </div>
        </div>
    </form>
    <!-- Create questions -->
    <div class="col s6">
      <a id="generateBtn" class="waves-effect waves-light btn-small" onclick="addStudent()">Add student</a>
	  
    </div>
   </div>
     <div class="row" id="quizConfig">
    <form class="col s12">
      <div class="row">
        <div class="input-field col m7 s12">
          <input placeholder="Subject Name" id="subject" type="text" class="validate">
          <label for="questions">Subject Name</label>
        </div>
        </div>
    </form>
    </div>
   
      <div class="row" id="quizConfig">
    <form class="col s12">
      <div class="row">
        <div class="input-field col m7 s12">
          <input placeholder="Topic Name" id="qTitle" type="text" class="validate">
          <label for="questions">Test Topic Name</label>
        </div>
        </div>
    </form>
    <!-- Create questions -->
   
   </div>
   
   
   
      <div class="row" id="quizConfig">
    <form class="col s12">
	 <label for="questions">Test Duration and Proctoring Option</label>
      <div class="row">
	           
        <div class="input-field col m7 s12">
		   <input type = "text" id = "startAt">
		      <input type = "text" id = "endAt">
			 
        </div>
		
        </div>
		<label>
        <input type="checkbox" id="isPublic"/>
        <span>Public Mode</span>
   </label>
   	 <label>
        <input type="checkbox" id="isProctored"/>
        <span>Enable Proctoring</span>
   </label>
    </form>
	
    <!-- Create questions -->
    <div class="col s6">
      <a id="generateBtn" onclick="setTimeAndTitle() "class="waves-effect waves-light btn-small">Update options</a>
    </div>
   </div>
  <input type="checkbox" name="options"/>

  </div>
  </div>
  <div class="column2">
   Student list
   </div>
   </div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
</body>
</html>
<style>

.column1 {
  flex: 70%;
  padding: 10px;
 
}
column2 {
  flex: 30%;
  padding: 10px;
 
}
.container {
  display: flex;
}
.row
{
margin-bottom:20px;
}


</style>