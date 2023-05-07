// pw와 pw확인이 같은값인지 확인하기
/*
password
ConfirmPassword
passwordChack
*/
// 비밀번호가 일치합니다. / 비밀번호가 일지하지 않습니다. span태그 안에 표시
function confirmPassword(){
    var password = document.getElementsByName("password")[0].value;
    var confirmPassword = document.getElementsByName("confirmPassword")[0].value;
    var passwordChack = document.getElementById("passwordChack");
    if (password !== confirmPassword ) {
        alert("비밀번호가 일치하지 않습니다.");
        confirmPassword.focus();
    } else {
        passwordChack.style.color = "green";
        passwordChack.innerHTML = "비밀번호가 일치합니다.";
    }
}