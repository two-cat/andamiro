<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">
</head>
<c:import url="/top" />
<script>
	let win;
	function openWin() {
		win = open("idCheck.go", "idCheck",
				"width=400, height=400, left=100,top=100");
	}//------------------------

	function check() {
		if (!mf.name.value) {
			alert('이름을 입력하세요');
			mf.name.focus();
			return;
		}
		if (!mf.userid.value) {
			alert('아이디를 입력하세요');
			mf.userid.focus();
			return;
		}
		if (!mf.pwd.value) {
			alert('비밀번호를 입력하세요');
			mf.pwd.focus();
			return;
		}
		if (mf.pwd.value != mf.pwd2.value) {
			alert('비밀번호가 다릅니다.');
			mf.pwd2.select();
			return;
		}
		if (!mf.hp1.value || !mf.hp2.value || !mf.hp2.value) {
			alert('전화번호를 입력하세요');
			if (!mf.hp1.value) {
				mf.hp1.focus();
			} else if (!mf.hp2.value) {
				mf.hp2.focus();
			} else if (!mf.hp3.value) {
				mf.hp3.focus();
			}
			return;
		}
		if (!mf.addr1.value) {
			alert('주소를 입력하세요');
			mf.addr1.focus();
			return;
		} else if (!mf.addr2.value) {
			alert('주소를 입력하세요');
			mf.addr2.focus();
			return;
		}
		mf.submit(); // 서버에 전송
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

<div id="content">
	<h1 style="text-align: center">마이페이지</h1>
	<c:if test="${user ne null}">
		<form name="mf" action="updateEnd.go" method="post">
			<table class="table" border="1" border-top="1">
				<tr>
					<td class="t1"><b>회원번호</b></td>
					<td class="t2"><input type="text" name="idx"
						value="${user.idx}" placeholder="Idx" readonly class="box">
					</td>
				</tr>
				<tr>
					<td class="t1"><b>이 름</b></td>
					<td class="t2"><input type="text" name="name"
						value="${user.name}" placeholder="Name" class="box"></td>
				</tr>
				<tr>
					<td class="t1"><b>아이디</b></td>
					<td class="t2"><input type="text" name="userid"
						value="${user.userid}" placeholder="user ID" class="box" readonly>
					</td>
				</tr>
				<tr>
					<td class="t1"><b>비밀번호</b></td>
					<td class="t2"><input type="password" name="pwd"
						placeholder="Password" class="box"></td>
				</tr>
				<tr>
					<td class="t1"><b>비밀번호 확인</b></td>
					<td class="t2"><input type="password" name="pwd2"
						placeholder="Password" class="box"></td>
				</tr>
				<tr>
					<td class="t1"><b>연락처</b></td>
					<td class="t2"><input type="text" name="hp1"
						value="${user.hp1}" required maxlength="3" placeholder="HP1"
						class="box sm">- <input type="text" name="hp2"
						value="${user.hp2}" required maxlength="4" placeholder="HP2"
						class="box sm">- <input type="text" name="hp3"
						value="${user.hp3}" required maxlength="4" placeholder="HP3"
						class="box sm"></td>
				</tr>
				<tr>
					<td class="t1"><b>우편번호</b></td>
					<td class="t2"><input type="text" name="zipcode" id="sample6_postcode"
						value="${user.zipcode}" maxlength="5" placeholder="Zipcode"
						class="box">
						<button type="button" class="btn" onclick="sample6_execDaumPostcode()">우편번호 확인</button></td>
				</tr>
				<tr>
					<td class="t1"><b>주소</b></td>
					<td class="t2"><input type="text" name="addr1"
						value="${user.addr1}" id="sample6_address"  placeholder="Address1" class="box lg"
						style="margin-bottom: 5px"> <br> <br> 
						<input type="text" name="addr2" value="${user.addr2}" id="sample6_detailAddress"
						placeholder="상세주소를 입력해주세여" class="box lg">
						<input type="hidden" id="sample6_extraAddress" placeholder="참고항목">
						</td>					
				</tr>

				<tr>
					<td colspan="2" style="text-align: center">
						<button type="button" onclick="check()" class="btn">정보수정</button>
						<button type="reset" class="btn">다시쓰기</button>
					</td>
				</tr>
			</table>
		</form>
	</c:if>
</div>

<c:import url="/foot" />