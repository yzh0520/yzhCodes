<%--
  Created by IntelliJ IDEA.
  User: Anduin
  Date: 2019/9/20
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="../js/ajaxfileupload.js"></script>
</head>
<body>
    <table class="layui-hide" id="test" lay-filter="test"></table>

    <div hidden="hidden" id="lhf" style="padding: 25px">
        <form action="<%=request.getContextPath()%>/orders/ordersInsert" method="post">
            <input type="text" class="layui-input" name="ocname" placeholder="请输入客户名称"/>
            <input type="text" class="layui-input" name="opname" placeholder="请输入订购产品"/>
            <input type="text" class="layui-input" name="onum" placeholder="请输入数量"/>
            <input type="text" class="layui-input" name="oprice" placeholder="请输入税前单价"/>
            <input type="text" class="layui-input" name="ounit" placeholder="请输入产品单位"/>
            <input type="text" class="layui-input" name="ostate" placeholder="请输入状态"/>
            <input class="layui-input laydate" name="ocreatetime" id="date" type="text"
                   placeholder="订单创建时间*必选*" lay-verify="date">
            <input class="layui-input laydate" name="ofinishtime" id="date2" type="text"
                   placeholder="订单结束时间*必选*" lay-verify="date">
            <%--<input type="text" class="layui-input" name="ops" placeholder="请输入订单要求"/>--%>
            <textarea id="textarea_ops" name="ops" style="display: none;width: 50px;height: 50px;">请输入订单备注</textarea>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test1">上传图片</button>
                <div class="layui-upload-list">
                    <img class="layui-upload-img" style="width: 50px;height: 50px" id="demo1">
                    <p id="demoText"></p>
                </div>
            </div><br>
            <input hidden="hidden" type="text" name="oimg" id="oimg">
            <input hidden="hidden" type="text" name="orealimg" id="orealimg">
            <input type="submit" class="layui-btn" value="提交">
        </form>
    </div>
    <div hidden="hidden" id="editcustom" style="padding: 25px">
        <form action="<%=request.getContextPath()%>/orders/editOrders" method="post">
            <input type="text" class="layui-input" name="oid" id="oid" readonly ="readonly"/>
            <input type="text" class="layui-input" name="ocname" id="ocname" placeholder="请输入客户名称"/>
            <input type="text" class="layui-input" name="opname" id="opname" placeholder="请输入订购产品"/>
            <input type="text" class="layui-input" name="onum" id="onum" placeholder="请输入数量"/>
            <input type="text" class="layui-input" name="oprice" id="oprice" placeholder="请输入税前单价"/>
            <input type="text" class="layui-input" name="ounit" id="ounit" placeholder="请输入产品单位"/>
            <input type="text" class="layui-input" name="ostate" id="ostate" placeholder="请输入状态"/>
            <input class="layui-input laydate" name="ocreatetime" id="ocreatetime" type="text"
                   placeholder="订单创建时间*必选*" autocomplete="off" lay-verify="date">
            <input class="layui-input laydate" name="ofinishtime" id="ofinishtime" type="text"
                   placeholder="订单结束时间*必选*" autocomplete="off" lay-verify="date">
            <input type="text" class="layui-input" name="ops" id="ops" placeholder="请输入要求"/>
            请上传图片<input type="file" name="file" id="img2" onchange="uploadImg()"/>
            <input type="hidden" name="avatar" id="avatar2"/>
            <img src="" alt="" id="avatarShow2" width="100px" height="100px"/>
            <input type="submit" class="layui-btn" value="提交">
        </form>
    </div>
