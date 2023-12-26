function noticeDelete() {
    if(confirm("해당 공지 사항을 정말 삭제하시겠습니까?")) {
        $.ajax({
                 type: "GET",
                 url : "/notice/delete/" + noticeId,
                 dataType : "text",
                 success : function(data) {
                    if(data == "Y") {

                         alert("삭제가 완료 되었습니다.");
                         location.href="/notice/list";
                    }
                    else
                    {
                         alert("삭제에 실패 했습니다.");

                    }
                }
        });
    }
}