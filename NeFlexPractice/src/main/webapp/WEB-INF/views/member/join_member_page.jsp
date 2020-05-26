<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

<script type="text/javascript">

	var isConfirmID = false; 

	function confirmID(){
		var inputValue = document.getElementById("id").value;
		
		var xmlhttp = new XMLHttpRequest();

		xmlhttp.onreadystatechange = function(){
			if(xmlhttp.readyState==4 && xmlhttp.status == 200){
				
				if(xmlhttp.responseText == 'true'){
					isConfirmID = true;
					alert("사용 가능한 아이디 입니다.");
				}else{
					isConfirmID = false;
					alert("사용 불가능한 아이디 입니다.");
				}
				
			}
			
			
		};

		xmlhttp.open("post","./confirmId.do" , true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("id=" + inputValue);
	}

	function confirmID_jQuery(){
		
		var inputValue = $("#id").val();
		
		$.ajax({
			type : 'post',
			url : './confirmId.do',
			data : {'id' : inputValue},
			success : function(result){
				if(result == 'true'){
					alert("사용 가능한 아이디 입니다.");
					isConfirmID = true;
				}else{
					alert("사용 불가능한 아이디 입니다.");
					isConfirmID = false;
				}
			}
		});
		
		
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
		
		if(isConfirmID != true){
			alert("아이디 중복 체크를 해주셔야 됩니다.");
			return;
		}
		
		frm.submit();
	}

</script>


</head>
<body>
<h1>회원 가입</h1>

<form id="frm" action="./join_member_process.do" method="post">
	ID(이메일) : <input id="id" type="text" name="member_id"> <input type="button" value="아이디확인" onclick="confirmID_jQuery()"><br>
	PW : <input id="pw" type="password" name="member_pw"><br>
	Nick : <input type="text" name="member_nick"><br>
	성별 : <input type="radio" name="member_sex" value="M" checked>남 
	<input type="radio" name="member_sex" value="W">여<br>
	취미 : <input type="checkbox" name="member_hobby" value="1">농구
	<input type="checkbox" name="member_hobby" value="2">축구 
	<input type="checkbox" name="member_hobby" value="3">야구 
	<input type="checkbox" name="member_hobby" value="4">독서<br>
	<input onclick="frm_submit()" type="button" value="회원 가입"> 

</form>

<br>
<div id="test_box"></div>




</body>
</html>










