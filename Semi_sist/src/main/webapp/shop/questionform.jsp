<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Nanum+Pen+Script&display=swap"
rel="stylesheet">
<style type="text/css">
.title, .subtitle{
	text-align: center;
	padding-bottom: 30px;

}
.subtitle{
	color: #708090;
	line-height: 30px;
}

</style>
<title>Insert title here</title>
</head>
<body>
        <article class="container" style="background-color: #f5f5f5 ;">
            <div class="page-header" >
                <div class="col-md-6 col-md-offset-3">
                <h2 class="title"><b>입점 문의</b></h2>
                <h4 class="subtitle" >지금 바로, 부담 없이 무료 상담 받아보세요!<br>
					아래 내용을 상세하게 적을수록 빠르고 정확한 상담이 가능합니다.</h4>
                </div>
            </div>
            <div class="col-sm-6 col-md-offset-3">
                <form action="questionaction.jsp" method="post">
                    <div class="form-group">
                        <label for="inputName">매장명&nbsp;&nbsp;<font color="red">*</font></label>
                        <input type="text" class="form-control" name="name" placeholder="매장명을 입력해 주세요" required="required">
                    </div>
                    <div class="form-group">
                        <label for="InputEmail">매장 전화번호&nbsp;&nbsp;</label>
                        <input type="tel" class="form-control" name="call" placeholder="전화번호를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">판매 음식 종류&nbsp;&nbsp;<font color="red">*</font></label>
                        <input type="password" class="form-control" name="tag" placeholder="음식종류를 입력해주세요" required="required">
                    </div>
                    <div class="form-group">
                        <label for="inputPasswordCheck">매장 주소&nbsp;&nbsp;<font color="red">*</font></label>
                        <input type="password" class="form-control" name="addr" placeholder="매장주소를 입력해주세요" required="required">
                    </div>
                    <div class="form-group" >
                        <label >매장사진</label>
                       <input type="file" name="photo">    
                    </div>
                    
                    <div class="form-group">
                        <label>영업 시간&nbsp;&nbsp;<font color="red">*</font></label><br>
                        <select name="open" style="width: 100px; float: left;">
                        <%
                        for(int i=0; i<=24; i++){%>
                        	<option value="<%=i%>"><%=i %>:00</option>
                        <%}
                        %>
             			
            			</select>
            			<b style="float: left;">&nbsp;&nbsp;~&nbsp;&nbsp;</b>
            			<select name="close" style="width: 100px; float: left;">
             				<%
                        for(int i=0; i<=24; i++){%>
                        	<option value="<%=i%>"><%=i %>:00</option>
                        <%}
                        %>
            			</select>
            			
                    </div>
                    <br><br>
                                        
                    
                    <div class="form-group"  style="clear: both;">
                        <label for="inputPasswordCheck" >매장 좌석 수&nbsp;&nbsp;<font color="red">*</font></label><br>
                        <label style="float: left; color: gray">룸&nbsp;&nbsp;</label>
                   
                        <input type="text" name="room" style="float: left; width: 50px; height: 20px;">&nbsp;좌석
                        <div style="clear: both;"></div>
                        <label style="float: left; color: gray">홀&nbsp;&nbsp;</label>
                        <input type="text" name="hall" style="float: left; width: 50px; height: 20px;">&nbsp;좌석
                    </div>
					<br> 
					 <div class="form-group"  style="clear: both;">
                        <label for="inputPassword">주차 공간 유무</label>&nbsp;&nbsp;
                        <input type="checkbox"  name="parkinglot" class="custom-control-input" >
                    </div>
                    
                
					 
					<div class="form-group" style="clear: both;">
                        <label for="inputPasswordCheck">메뉴</label>
                        <label for="inputPasswordCheck" style="margin-left: 150px;">가격</label>
                        <div style="clear: both;"></div>
                        <input type="text" class="form-control" name="menu" placeholder="메뉴 입력" 
                        style="width: 150px; float: left;">
                       
                        <input type="text" class="form-control" name="price" placeholder="가격 입력" 
                        style="width: 150px; float: left; margin-left: 30px;">
                        <div style="clear: both;"></div>
                        <br>
                        <div id="menuDiv"></div>
                        
                        
                       
                    </div>
                    <div style="clear: both;"></div>
 						 <button type="button" id="btnAdd">+</button>
					
					
                   <br> <br> <br> <br> <br> <br> <br> 

                    <div class="form-group text-center">
                        <button type="submit" id="join-submit" class="btn btn-primary">
                            접수하기<i class="fa fa-check spaceLeft"></i>
                        </button>
                        <button type="reset" class="btn btn-warning">
                            다시하기<i class="fa fa-times spaceLeft"></i>
                        </button>
                    </div>
                </form>
            </div>

        </article>
 					<script type="text/javascript">
                    
                    $("#btnAdd").click(function(){
                    	
                    	$("#menuDiv").append("<input type='text' class='form-control' name='menu' style='width: 150px; float: left; margin-bottom: 20px;' placeholder='메뉴 입력'>")
                    	$("#menuDiv").append("<input type='text' class='form-control' name='price' style='width: 150px; float: left; margin-left: 30px; margin-bottom: 20px;' placeholder='가격 입력'>")
						$("#menuDiv").append("<div style='clear: both;'></div>")
                        		
                    });
                    
                    </script>
    </body>
</html>

