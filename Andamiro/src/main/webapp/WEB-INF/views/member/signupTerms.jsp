<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
<c:import url="/top" />
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<!-- Bootstrap -->
  
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="http://code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <style>
a {
	color: #658361;
	text-decoration: none;
	background-color: transparent;
}
.head_find{
	padding-top:.5em;
}

label {
    cursor: default;
    padding:0;
    display:inline;
    margin-top:1.5px;
}
</style> 
    <!-- 모달창 -->
            <div class="modal fade" id="defaultModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">알림</h4>
                        </div>
                        <div class="modal-body">
                            <p class="modal-contents"></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!--// 모달창 end-->
            
    <script>
  //------- validation 검사
   $(function(){
                //모달을 전역변수로 선언
                var modalContents = $(".modal-contents");
                var modal = $("#defaultModal");
                
    $( "form" ).submit(function( event ) {
        
        var provision = $('#provision');
        var memberInfo = $('#memberInfo');
        
        //회원가입약관
        if($('#provisionYn:checked').val()=="N"){
            modalContents.text("회원가입약관에 동의하여 주시기 바랍니다."); //모달 메시지 입력
            modal.modal('show'); //모달 띄우기
            
            provision.removeClass("has-success");
            provision.addClass("has-error");
            $('#provisionYn').focus();
            return false;
        }else{
            provision.removeClass("has-error");
            provision.addClass("has-success");
        }
        
        //개인정보취급방침
        if($('#memberInfoYn:checked').val()=="N"){
            modalContents.text("개인정보취급방침에 동의하여 주시기 바랍니다.");
            modal.modal('show');
            
            memberInfo.removeClass("has-success");
            memberInfo.addClass("has-error");
            $('#memberInfoYn').focus();
            return false;
        }else{
            memberInfo.removeClass("has-error");
            memberInfo.addClass("has-success");
        }

    });
    });
	</script>
    
    <div class="container" style="padding: 5% 0 0 10%">
        <h3>안다미로 회원가입</h3><br><br><br>
        <h5 style="text-decoration: solid;">이용약관동의</h5>
       <hr style="border: solid 1px black;">
        <br>
        <!-- action="javascript:alert( 'success!' );"  -->
        <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/signup" >
                <div class="form-group">
                    <label for="provision" class="col-lg-3 control-label">회원가입약관</label>
                    <div class="col-lg-10" id="provision">
                        <textarea class="form-control" rows="8" style="resize:none">약관동의
제1조(목적)
이 약관은 안다미로(전자상거래 사업자)가 운영하는 안다미로(이하 “안”이라 한다)에서 제공하는 인터넷 관련 서비스(이하 “서비스”라 한다)를 이용함에 있어 사이버 안과 이용자의 권리․의무 및 책임사항을 규정함을 목적으로 합니다.
※「PC통신, 무선 등을 이용하는 전자상거래에 대해서도 그 성질에 반하지 않는 한 이 약관을 준용합니다.」
                          
제2조(정의)
① “안”이란 안다미로가 재화 또는 용역(이하 “재화 등”이라 함)을 이용자에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 재화 등을 거래할 수 있도록 설정한 가상의 영업장을 말하며, 아울러 사이버몰을 운영하는 사업자의 의미로도 사용합니다.
② “이용자”란 “안”에 접속하여 이 약관에 따라 “안”이 제공하는 서비스를 받는 회원 및 비회원을 말합니다.
③ ‘회원’이라 함은 “안”에 회원등록을 한 자로서, 계속적으로 “안”이 제공하는 서비스를 이용할 수 있는 자를 말합니다.
④ ‘비회원’이라 함은 회원에 가입하지 않고 “안”이 제공하는 서비스를 이용하는 자를 말합니다.  
                        </textarea>
                   <br>
                   <div style="padding: 0 0 0 35%;">
                       <label>
                           <input type="radio" id="provisionYn" name="provisionYn" value="Y" autofocus="autofocus">
                           동의합니다.
                       </label>
                       &nbsp
                       <label>
                           <input type="radio" id="provisionYn" name="provisionYn" value="N" checked>
                           동의하지 않습니다.
                       </label>
                   </div>
               </div>
           </div>
           <br><br>
           <div class="form-group">
               <label for="memberInfo" class="col-lg-3 control-label">개인정보취급방침</label>
               <div class="col-lg-10" id="memberInfo">
                   <textarea class="form-control" rows="8" style="resize:none">개인정보의 항목 및 수집방법
① 이용자는 “안”이 정한 가입 양식에 따라 회원정보를 기입한 후 이 약관에 동의한다는 의사표시를 함으로서 회원가입을 신청합니다
② “안”은 제1항과 같이 회원으로 가입할 것을 신청한 이용자 중 다음 각 호에 해당하지 않는 한 회원으로 등록합니다.

1. 가입신청자가 이 약관 제7조제3항에 의하여 이전에 회원자격을 상실한 적이 있는 경우, 다만 제7조제3항에 의한 회원자격 상실 후 3년이 경과한 자로서 “안”의 회원재가입 승낙을 얻은 경우에는 예외로 한다.
2. 등록 내용에 허위, 기재누락, 오기가 있는 경우
3. 기타 회원으로 등록하는 것이 “안”의 기술상 현저히 지장이 있다고 판단되는 경우

③ 회원가입계약의 성립 시기는 “안”의 승낙이 회원에게 도달한 시점으로 합니다.

④ 회원은 회원가입 시 등록한 사항에 변경이 있는 경우, 상당한 기간 이내에 “안”에 대하여 회원정보 수정 등의 방법으로 그 변경사항을 알려야 합니다.                            
                        </textarea>
                        <br>
                        <div style="padding: 0 0 0 35%;">
                       <label>
                           <input type="radio" id="memberInfoYn" name="memberInfoYn" value="Y">
                           동의합니다.
                       </label>
                       &nbsp
                       <label>
                           <input type="radio" id="memberInfoYn" name="memberInfoYn" value="N" checked>
                           동의하지 않습니다.
                       </label>
                   </div>
                   </div>
                   <br>
               </div>
               <div class="form-group">
                   <div class="col-lg-offset-2 col-lg-10" style="width: 40%; float:none; margin:0 auto">
                       <button type="submit" class="btn text-black" style="width: 200px; 
                       font-weight: bold; color:rgba(248, 250, 228); background-color: rgba(101,131,97)">다 음</button>
                   </div>
               </div>
               <br>
  
<c:import url="/foot" />