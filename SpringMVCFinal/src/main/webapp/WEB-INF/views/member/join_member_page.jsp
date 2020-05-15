<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
crossorigin="anonymous">

<script type = "text/javascript">

function testAjax(){
	
	//AJAX 호출...코드 시작
	var xmlhttp = new XMLHttpRequest();
	
	xmlhttp.onreadystatechange = function() {
		
		if(xmlhttp.readyState==4 && xmlhttp.status == 200){
			//alert("안녕하세요");
			//alert(xmlhttp.responseText);
			var box = 
				document.getElementById("test_box");
			
			var obj = JSON.parse(xmlhttp.responseText);
			
			var ul = document.createElement("ul");
			
			for(var i = 0 ; i < obj.length ; i++){
				var li = document.createElement("li");
				li.innerText = obj[i].member_nick;
				ul.appendChild(li);
			}
			
			box.appendChild(ul);
			
		}
		
	};

	xmlhttp.open("get","./testAjax.do" , true);
	
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

	xmlhttp.send("v1=111&v2=222&v3=aaaaa");
}


function frm_submit(){
	var frm = document.getElementById("frm");

	//유효성 검사
	var idBox = document.getElementById("id");
	
	
	//ID 유효성....이메일 검사
	var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	
	if(!reg.test(idBox.value)){
		alert("아이디는 이메일 형식에 맞춰야 됩니다.");
		
		idBox.value = "";
		idBox.focus();
		
		return;
	}
	
	reg = /^[A-Za-z0-9]{6,12}$/;

	var pwBox = document.getElementById("pw");
	
	if(!reg.test(pwBox.value)){
		alert("비밀번호는 숫자,영문자로 6-12자리 여야 합니다.");
		return;
	}
	
	
	frm.submit();
}

</script>


<jsp:include page = "../commons/global_nav.jsp"></jsp:include>

<div class = "container mt-4">
<form id = "frm" action = "./join_member_process.do" method = "post">
	<div class = "row">
		<div class = col-5></div>
		<div class = col>
			<div class = "row text-center">
				<div class = "col">
					<div class = "alert alert-primary" role = "alert">
					<h1>회원가입</h1>
					</div>
				</div>
			</div>
			<div class = "row mt-5">
				<div class = "col-4">
					<div class = "alert alert-primary" role = "alert">
					ID(이메일)
					</div>
				</div>
				<div class = "col">
					<input id = "id" placeholder = "이메일을 입력해주세요" name = "member_id" type = "text" class = "form-control"><input type="button" value="아이디확인" onclick="testAjax()"><br>
				</div>							
			</div>
			<div class = "row">
				<div class = "col-4">
					<div class = "alert alert-primary" role = "alert">
					PW
					</div>
				</div>
				<div class = "col">
					<input id = "pw" name = "member_pw" type = "text" class = "form-control">
				</div>							
			</div>
			<div class = "row">
				<div class = "col-4">
					<div class = "alert alert-primary" role = "alert">
					NICK
					</div>
				</div>
				<div class = "col">
					<input name = "member_nick" type = "text" class = "form-control">
				</div>							
			</div>
			<div class = "row">
				<div class = "col-4">
					<div class = "alert alert-primary" role = "alert">
					성별
					</div>
				</div>				
				<div class = "col">
					<div class = "btn-group btn-group-toggle" data-toggle = "buttons">
					<label class = "btn btn-secondary active">
					<input type = "radio" name = "member_sex" value = "M" checked>남
					</label>
					<label class = "btn btn-secondary active">
					<input type = "radio" name = "member_sex" value = "W">여
					</label>
					</div>											
				</div>
			</div>
			<div class = "row">
				<div class = "col-4">
					<div class = "alert alert-primary" role = "alert">
					취미
					</div>
				</div>
				<div class = "col">
					<input type = "checkbox" name = "member_hobby" value = "1">농구
					<input type = "checkbox" name = "member_hobby" value = "2">축구
					<input type = "checkbox" name = "member_hobby" value = "3">야구
					<input type = "checkbox" name = "member_hobby" value = "4">독서<br>
				</div>
					<br>
			</div>							
			<div class = "row">
				<div class = "col"></div>
				<div class = "col-5">
				<input onclick = "frm_submit()" type = "button" value = "회원가입">
				</div>
			</div>			
		<div class = col-5></div>	
	</div>

</form>

<br>
<div id="test_box"></div>



</div>


<!-- <h1>회원가입</h1>

<form action = "./join_member_process.do" method = "post">
	ID(이메일) : <input type = "text" name = "member_id"><br>
	PW : <input type = "password" name = "member_pw"><br>
	Nick : <input type = "text" name = "member_nick"><br>
	성별 : <input type = "radio" name = "member_sex" value = "M" checked>남
	<input type = "radio" name = "member_sex" value = "W">여<br>
	취미 : <input type = "checkbox" name = "member_hobby" value = "1">농구
	<input type = "checkbox" name = "member_hobby" value = "2">축구
	<input type = "checkbox" name = "member_hobby" value = "3">야구
	<input type = "checkbox" name = "member_hobby" value = "4">독서<br>
	<input type = "submit" value = "회원가입">
	hobby는 배열로 받을 예정

</form>
 -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" 
integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" 
crossorigin="anonymous"></script>
</body>
</html>



