<%--
  Created by IntelliJ IDEA.
  User: Anduin
  Date: 2019/9/25
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script type="text/javascript" src="../layui/layui.js"></script>
</head>
<body>
    <table class="layui-hide" id="test" lay-filter="test"></table>

    <div hidden="hidden" id="add" style="padding: 25px;">
        <form action="<%=request.getContextPath()%>/user/addUser" method="post">
            <input type="text" class="layui-input" name="name" placeholder="请输入客户名（*必填*）"/>
            <input type="text" class="layui-input" name="pwd" placeholder="请输入客户密码（*必填*）"/>
            <input type="text" class="layui-input" name="phone" placeholder="请输入客户电话"/>
            <input type="text" class="layui-input" name="card" placeholder="请输入身份证号"/>
            <input type="text" class="layui-input" name="provice" placeholder="请输入所在省"/>
            <input type="text" class="layui-input" name="city" placeholder="请输入所在城市"/>
            <input type="text" class="layui-input" name="area" placeholder="请输入所在地区"/>
            <input type="text" class="layui-input" name="address" placeholder="请输入具体地址"/>
            <input type="text" class="layui-input" name="status" placeholder="请输入客户状态"/>
            <input type="text" class="layui-input" name="createuser" placeholder="请输入创建人"/>
            <input type="submit" class="layui-btn" value="提交">
        </form>
    </div>

    <div hidden="hidden" id="edit" style="padding: 25px;">
        <form action="<%=request.getContextPath()%>/user/editUser" method="post">
            <input type="text" class="layui-input" name="uid" id="uid" readonly="readonly"/>
            <input type="text" class="layui-input" name="name" id="name" placeholder="请输入客户名（*必填*）"/>
            <input type="text" class="layui-input" name="phone" id="phone" placeholder="请输入客户电话"/>
            <input type="text" class="layui-input" name="card" id="card" placeholder="请输入身份证号"/>
            <input type="text" class="layui-input" name="provice" id="provice" placeholder="请输入所在省"/>
            <input type="text" class="layui-input" name="city" id="city" placeholder="请输入所在城市"/>
            <input type="text" class="layui-input" name="area" id="area" placeholder="请输入所在地区"/>
            <input type="text" class="layui-input" name="address" id="address" placeholder="请输入具体地址"/>
            <input type="text" class="layui-input" name="status" id="status" placeholder="请输入客户状态"/>
            <input type="text" class="layui-input" name="updateuser" id="updateuser" placeholder="请输入修改人"/>
            <input type="submit" class="layui-btn" value="提交">
        </form>
    </div>
</body>
<script>
    layui.use(['layer','table','laydate'],
        function() {
            var layer = layui.layer;
            var $ = layui.$;
            var table = layui.table;
            var laydate = layui.laydate;

            table.render({
                elem: '#test',
                url: '<%=request.getContextPath()%>/user/list',
                cols: [[
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'uid', width: 60, title: 'ID', sort: true}
                    , {field: 'name', width: 100, title: '用户名'}
                    , {field: 'phone', width: 100, title: '用户电话'}
                    , {field: 'card', width: 120, title: '身份证号'}
                    , {field: 'provice', title: '省份', width: 110}
                    , {field: 'city', width: 100, title: '城市'}
                    , {field: 'area', width: 100, title: '地区'}
                    , {field: 'address', width: 120, title: '地址'}
                    , {field: 'status', width: 80, title: '员工状态'}
                    , {field: 'createtime', width: 100, title: '创建时间'
                        ,templet:'<div>{{layui.util.toDateString(d.createtime,\"yyyy-MM-dd HH:mm:ss\")}}</div>'
                        ,sort:true}
                    , {field: 'createuser', width: 80, title: '创建人'}
                    , {field: 'updatetime', width: 100, title: '修改时间'
                        ,templet:'<div>{{layui.util.toDateString(d.updatetime,\"yyyy-MM-dd HH:mm:ss\")}}</div>'
                        ,sort:true}
                    , {field: 'updateuser', width: 80, title: '修改人'}
                    , {
                        fixed: 'right',
                        title: '操作',
                        width: 120,
                        align: 'center',
                        toolbar: '<div class="layui-btn-group"><button type="button" ' +
                            'class="layui-btn  layui-btn-xs layui-margin" lay-event="edit">编辑</button>' +
                            '<button class="layui-btn layui-btn-danger layui-btn-xs layui-margin" ' +
                            'lay-event="del">删除</button></div>'
                    }
                ]]
                , page: true
                , limit: 10
                , limits: [10, 20, 30]
                , toolbar: '<div class="layui-btn-group"><button type="button" class="layui-btn" ' +
                    'lay-event="add">增加</button></div>'
            });
            table.on('tool(test)', function(obj){
                var data = obj.data;
                if(obj.event === 'del'){
                    layer.confirm('确定删除？', function(index){
                        obj.del();
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/user/delete?uid="+data.uid,
                            success: function(msg){
                                layer.msg(msg);
                            }
                        });
                        layer.close(index);
                    });
                }else if(obj.event === 'edit'){
                    $("#uid").val(data.uid);
                    $("#name").val(data.name);
                    $("#phone").val(data.phone);
                    $("#card").val(data.card);
                    $("#provice").val(data.provice);
                    $("#city").val(data.city);
                    $("#area").val(data.area);
                    $("#address").val(data.address);
                    $("#status").val(data.status);
                    $("#updateuser").val(data.updateuser);
                    layer.open({
                        title: '用户修改',
                        type: 1,
                        area: ['30%','70%'],
                        content: $('#edit')
                    });
                }
            });
            table.on('toolbar(test)', function(obj) {
                var data = obj.data;
                if(obj.event === 'add'){
                    layer.open({
                        type: 1
                        ,title: '创建用户'
                        ,btn: false
                        ,area: ['30%','70%']
                        ,content: $('#add')
                    });
                }
            })
            laydate.render({
                elem: '#date'
                ,type: 'datetime'
                ,format:'yyyy-MM-dd HH:mm:ss'
            });
            laydate.render({
                elem: '#date1'
                ,type: 'datetime'
                ,format:'yyyy-MM-dd HH:mm:ss'
            });
        })
</script>
</html>
