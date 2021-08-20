<!DOCTYPE html>
<html>
<style>
body, html {
  height: 100%;
  margin: 0;
}

.bgimg {
  background-image: url('https://images.pexels.com/photos/8438880/pexels-photo-8438880.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');
  height: 100%;
  background-position: center;
  background-size: cover;
  position: relative;
  color: white;
  font-family: "Courier New", Courier, monospace;
  font-size: 25px;
}

.topleft {
  position: absolute;
  top: 0;
  left: 16px;
}

.topmiddle {
  position: absolute;
  top: 0;
  left: 45%;
}

.bottomleft {
  position: absolute;
  bottom: 0;
  left: 16px;
}

.bottommiddle {
  position: absolute;
  bottom: 0;
  left: 45%;
}

.middle {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
}

hr {
  margin: auto;
  width: 40%;
}

</style>
<body>

<div class="bgimg">
  <div class="topmiddle">
  <p>${title }</p>
  </div>
  <div class="middle">
    <h1>ITS TOO EARLY :) </h1>
    <hr>
    <p id="demo" style="font-size:30px"></p>
  </div>
  <div class="bottommiddle">
    <p>All the Best !</p>
  </div>
</div>

<script>
// Set the date we're counting down to
var countDownDate = new Date('${startat}').getTime();

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
  document.getElementById("demo").innerHTML = days + "d " + hours + "h "
  + minutes + "m " + seconds + "s ";
  
  // If the count down is over, write some text 
  if (distance < 0) {
    clearInterval(countdownfunction);
    document.getElementById("demo").innerHTML = "You are ready to go !. We are fetching your Questions...";
    location.reload();
    
  }

  
}, 1000);
</script>

</body>
</html>
