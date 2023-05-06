// sendEmailcode 이메일 인증 함수 작성하기
/*
Redis 사용해서 인증코드를 외부 저장소에 저장하고
이메일 주소를 키로 사용하는 인증코드를 값으로 설정한 후
ConfirmEmailCode 와 비교
*/



name
phone
postcode
roadAddress
jibunAddress
detailAddress
extraAddress

// 이미 존재하는 회원의 이메일인지 확인하기
function validateEmail(){
    var email = document.getElementsByName("email").value;
    var checkEmail = document.getElementById("checkEmail").value;

    $.ajax({
        type : "post",
        url : "/validateEmail",
        data : {"email" : email},
        success : function(res){
            console.log("요청 성공 : " , res);
            // 사용가능한 이메일입니다. / 이미 존재하는 회원의 이메일입니다. span태그 안에 표시
            if (res == "ok") {
                checkEmail.style.color = "green";
                checkEmail.innerHTML="사용가능한 이메일입니다.";
            } else {
                console.log("이미 사용중인 이메일입니다.");
                checkEmail.style.color = "red";
                checkEmail.innerHTML="이미 사용중인 이메일입니다.";
            }
        },
        error : function(err){
            console.log("에러발생: ",err);
            }
    })
}


// pw와 pw확인이 같은값인지 확인하기
password
ConfirmPassword
// 비밀번호가 일치합니다. / 비밀번호가 일지하지 않습니다. span태그 안에 표시
// 빈칸은 없는지 확인 / 빈칸이 있다면 focus



