<link rel="stylesheet" href="/css/question.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/js/question.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
var result=0
function validateAns(qno,option,selected)
{
	var pathname = window.location.pathname; 
	var mark=1
    $.post(pathname +"/"+qno, {'option': option+1}, function(data){
        if(data==option+1)
        {
        			  $('.'+qno).parent().css('color','black');
        		      $(selected).parent().css('color','green');
        		      $(selected).parent().css('font-weight','bold');
        		      $(selected).parent().append('&#10004;').show();
        		      $('.'+qno).prop("onclick", null).off("click");
        		      result=result+mark
        		    
        }
        else
        	{
  		  $('.'+qno).parent().css('color','black');
	      $(selected).parent().css('color','red');
	      $(selected).parent().css('font-weight','normal');
	
        	}
        
    })
    .fail(function(response) {
    	 setTimeout(function(){
    	launch_toast("404","Reconnecting");
        validateAns(qno,option,selected)	
    	 },1000);
    });
	}
	
function launch_toast(title,msg) {
    var x = document.getElementById("toast")
    x.className = "show";
    $('#toast_title').html(title)
    $('#toast_message').html(msg)
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 6000);
}

</script>

<div id="container">
<div class="topright">
   <p id="countdown" style="font-size:18px"></p>
   </div>
  <header>
    <h1>${details.subject} Quiz</h1>
    <p>Test your knowledge in <strong>${details.questionTitle }</strong></p>
  </header>
  <section>
    <div id="results"></div>
    <form name="quizForm" onsubmit="return submitAnswers()">
    <c:set var = "qno" value = "${0}"/>
    
    <c:forEach items="${questions}" var="qn">
     <c:set var = "qno" value = "${qno+1}"/>
      <h3>${qno}. ${qn.question}</h3>
        
        <c:forEach items="${qn.options}" var="option" varStatus="loop">
         <label><input type="radio" name="q1" value="a" class="${qn.qno}" onclick="validateAns(${qn.qno},${loop.index},this)"> &#${loop.index + 97};)  ${option} </label><br>
        </c:forEach>
      
      <br><br>
     </c:forEach>
   
      <input type="submit" value="Submit Answers">
    </form>
  </section>
  <footer>
    <p>Created by : ${details.creator}</p>
  </footer> 
</div>
<div id="toast"><div id="toast_title">Icon</div><div id="toast_message">A notification message..</div></div>


<script>
// Set the date we're counting down to
var countDownDate = new Date('${endat}').getTime();

// Update the count down every 1 second
var countdownfunction = setInterval(function() {

  // Get todays date and time
  var now = new Date().getTime();
  
  // Find the distance between now an the count down date
  var distance = countDownDate - now;
  
  // Time calculations for days, hours, minutes and seconds
  var days = Math.floor(distance / (1000 * 60 * 60 * 24));
  var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);
  
  // Output the result in an element with id="demo"
  document.getElementById("countdown").innerHTML = "Ends in: "+days + "d " + hours + "h "
  + minutes + "m " + seconds + "s ";
  
  // If the count down is over, write some text 
  if (distance < 0) {
    clearInterval(countdownfunction);
    document.getElementById("countdown").innerHTML = "Time up !...";
    location.reload();
    
  }

  
}, 1000);


</script>