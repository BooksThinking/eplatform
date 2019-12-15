$.ajax({
    type : "POST",
    contentType : "application/json",
    url : "ToHistoryServlet?sendPerson=" + SendPerson + "¤tTime="
        + currentTime() + "&message=" + message + "&recvPerson="
        + recvPerson,
    dataType : 'json',
    success : function(result) {
        alert(result.d);
    }
});