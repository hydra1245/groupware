$(document).ready(function() {

});
function freeBoardRegist() {
    if($('#inputTitle').val() == "") {
        alert("제목을 입력하세요.");
        return;
    }
    if($('#inputContent').val() == "") {
        alert("내용을 입력하세요.");
        return;
    }

    $('#registForm').submit();

}