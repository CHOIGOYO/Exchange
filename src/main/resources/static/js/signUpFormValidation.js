// sendEmailcode 이메일 인증 함수 작성하기
/*
Redis 사용해서 인증코드를 외부 저장소에 저장하고
이메일 주소를 키로 사용하는 인증코드를 값으로 설정한 후
ConfirmEmailCode 와 비교
*/



// 이미 존재하는 회원의 이메일인지 확인하기
function validateEmail(){
    var email = document.getElementsByName("email")[0].value;
    var email11 = document.getElementsByName("email")[0];
    var checkEmail = document.getElementById("checkEmail");

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
// 비밀번호가 일치합니다. / 비밀번호가 일지하지 않습니다. span태그 안에 표시
function checkPasswordConfirmation(){
    var password = document.getElementsByName("password")[0].value;
    var password11 = document.getElementsByName("password")[0];
    var confirmPassword = document.getElementsByName("confirmPassword")[0].value;
    var passwordChack = document.getElementById("passwordChack");
    if (password !== confirmPassword ) {
        alert("비밀번호가 일치하지 않습니다.");
    } else {
        passwordChack.style.color = "green";
        passwordChack.innerHTML = "비밀번호가 일치합니다.";
    }
}

// 빈칸은 없는지 확인 / 빈칸이 있다면 focus
function signUpFormValidation(event) {
    event.preventDefault(); // 폼 제출 막기
  
    var email = document.getElementsByName("email")[0];
    var confirmEmailCode = document.getElementsByName("ConfirmEmailCode")[0];
    var password = document.getElementsByName("password")[0];
    var confirmPassword = document.getElementsByName("confirmPassword")[0];
    var name = document.getElementsByName("name")[0];
    var phone = document.getElementsByName("phone")[0];
    var postcode = document.getElementsByName("postcode")[0];
    var roadAddress = document.getElementsByName("roadAddress")[0];
    var jibunAddress = document.getElementsByName("jibunAddress")[0];
    var detailAddress = document.getElementsByName("detailAddress")[0];
    var extraAddress = document.getElementsByName("extraAddress")[0];
  
    var checkEmail = document.getElementById("checkEmail");
    var passwordChack = document.getElementById("passwordChack");
  
    // 이메일 유효성 검사
    if (email.value.trim() === '') {
      alert("이메일을 입력해주세요.");
      email.focus();
      return;
    }
  
    // 이메일 인증번호 유효성 검사
    if (confirmEmailCode.value.trim() === '') {
      alert("이메일 인증번호를 입력해주세요.");
      confirmEmailCode.focus();
      return;
    }
  
    // 비밀번호 유효성 검사
    if (password.value.trim() === '') {
      alert("비밀번호를 입력해주세요.");
      password.focus();
      return;
    }
  
    // 비밀번호 확인 유효성 검사
    if (confirmPassword.value.trim() === '') {
      alert("비밀번호 확인을 입력해주세요.");
      confirmPassword.focus();
      return;
    }
  
    // 비밀번호와 비밀번호 확인 일치 여부 검사
    if (password.value !== confirmPassword.value) {
      alert("비밀번호가 일치하지 않습니다.");
      confirmPassword.focus();
      return;
    }
  
    // 이름 유효성 검사
    if (name.value.trim() === '') {
      alert("이름을 입력해주세요.");
      name.focus();
      return;
    }
  
    // 전화번호 유효성 검사
    if (phone.value.trim() === '') {
      alert("전화번호를 입력해주세요.");
      phone.focus();
      return;
    }
  
    // 주소 유효성 검사
    if (postcode.value.trim() === '' || roadAddress.value.trim() === '' || jibunAddress.value.trim() === '' || detailAddress.value.trim() === '') {
      alert("주소를 입력해주세요.");
      postcode.focus();
      return;
    }
  
    // 모든 유효성 검사를 통과하면 폼 제출
    document.getElementById("signUp").submit();
  }
  
  function sendEmailcode() {
    const email = document.getElementById("email").value;
    $.ajax({
      type:"post",
      url:"/signup/send-code",
      data: JSON.stringify({email:email}),
      dataType : "json",
      success : function(data){
        if (data.success) {
          alert("인증번호가 전송되었습니다.");
        } else{
          alert("인증번호 전송 실패. 다시 시도해주세요.");
        }
      },
      error : function(error){
        console.error("Error", error);
        alert("인증번호 전송 실패. 다시 시도해주세요.");
      }
    })
  }

  function confirmEmailcode(){

  }

