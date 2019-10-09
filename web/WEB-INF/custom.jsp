<%--
  Created by IntelliJ IDEA.
  User: Anduin
  Date: 2019/9/20
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <script type="text/javascript" src="../layui/layui.js"></script>
</head>
<body>
    <table class="layui-hide" id="test" lay-filter="test"></table>

    <div hidden="hidden" id="lhf" style="padding: 25px;">
        <form action="<%=request.getContextPath()%>/custom/addCustom" method="post">
            <input type="text" class="layui-input" name="cname" placeholder="请输入客户名称"/>
            <input type="text" class="layui-input" name="crealname" placeholder="请输入客户全称"/>
            <input type="text" class="layui-input" name="caddress" placeholder="请输入客户地址"/>
            <input type="text" class="layui-input" name="cfax" placeholder="请输入客户传真"/>
            <input type="text" class="layui-input" name="cemail" placeholder="请输入客户邮箱"/>
            <input type="text" class="layui-input" name="cadmin" placeholder="请输入客户经理"/>
            <input type="text" class="layui-input" name="cphone" placeholder="请输入客户电话"/>
            <input type="text" class="layui-input" name="cps" placeholder="请输入备注"/>
            <input type="submit" class="layui-btn" value="提交">
        </form>
    </div>
    <div hidden="hidden" id="editcustom" style="padding: 25px;">
        <form action="<%=request.getContextPath()%>/custom/editCustom" method="post">
            <input type="text" class="layui-input" name="cid" id="cid" readonly ="readonly"/>
            <input type="text" class="layui-input" name="cname" id="cname" placeholder="请输入客户名称"/>
            <input type="text" class="layui-input" name="crealname" id="crealname" placeholder="请输入客户全称"/>
            <input type="text" class="layui-input" name="caddress" id="caddress" placeholder="请输入客户地址"/>
            <input type="text" class="layui-input" name="cfax" id="cfax" placeholder="请输入客户传真"/>
            <input type="text" class="layui-input" name="cemail" id="cemail" placeholder="请输入客户邮箱"/>
            <input type="text" class="layui-input" name="cadmin" id="cadmin" placeholder="请输入客户经理"/>
            <input type="text" class="layui-input" name="cphone" id="cphone" placeholder="请输入客户电话"/>
            <input type="text" class="layui-input" name="cps" id="cps" placeholder="请输入备注"/>
            <input type="submit" class="layui-btn" value="提交">
        </form>
    </div>
</body>
<script>
    layui.use(['layer','table'],
        function() {
            var layer = layui.layer;
            var $ = layui.$;
            var table = layui.table;
            table.render({
                elem: '#test'
                ,url:'<%=request.getContextPath()%>/custom/list'
                ,cols: [[
                    {type:'checkbox', fixed: 'left'}
                    ,{field:'cid', width:60, title: 'ID', sort: true}
                    ,{field:'cname', width:100, title: '客户名'}
                    ,{field:'crealname', width:150, title: '客户全称'}
                    ,{field:'caddress', width:120, title: '地址'}
                    ,{field:'cfax', title: '传真', width: 110}
                    ,{field:'cemail', width:130, title: '邮箱'}
                    ,{field:'cadmin', width:100, title: '经理'}
                    ,{field:'cphone', width:120, title: '电话'}
                    ,{field:'cstate', width:100, title: '客户状态'}
                    ,{field:'cps', width:80, title: '备注'}
                    ,{fixed: 'right'
                        ,title:'操作', width:180, align:'center'
                        , toolbar: '<div class="layui-btn-group"><button type="button" class="layui-btn  ' +
                            'layui-btn-xs layui-margin" lay-event="edit">编辑</button><button class="layui-btn ' +
                            'layui-btn-danger layui-btn-xs layui-margin" lay-event="del">删除</button></div>'}
                ]]
                ,page: true
                ,limit:10
                ,limits: [10, 20, 30]
                ,toolbar:'<div class="layui-btn-group"><button type="button" class="layui-btn" ' +
                    'lay-event="add">增加</button></div>'
            });


            table.on('tool(test)', function(obj){
                var data = obj.data;
                if(obj.event === 'del'){
                    layer.confirm('确定删除？', function(index){
                        obj.del();
                        $.ajax({
                            type: "POST",
                            url: "<%=request.getContextPath()%>/custom/delete?cid="+data.cid,
                            success: function(msg){
                                layer.msg(msg);
                            }
                        });
                        layer.close(index);
                    });
                } else if(obj.event === 'edit'){
                    $("#cid").val(data.cid);
                    $("#cname").val(data.cname);
                    $("#crealname").val(data.crealname);
                    $("#caddress").val(data.caddress);
                    $("#cfax").val(data.cfax);
                    $("#cemail").val(data.cemail);
                    $("#cadmin").val(data.cadmin);
                    $("#cphone").val(data.cphone);
                    $("#cps").val(data.cps);
                    layer.open({
                        title: '用户修改',
                        type: 1,
                        area: ['30%','70%'],
                        content: $('#editcustom')
                    });
                }
            });
            table.on('toolbar(test)', function(obj) {
                var data = obj.data;
                if(obj.event === 'add'){
                    layer.open({
                        type: 1
                        ,title: '新增客户'
                        ,btn: false
                        ,area: ['30%','70%']
                        ,content: $('#lhf')
                    });
                }
            })
        })

</script>
</html>
