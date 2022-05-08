<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/top" />

	<!-- Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
    <script src="http://code.jquery.com/jquery.js"></script>
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    
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
            //테스트할 때 주의)아래는 alert을 보여주는 대신 잘못된 것을 입력하면 아예 입력이 안되는 차단 기능이다.
            $(function(){
                //모달을 전역변수로 선언
            	 var modalContents = $(".modal-contents");
                 var modal = $("#defaultModal");
                         
                 $('.onlyAlphabetAndNumber').keyup(function(event){
                     if (!(event.keyCode >=37 && event.keyCode<=40)) {
                         var inputVal = $(this).val();
                         $(this).val($(this).val().replace(/[^_a-z0-9]{6,20}/gi,'')); //_(underscore), 영어, 숫자만 가능
                     }
                 });
                 
                 $(".onlyHangul").keyup(function(event){
                     if (!(event.keyCode >=37 && event.keyCode<=40)) {
                         var inputVal = $(this).val();
                         $(this).val(inputVal.replace(/[a-z0-9]/gi,''));
                     }
                 });
             
                 $(".onlyNumber").keyup(function(event){
                     if (!(event.keyCode >=37 && event.keyCode<=40)) {
                         var inputVal = $(this).val();
                         $(this).val(inputVal.replace(/[^0-9]/gi,''));
                     }
                 });
                 
                 //------- 검사하여 상태를 class에 적용
                 $('#id').keyup(function(event){
                     
                     var divId = $('#divId');
                     
                     if($('#id').val()==""){
                         divId.removeClass("has-success");
                         divId.addClass("has-error");
                     }else{
                         divId.removeClass("has-error");
                         divId.addClass("has-success");
                     }
                 });
                 
                 $('#password').keyup(function(event){
                     
                     var divPassword = $('#divPassword');
                     
                     if($('#password').val()==""){
                         divPassword.removeClass("has-success");
                         divPassword.addClass("has-error");
                     }else{
                         divPassword.removeClass("has-error");
                         divPassword.addClass("has-success");
                     }
                 });
                 
                 $('#passwordCheck').keyup(function(event){
                     
                     var passwordCheck = $('#passwordCheck').val();
                     var password = $('#password').val();
                     var divPasswordCheck = $('#divPasswordCheck');
                     
                     if((passwordCheck=="") || (password!=passwordCheck)){
                         divPasswordCheck.removeClass("has-success");
                         divPasswordCheck.addClass("has-error");
                     }else{
                         divPasswordCheck.removeClass("has-error");
                         divPasswordCheck.addClass("has-success");
                     }
                 });
                 
                 $('#name').keyup(function(event){
                     
                     var divName = $('#divName');
                     
                     if($.trim($('#name').val())==""){
                         divName.removeClass("has-success");
                         divName.addClass("has-error");
                     }else{
                         divName.removeClass("has-error");
                         divName.addClass("has-success");
                     }
                 });
                 
                 //------- validation 검사
                 $( "form" ).submit(function( event ) {
                     

                     var divId = $('#divId');
                     var divPassword = $('#divPassword');
                     var divPasswordCheck = $('#divPasswordCheck');
                     
                     //아이디 검사
                     if($('#id').val()==""){
                         modalContents.text("아이디를 입력하여 주시기 바랍니다.");
                         modal.modal('show');
                         
                         divId.removeClass("has-success");
                         divId.addClass("has-error");
                         $('#id').focus();
                         return false;
                     }else{
                         divId.removeClass("has-error");
                         divId.addClass("has-success");
                     }
                     
                     //패스워드 검사
                     if($('#password').val()==""){
                         modalContents.text("패스워드를 입력하여 주시기 바랍니다.");
                         modal.modal('show');
                         
                         divPassword.removeClass("has-success");
                         divPassword.addClass("has-error");
                         $('#password').focus();
                         return false;
                     }else{
                         divPassword.removeClass("has-error");
                         divPassword.addClass("has-success");
                     }
                     
                     //패스워드 확인
                     if($('#passwordCheck').val()==""){
                         modalContents.text("패스워드 확인을 입력하여 주시기 바랍니다.");
                         modal.modal('show');
                         
                         divPasswordCheck.removeClass("has-success");
                         divPasswordCheck.addClass("has-error");
                         $('#passwordCheck').focus();
                         return false;
                     }else{
                         divPasswordCheck.removeClass("has-error");
                         divPasswordCheck.addClass("has-success");
                     }
                     
                     //패스워드 비교
                     if($('#password').val()!=$('#passwordCheck').val() || $('#passwordCheck').val()==""){
                         modalContents.text("패스워드가 일치하지 않습니다.");
                         modal.modal('show');
                         
                         divPasswordCheck.removeClass("has-success");
                         divPasswordCheck.addClass("has-error");
                         $('#passwordCheck').focus();
                         return false;
                     }else{
                         divPasswordCheck.removeClass("has-error");
                         divPasswordCheck.addClass("has-success");
                     }
            });
            });
 
                
            </script>
    
    
    <script>
	let win;
	function openWin(){
		win = open("${pageContext.request.contextPath}/idCheck", "idCheck", "width=400, height=400, left=200, top=100");
	}//----------------------------

	function check(){
		if(!sf.name.value){
			alert('이름을 입력하세요');
			sf.name.focus();
			return;
		}
		if(!sf.userid.value){
			alert('아이디를 입력하세요');
			sf.userid.focus();
			return;
		}
		if(!sf.pwd.value){
			alert('비밀번호를 입력하세요');
			sf.pwd.focus();
			return;
		}
		if(sf.pwd.value != sf.pwd2.value){
			alert('비밀번호와 비밀번호 확인이 일치하지 않습니다');
			sf.pwd2.select();
			return;
		}
		
		sf.submit(); // 서버로 전송
	}
