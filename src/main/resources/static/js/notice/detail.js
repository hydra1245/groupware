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
function goUpdate() {
    if(confirm("해당 공지사항을 수정하시겠습니까?")) {
        $('#inputTitle').removeAttr("readonly");
        $('#inputContent').removeAttr("readonly");
        $('#updateBtn').show();
        $('#updateCancel').show();

        $('#goUpdate').hide();
        $('#deleteBtn').hide();
    }
}

function goDetail() {
    if(confirm("수정을 취소하시겠습니까?")) {
        $('#inputTitle').val(orgTitle);
        $('#inputContent').val(orgContent);
        $('#inputTitle').attr("readonly","readonly");
        $('#inputContent').attr("readonly","readonly");
        $('#updateBtn').hide();
        $('#updateCancel').hide();

        $('#goUpdate').show();
        $('#deleteBtn').show();
    }
}

function noticeUpdate() {
    if($('#inputTitle').val() == "") {
        alert("제목을 입력하세요.");
        return;
    }
    if($('#inputContent').val() == "") {
        alert("내용을 입력하세요.");
        return;
    }

    var data = {
        title : $('#inputTitle').val()
        ,content : $('#inputContent').val()
    };

    $.ajax({
        type : "POST"
        ,url : "/notice/update/" + noticeId
        ,data : JSON.stringify(data)
        ,contentType : "application/json"
        ,dataType : "text"
        ,success : function(data) {
            if(data == "Y") {
                alert("수정에 성공 했습니다.");
                location.href="/notice/list";
            }
            else {
                alert("수정에 실패했습니다.");
            }
        }
        ,error : function() {
            alert("수정 요청 중 오류가 발생하였습니다.");
        }
    })

}