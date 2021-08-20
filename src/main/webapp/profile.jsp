<!DOCTYPE html>
<html lang="en">
<head>

<!--TITLE-->
<title></title>

<!--ICON-->
<link rel="shortcut icon" href="/DevanagariBrahmi/logo.png">

<!--META TAGS-->
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="author" content="Team Bboysdreamsfell">
<meta name="description" content="">
<meta name="keywords" content="">
<meta property="og:locale" content="en_US" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="Profiler Name || Krishivalahs" />

<!--EXTERNAL CSS-->
<link rel="stylesheet" href="/css/profile.css">


<!--FONT AWESOME-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<body>

<div class="container">
<div class="alert">
  <span class="closebtn">&times;</span>  
  <strong>NOTE!</strong> Please complete your profile.. <a href="#" style="color:#7ed321;">Delete my Account</a>
</div>
<table>
<tr>
<td>
<section>
<label for="fileToUpload">
<i class="fa fa-camera"></i>
<input type="file" id="fileToUpload" style="visibility:hidden;"  accept=".png,.jpg,jpeg,.PNG,.JPEG" name="fileToUpload" onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])">
</label>
<img src="data:image/jpg;base64,${image}" onerror="this.onerror=null;this.src='https://i.ibb.co/yNGW4gg/avatar.png';" id="blah" alt="Avatar">
</section>
<h1>Bharadwaj</h1>
<h3>Learner</h3>
</td>
<td>
<ul>
<li><b>Full name</b> <input type="text" name="fname" id="fname" maxlength="100" value="" required /> <i class="fa fa-edit" id="edit1" onclick="document.getElementById('fname').style.pointerEvents='auto';document.getElementById('fname').focus();this.style.display='none'; document.getElementById('check1').style.display='inline-block';"></i> <i class="fa fa-check" style="display:none;" id="check1" onclick="document.getElementById('edit1').style.display='inline-block';this.style.display='none';document.getElementById('fname').style.pointerEvents='none';"></i></li>
<li><b>Email</b> <input type="email" name="email" id="username" maxlength="150" value="${username}" required /></li>
<li><b>Contact number</b> <input type="tel" name="mobile" id="mobile" maxlength="10" value="" required /> <i class="fa fa-edit" id="edit2" onclick="document.getElementById('mobile').style.pointerEvents='auto';document.getElementById('mobile').focus();this.style.display='none'; document.getElementById('check2').style.display='inline-block';"></i> <i class="fa fa-check" style="display:none;" id="check2" onclick="document.getElementById('edit2').style.display='inline-block';document.getElementById('mobile').style.pointerEvents='none';this.style.display='none';"></i></li>
<li><b>Organization details</b> <input type="text" name="address" id="org" maxlength="250" value="" required /> <i class="fa fa-edit" id="edit3" onclick="document.getElementById('org').style.pointerEvents='auto';document.getElementById('org').focus();this.style.display='none'; document.getElementById('check3').style.display='inline-block';"></i> <i class="fa fa-check" style="display:none;" id="check3" onclick="document.getElementById('edit3').style.display='inline-block';document.getElementById('address').style.pointerEvents='none';this.style.display='none';"></i></li>
</ul>
<button type="button" class="button" id="updateButton"value="${userId}">Update</button>
</td>
</tr>
</table>
<div id="status"></div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/js/profile.js"></script>
<script>
function editdetails2(){
}

var close = document.getElementsByClassName("closebtn");
var i;

for (i = 0; i < close.length; i++) {
  close[i].onclick = function(){
    var div = this.parentElement;
    div.style.opacity = "0";
    setTimeout(function(){ div.style.display = "none"; }, 600);
  }
}
</script>
</body>
</html>
<script type="text/javascript">
                $(document).ready(function (e) {
                    $('#fileToUpload').change(function()  {
                    	  $('#status').html("We are uploading your image");
                        var file_data = $('#fileToUpload').prop('files')[0];
                        var form_data = new FormData();
                        form_data.append('image', file_data);
                        $.ajax({
                            url: '/photos/add', // point to server-side controller method
                            dataType: 'text', // what to expect back from the server
                            cache: false,
                            contentType: false,
                            processData: false,
                            data: form_data,
                            type: 'post',
                            success: function (response) {
                                $('#status').html("Your image is uploaded successfully"); // display success response from the server
                            },
                            error: function (response) {
                                $('#status').html("Something went wrong while uploading your picture"); // display error response from the server
                            }
                        });
                    });
                });
            </script>