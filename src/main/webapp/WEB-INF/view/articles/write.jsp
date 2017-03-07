<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Board/css/layout.css" />
<script type="text/javascript" src="/Board/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){		
				
		var errorCode = "${errorCode}";
		if(errorCode==1){
			alert("1에러");
		}
		else if(errorCode==2){
			alert("2제목에러");
		}
		else if(errorCode==3){
			alert("3내용에러");
		}
		
		
		$("#writeBtn").click(function(){
			$("#writeForm").attr({
				"method":"post",
				"action":"/Board/board/doWrite" 
			}).submit();
			alert("등록되었습니다.");
		});
		
		$("#goBackBtn").click(function() {
			location.href="/Board/board/list";
		});
	});
</script>
</head>
<body>
	<div id="wrapper">
		<form id="writeForm" name="writeForm">
			<div>
				<input type="text" id="articleSubject" name="articleSubject" placeholder="제목을 입력하세요." />
			</div>
			<div>
				<textarea id="articleContent" name="articleContent" placeholder="내용을 입력하세요."></textarea>
			</div>
			<div style="margin-top:5px;">
				<div class="left">
					<input type="file" id="file" name="file" />
				</div>
				<div class="right">
					<div class="inline">
						<input type="button" id="goBackBtn" value="뒤로가기" />
					</div>
					<div class="inline">
						<input type="button" id="writeBtn" value="글쓰기" />
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</form>
	</div>
</body>
</html>