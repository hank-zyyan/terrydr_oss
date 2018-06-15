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
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : prefix + "/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
            console.log(request);
            parent.layer.msg(request.responseJSON.responseMessage);
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
function validate() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			},
            sort : {
                required : true,
                range:[1,99]
            }
		},
		messages : {
			name : {
				required : icon + "请输入菜单名"
			},
            sort : {
                required : icon + "请输入排序",
                range : icon + "排序为2位数字"
            }
		}
	})
}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            name : {
                required : true
            },
            sort : {
                required : true,
                range:[1,99]
            }
        },
        messages : {
            name : {
                required : icon + "请输入菜单名"
            },
            sort : {
                required : icon + "请输入排序",
                range : icon + "排序为2位数字"
            }
        }
    })
}