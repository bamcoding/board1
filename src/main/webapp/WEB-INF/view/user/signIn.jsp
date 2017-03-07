<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"\ type="text/css" href="/Board/css/layout.css" />
<script type="text/javascript" src="/Board/js/jquery-3.1.1.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		moveToCenter();
		isVisibleJoinButton();
		
		var errorCode = "${errorCode}";
		if(errorCode == 1) {
			$("div.warning").html("<p>로그인 실패!</p>");
		}
		else if(errorCode == 2) {
			$("div.warning").html("<p>아이디를 입력하세요!</p>");
		}
		else if(errorCode == 3) {
			$("div.warning").html("<p>비밀번호를 입력하세요!</p>");
		}
		else if(errorCode == 4) {
			$("div.warning").html("<p>존재하지 않는 아이디입니다!</p>");
		}
		
		$("#userEmail").keyup(function () {
			//alert($(this).val());
			if($(this).val() == "") {
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			
			isVisibleJoinButton();
		});
		$("#userPassword").keyup(function () {
			//alert($(this).val());
			if($(this).val() == "") {
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			
			isVisibleJoinButton();
		});
		
		
		$("#signInBtn").click(function() {
			$("#loginForm").attr({
				"method":"post",
				"action": "/Board/doSignIn"
			}).submit();
		});
	});
	
	$(window).resize(function() {
		moveToCenter();
	});
		
	function moveToCenter() {
		var windowHeight = $(window).height();
		var wrapperHeight = $("#wrapper").height();
		var middlePosition = (windowHeight / 2) 
								- (parseInt(wrapperHeight) / 2);
		
		$("#wrapper").css({
			"position": "relative"
			, "top": middlePosition+ "px"
		});
	}
	function isVisibleJoinButton() {
		
		if($(".pass").length == 2) {
			$("#joinBtn").show(500);
		}
		else {
			$("#joinBtn").hide();
		}
	}
</script>
</head>
<body>
	<div id="wrapper">
		<form id="loginForm">
			<div class="warning" style="text-align: center;"></div>
			
			<input type="text" id="userEmail" name="userEmail"
				placeholder="Email or ID" /><br /> <input type="password"
				id="userPassword" name="userPassword" placeholder="Password" /><br />
			<div style="margin-top: 5px;">
				<div class="left">
					<input type="button" id="signInBtn" value="Sign In" />
				</div>
				<div class="right">
					<input type="button" id="cancelBtn" value="Cancel" />
				</div>
				<div class="clear"></div>
			</div>
		</form>
	</div>
</body>
</html>