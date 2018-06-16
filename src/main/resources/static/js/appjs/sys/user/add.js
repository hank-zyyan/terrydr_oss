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
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/platform/user/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg(data.responseMessage);
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.responseMessage)
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
            userName : {
				required : true,
				minlength : 2,
				remote : {
					url : "/platform/user/exist", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : { // 要传递的数据
                        userName : function() {
							return $("#userName").val();
						}
					}
				}
			},
            userPwd : {
				required : true,
				minlength : 6
			},
			confirm_password : {
				required : true,
				minlength : 6,
				equalTo : "#userPwd"
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
            userName : {
				required : icon + "请输入您的用户名",
				minlength : icon + "用户名必须两个字符以上",
				remote : icon + "用户名已经存在"
			},
            userPwd : {
				required : icon + "请输入您的密码",
				minlength : icon + "密码必须6个字符以上"
			},
			confirm_password : {
				required : icon + "请再次输入密码",
				minlength : icon + "密码必须6个字符以上",
				equalTo : icon + "两次输入的密码不一致"
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