</script>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").value='';
            }
        }).open();
    }
</script>
    
        
		 <div class="container" style="padding: 5% 0 0 10%">
        <h3>안다미로 회원가입</h3><br><br><br>
        <h5 style="text-decoration: solid;">회원정보</h5>
       <hr style="border: solid 1px black;">
        <br>
        
        <form name = "sf" method = "post" action="signup">
            <div class="form-group" id="divId">
                <label for="inputId" class="col-lg-2 control-label">아이디</label><br>
            
                <div class="col-lg-10" style="float: left; width: 60%">
                    <input type="text" name = "userid" id="id" 
                    class="form-control onlyAlphabetAndNumber" data-rule-required="true" placeholder="영어 또는 숫자로 6~20자리로 입력해주세요." maxlength="20">
                </div>  
                    <div style="float: left; width: 33%">
                    <label style="width: 30%">
                    <button type = "button" class ="btn" onclick = "openWin()"
                    style="width: 150px; font-weight: bold; color:rgba(248, 250, 228); background-color: rgba(101,131,97)">아이디 중복체크</button>
                </label>
                </div>
                </div>
        
                <br><div class="form-group" id="divPassword">
            <label for="inputPassword" class="col-lg-2 control-label">비밀번호</label>
            <div class="col-lg-10">
                <input type="password" class="form-control onlyAlphabetAndNumber" id="password" 
                name ="pwd" data-rule-required="true" placeholder="영문, 숫자 조합 6~20자리로 입력해주세요." maxlength="20">
            </div>
        </div>
        <div class="form-group" id="divPasswordCheck">
            <label for="inputPasswordCheck" class="col-lg-2 control-label">비밀번호 확인</label>
            <div class="col-lg-10">
                <input type="password" class="form-control" 
                id="passwordCheck" name = "pwd2" data-rule-required="true" placeholder="입력하신 비밀번호를 한 번 더 입력해주세요." maxlength="20">
            </div>
        </div>
        <div class="form-group" id="divName">
            <label for="inputName" class="col-lg-2 control-label">이름</label>
            <div class="col-lg-10">
                <input type="text" class="form-control onlyHangul" 
                id="name" name = "name" data-rule-required="true" placeholder="한글만 입력 가능합니다." maxlength="10">
            </div>
        </div>                

        <div class="form-group" id="address">
            <label for="inputAddress" class="col-lg-2 control-label">우편번호</label>
            <br>
            
            <div class="col-lg-10" style="float: left; width: 60%">
                <input type="text" class="form-control" 
                name="zipcode" id="sample6_postcode" value="${user.zipcode}"
                data-rule-required="true" maxlength="15">
            </div>
            <div style="float: left; width: 33%">
                <label style="width: 30%">
                    <button type="button" class="btn text-black" 
                    style="width: 150px; font-weight: bold;
                    color:rgba(248, 250, 228); background-color: rgba(101,131,97)"
                    onclick="sample6_execDaumPostcode()"><span>우편번호 확인</span></button>
                    </label>
            </div>

        </div>

        <div class="form-group">
            <label for="inputAddress" class="col-lg-2 control-label">주소</label>
            <br>
            
             <div class="col-lg-10">
                <input type="text" class="form-control" 
                name="addr1" value="${user.addr1}" id="sample6_address"  
                data-rule-required="true" placeholder="" maxlength="15">
            </div>
            
            <div class="col-lg-10">
                <input type="text" class="form-control" 
                name="addr2" value="${user.addr2}" id="sample6_detailAddress"
                data-rule-required="true" placeholder="주소를 입력해주세요." maxlength="15">
            </div>
            <div>
            <input type="hidden" id="sample6_extraAddress" placeholder="참고항목">
            </div>
        </div>

        <div class="form-group" id="divPhoneNumber">
            <label for="inputPhoneNumber" class="col-lg-2 control-label">휴대폰 번호</label>
            <br>
            <div class="col-lg-2" style="float: left; width: 35%">
                <input type="tel" class="form-control onlyNumber" name ="hp1" id="phoneNumber" data-rule-required="true" placeholder="010" maxlength="3">
            </div>
            <div style="float: left">-</div>
            <div class="col-lg-2" style="float: left; width: 35%">
                <input type="tel" class="form-control onlyNumber" name ="hp2" id="phoneNumber" data-rule-required="true" placeholder="1234" maxlength="4">
            </div>
            <div style="float: left">-</div>
            <div class="col-lg-2" style="float: left; width: 35%">
                <input type="tel" class="form-control onlyNumber" name ="hp3" id="phoneNumber" data-rule-required="true" placeholder="5678" maxlength="4">
            </div>
        </div>
        <br><br>


        <div class="form-group" id="divEmail">
            <label for="inputEmail" class="col-lg-2 control-label">이메일</label>
            <div class="col-lg-10">
                <input type="email" class="form-control" id="email" data-rule-required="true" placeholder="자주 사용하시는 이메일 주소를 입력해주세요." maxlength="40">
            </div>
        </div>
        <br>

 
        <div class="form-group">
            <label for="inputEmailReceiveYn" class="col-lg-3 control-label">이메일 수신여부</label>
            <div class="col-lg-10">
                <label class="radio-inline">
                    <input type="radio" id="emailReceiveYn" name="emailReceiveYn" value="Y" checked> 동의합니다.
                </label>
                &nbsp
                <label class="radio-inline">
                    <input type="radio" id="emailReceiveYn" name="emailReceiveYn" value="N"> 동의하지 않습니다.
                </label>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPhoneNumber" class="col-lg-2 control-label">SMS 수신여부</label>
            <div class="col-lg-10">
                <label class="radio-inline">
                    <input type="radio" id="smsReceiveYn" name="smsReceiveYn" value="Y" checked> 동의합니다.
                </label>
                &nbsp
                <label class="radio-inline">
                    <input type="radio" id="smsReceiveYn" name="smsReceiveYn" value="N"> 동의하지 않습니다.
                </label>
            </div>
        </div>
        <br>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10" style="width: 35%; float:none; margin:0 auto">
              <!--  <button type="submit" style="width: 200px"class="btn btn-success">가입하기</button> -->
                <button type="button" onclick="check()"
                class="btn text-black" style="width: 200px; 
                font-weight: bold; color:rgba(248, 250, 228); background-color: rgba(101,131,97)">가입하기</button>
            </div>
        </div>
        </form>
    </div>
    <br><br><br>
            
     <!-- ===============================  -->
<c:import url="/foot"/>