</body>
<script>
    layui.use([ 'layer','table','upload','laydate','layedit','form'],
        function() {
            var layer = layui.layer;
            var $ = layui.$;
            var table = layui.table;
            var laydate = layui.laydate;
            var util = layui.util;
            var layedit = layui.layedit;
            var form = layui.form;
            layedit.build('textarea_ops');
            table.render({
                elem: '#test'
                , url: '<%=request.getContextPath()%>/orders/ordersList'
                , cols: [[
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'oid', width: 60, title: '编号'}
                    , {field: 'ocname', width: 80, title: '客户'}
                    , {field: 'opname', width: 100, title: '订购产品'}
                    , {field: 'onum', width: 70, title: '数量'}
                    , {field: 'oprice', width: 70, title: '税前单价'}
                    , {field: 'ounit', width:80, title: '产品单位'}
                    , {field: 'ostate', width: 80, title: '状态'}
                    , {field: 'ocreatetime', width: 140, title: '订购日期'
                        ,templet:'<div>{{layui.util.toDateString(d.ocreatetime,\"yyyy-MM-dd HH:mm:ss\")}}</div>'
                        ,sort:true}
                    , {field: 'ofinishtime', width: 140, title: '要求日期'
                        ,templet:'<div>{{layui.util.toDateString(d.ofinishtime,\"yyyy-MM-dd HH:mm:ss\")}}</div>'
                        ,sort:true}
                    , {field: 'ops', width: 70, title: '要求'}
                    ,{title: '图片', width: 100, templet:imgbox, align:'center'}
                    , {field: 'oacr', width: 75, title: '附件'}
                    , {
                        fixed: 'right',
                        title: '操作',
                        width: 180,
                        align: 'center',
                        toolbar: '<div class="layui-btn-group"><button type="button" ' +
                            'class="layui-btn  layui-btn-xs" lay-event="edit">编辑</button>' +
                            '<button class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</button></div>'
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
                            url: "<%=request.getContextPath()%>/orders/delete?oid="+data.oid,
                            success: function(msg){
                                layer.msg(msg);
                            }
                        });
                        layer.close(index);
                    });
                }else if(obj.event === 'edit'){
                    $("#oid").val(data.oid);
                    $("#ocname").val(data.ocname);
                    $("#opname").val(data.opname);
                    $("#onum").val(data.onum);
                    $("#oprice").val(data.oprice);
                    $("#ounit").val(data.ounit);
                    $("#ostate").val(data.ostate);
                    $("#ocreatetime").val(util.toDateString(data.ocreatetime, 'yyyy-MM-dd HH:mm:ss'));
                    $("#ofinishtime").val(util.toDateString(data.ofinishtime, 'yyyy-MM-dd HH:mm:ss'));
                    $("#ops").val(data.ops);
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
                        ,title: '新增订单'
                        ,btn: false
                        ,area: ['30%','70%']
                        ,content: $('#lhf')
                    });
                }
            })

            laydate.render({
                elem: '#date'
                ,type: 'datetime'
                ,format:'yyyy-MM-dd HH:mm:ss'
            });
            laydate.render({
                elem: '#date2'
                ,type: 'datetime'
                ,format:'yyyy-MM-dd HH:mm:ss'
            });
            laydate.render({
                elem: '#ocreatetime'
                ,type: 'datetime'
                ,format:'yyyy-MM-dd HH:mm:ss'
            });
            laydate.render({
                elem: '#ofinishtime'
                ,type: 'datetime'
                ,format:'yyyy-MM-dd HH:mm:ss'
            });

            //监听提交
            form.on('submit(formDemo)', function(data){
                layer.msg(JSON.stringify(data.field));
                return false;
            });
        })

    function imgbox(data){
        var orealimg = data.orealimg;
        var img="<img src='"+orealimg+"'style='width:40px;height:40px;'/>";
        return img;
    }

    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            , url: '<%=request.getContextPath()%>/orders/uploadImg'
            , before: function (obj) {
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result);
                });
            }
            , done: function (res) {
                if (res.code < 0) {
                    return layer.msg('上传失败');
                }
                else if (res.code == 1) {
                    layer.msg("上传成功");
                    $("#oimg").val(res.abspath);
                    $("#orealimg").val(res.virtualPath);
                }
            }

            , error: function () {
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
    });
</script>
</html>
