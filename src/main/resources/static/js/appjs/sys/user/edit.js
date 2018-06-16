$().ready(function() {
    jQuery.validator.addMethod("tel", function(value, element) {
        var length = value.length;
        var regPhone = /^1([3578]\d|4[57])\d{8}$/;
        return this.optional(element) || ( length == 11 && regPhone.test( value ) );
    }, "请正确填写您的手机号码");
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/platform/user/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg(data.responseMessage);
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.msg(data.responseMessage);
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
            userRealName : {
                required : true
            },
            userTel : {
                required : true,
                tel : true
            },
            userEmail : {
                required : true,
                email : true
            }
		},
		messages : {

            userRealName : {
                required : icon + "请输入姓名"
            },
            userTel : {
                required : icon + "请输入手机号码",
                tel : icon + "请输入正确的手机号码"
            },
            userEmail : {
                required : icon + "请输入您的E-mail",
                email : icon + "请输入正确的E-mail"
            }
		}
	})
}