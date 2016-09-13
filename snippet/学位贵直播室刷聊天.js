for (var i = 0; i < 1000; i++) {
  $('#chatarea').html('qiqi '+i)
  $("[name='toward']").val('submitChat')
  sendType()
}

var i = 0;
function send() {
  i++;
  $('#chatarea').html('qiqi '+i)
  $("[name='toward']").val('submitChat')
  sendType()
}
setInterval("send()",1000)

setTimeout("send()",1000)
