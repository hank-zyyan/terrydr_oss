var prefix = "/eye/customer";
var beginTimeStore;
var endTimeStore;
$(function() {
	load();
    datePicker();
});

function load() {
	$('#exampleTable')
		.bootstrapTable(
			{
				method : 'get', // 服务器数据的请求方式 get or post
				url : prefix + "/list", // 服务器数据的加载地址
				// showRefresh : true,
				// showToggle : true,
				// showColumns : true,
				iconSize : 'outline',
				toolbar : '#exampleToolbar',
				striped : true, // 设置为true会有隔行变色效果
				dataType : "json", // 服务器返回的数据类型
				pagination : true, // 设置为true会在底部显示分页条
				// queryParamsType : "limit",
				// //设置为limit则会发送符合RESTFull格式的参数
				//singleSelect : false,
				// 设置为true将禁止多选
				// contentType : "application/x-www-form-urlencoded",
				// //发送到服务器的数据编码类型
				pageSize : 10, // 如果设置了分页，每页数据条数
				pageNumber : 1, // 如果设置了分布，首页页码
				// search : true, // 是否显示搜索框
				showColumns : false, // 是否显示内容下拉框（选择显示的列）
				sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
				// "server"
				queryParams : function(params) {
					return {
						// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
						limit : params.limit,
						offset : params.offset,
                        nameLike : $('#searchName').val(),
                        telenoLike : $('#searchTel').val(),
                        idCardLike : $('#searchID').val(),
                        medicalCardIdLike : $('#searchMC').val(),
                        doctorNameLike : $('#searchDN').val(),
                        isDelete : $('#isDelete').val(),
						beginDate : beginTimeStore,
                        endDate : endTimeStore
					};
				},
				// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
				// queryParamsType = 'limit' ,返回参数必须包含
				// limit, offset, search, sort, order 否则, 需要包含:
				// pageSize, pageNumber, searchText, sortName,
				// sortOrder.
				// 返回false将会终止请求
				columns : [
					{
						field : 'id', // 列字段名
						title : '序号',// 列标题
                        align: 'center',
                        valign: 'center',
                        width: '5%'
					},
					{
						field : 'name',
						title : '姓名'
					},
                    {
                        field : 'teleno',
                        title : '手机'
                    },
                    {
                        field : 'idCard',
                        title : '身份证'
                    },
					{
						field : 'medicalCardId',
						title : '就医卡'
					},
					{
						field : 'medicalCardType',
						title : '就医卡类型',
						align : 'center',
						formatter : function(value, row, index) {
							if (value == '1') {
								return '<span class="label label-danger">医保卡</span>';
							} else if (value == '2') {
								return '<span class="label label-primary">本院就诊卡</span>';
							}
						}
					},
                    {
                        field : 'doctorName',
                        title : '医生'
                    },
                    {
                        field : 'hospitalName',
                        title : '医院'
                    },
                    {
                        field : 'createTime',
                        title : '创建时间',
                        //获取日期列的值进行转换
                        formatter: function (value, row, index) {
                            return changeDateFormat(value)
                        }
                    },
					{
						title : '操作',
						field : 'id',
						align : 'center',
						formatter : function(value, row, index) {
							var e = '<a  class="btn btn-primary btn-sm" href="#" mce_href="#" title="查看详情" onclick="detail(\''
								+ row.id
								+ '\')"><i class="fa fa-align-justify"></i></a> ';
							return e;
						}
					} ]
			});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
//转换日期格式(时间戳转换为datetime格式)
function changeDateFormat(cellval) {
    if (cellval != null) {
        var date = new Date(cellval);
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();

        var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

        return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
    }
}
function datePicker() {
    $('#date_range').daterangepicker({
        "timePicker": true,
        "timePicker24Hour": true,
        "linkedCalendars": false,
        "autoUpdateInput": false,
        "locale": {
            format: 'YYYY-MM-DD',
            separator: ' ~ ',
            applyLabel: "确定",
            cancelLabel: "清空",
            "weekLabel": "W",
            "daysOfWeek": ["日", "一", "二", "三", "四", "五", "六"],
            "monthNames": ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]
        }
    }, function(start, end, label) {
        beginTimeStore = this.startDate.format(this.locale.format);
        endTimeStore = this.endDate.format(this.locale.format);
        console.log(this.startDate.format(this.locale.format));
        console.log(this.endDate.format(this.locale.format));
        if(!this.startDate){
            this.element.val('');
        }else{
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });

    //清空事件
    $('#date_range').on('cancel.daterangepicker',function(ev, picker) {
        $('#date_range').val('');
        beginTimeStore = '';
        endTimeStore = '';
    });
}

function detail(id) {
	layer.open({
		type : 2,
		title : '客户详情',
		maxmin : true,
		shadeClose : false,
		area : ['80%'],
		content : prefix + '/' + id // iframe的url
	});
}