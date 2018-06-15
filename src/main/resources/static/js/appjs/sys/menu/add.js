var prefix = "/platform/menu"
$(function() {
	validateRule();
	//打开图标列表
    $("#ico-btn").click(function(){
        layer.open({
            type: 2,
			title:'图标列表',
            content: '/FontIcoList.html',
            area: ['480px', '90%'],
            success: function(layero, index){
                //var body = layer.getChildFrame('.ico-list', index);
                //console.log(layero, index);
            }
        });
    });
});
$.validator.setDefaults({
	submitHandler : function() {
		submit01();
	}
});
function submit01() {
	$.ajax({
		cache : true,
		type : "POST",
		url : prefix + "/save",
		data : $('#signupForm').serialize(),
		async : false,
		error : function(data) {
            parent.layer.msg(data.responseJSON.responseMessage);
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg(data.responseMessage);
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);
			} else {
				layer.alert(data.responseMessage)
			}
		}
	});
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
            menuName : {
				required : true
			},
            sort : {
                required : true,
                range:[1,99]
            }
		},
		messages : {
            menuName : {
				required : icon + "请输入菜单名"
			},
            sort : {
                required : icon + "请输入排序",
                range : icon + "排序为2位数字"
            }
		}
	})
}