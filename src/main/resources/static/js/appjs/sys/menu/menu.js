var prefix = "/platform/menu"
$(document).ready(function () {
    load();
});
var load = function () {
    $('#exampleTable')
        .bootstrapTreeTable(
            {
                id: 'id',
                code: 'id',
                parentCode: 'parentMenuId',
                type: "GET", // 请求数据的ajax类型
                url: prefix + '/list', // 请求数据的ajax的url
                ajaxParams: {sort:'order_num'}, // 请求数据的ajax的data属性
                expandColumn: '1',// 在哪一列上面显示展开按钮
                striped: true, // 是否各行渐变色
                bordered: true, // 是否显示边框
                expandAll: false, // 是否全部展开
                // toolbar : '#exampleToolbar',
                columns: [
                    {
                        title: '编号',
                        field: 'id',
                        visible: false,
                        align: 'center',
                        valign: 'center',
                        width: '5%'
                    },
                    {
                        title: '名称',
                        valign: 'center',
                        field: 'menuName',
                    },
                    {
                        title: '图标',
                        field: 'style',
                        align: 'center',
                        valign: 'center',
                        width : '5%',
                        formatter: function (item, index) {
                            return item.style == null ? ''
                                : '<i class="' + item.style
                                + ' fa-lg"></i>';
                        }
                    },
                    {
                        title: '地址',
                        valign: 'center',
                        field: 'menuUrl'
                    },
                    {
                        field : 'status',
                        title : '状态',
                        width : '10%',
                        align : 'center',
                        formatter : function(item, index) {
                            if (item.status == 0) {
                                return '<span class="label label-danger">禁用</span>';
                            } else if (item.status == 1) {
                                return '<span class="label label-primary">正常</span>';
                            }
                        }
                    },
                    {
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        valign: 'center',
                        formatter: function (item, index) {
                            var e = '<a class="btn btn-primary btn-sm '
                                + s_edit_h
                                + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + item.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var p = '<a class="btn btn-primary btn-sm '
                                + s_add_h
                                + '" href="#" mce_href="#" title="添加下级" onclick="add(\''
                                + item.id
                                + '\')"><i class="fa fa-plus"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm '
                                + s_remove_h
                                + '" href="#" title="启用"  mce_href="#" onclick="start(\''
                                + item.id
                                + '\')"><i class="fa fa-check"></i></a> ';
                            var t = '<a class="btn btn-warning btn-sm '
                                + s_remove_h
                                + '" href="#" title="禁用"  mce_href="#" onclick="remove(\''
                                + item.id
                                + '\')"><i class="fa fa-ban"></i></a> ';
                            return p + e + d + t;
                        }
                    }]
            });
}

function reLoad() {
    load();
}

function add(pId) {
    layer.open({
        type: 2,
        title: '增加菜单',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/add/' + pId // iframe的url
    });
}

function remove(id) {
    layer.confirm('确定要禁用选中的菜单？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/remove",
            type: "post",
            data: {
                'id': id
            },
            success: function (data) {
                if (data.code == 0) {
                    layer.msg(data.responseMessage);
                    reLoad();
                } else {
                    layer.msg(data.responseMessage);
                }
            }
        });
    })
}

function start(id) {
    layer.confirm('确定要启用选中的菜单？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/start",
            type: "post",
            data: {
                'id': id
            },
            success: function (data) {
                if (data.code == 0) {
                    layer.msg(data.responseMessage);
                    reLoad();
                } else {
                    layer.msg(data.responseMessage);
                }
            }
        });
    })
}

function edit(id) {
    layer.open({
        type: 2,
        title: '菜单修改',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id // iframe的url
    });
}

function batchRemove() {
    // var rows = $('#exampleTable').bootstrapTable('getSelections');

}