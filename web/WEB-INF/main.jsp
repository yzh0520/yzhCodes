<%--
  Created by IntelliJ IDEA.
  User: Anduin
  Date: 2019/9/16
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <script type="text/javascript" src="../layui/layui.js"></script>
</head>
<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <div class="layui-logo"></div>
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item">制造装备物联及生产管理平台</li>
            </ul>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        ${username}
                    </a>
                </li>
                <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/user/logout">退出</a></li>
            </ul>
        </div>

        <div class="layui-side layui-bg-black">
            <div class="layui-side-scroll">
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree layui-inline"  lay-filter="demoNav">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">计划进度</a>
                        <dl class="layui-nav-child">
                            <dd><a href="<%=request.getContextPath()%>/custom/toList" target="iframe">客户管理</a></dd>
                            <dd><a href="<%=request.getContextPath()%>/orders/toList;" target="iframe">订单管理</a></dd>
                            <dd><a href="javascript:;">产品管理</a></dd>
                            <dd><a href="javascript:;">作业管理</a></dd>
                            <dd><a href="javascript:;">生产计划管理</a></dd>
                            <dd><a href="javascript:;">生产派工管理</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item"><a href="javascript:;">设备管理</a></li>
                    <li class="layui-nav-item"><a href="javascript:;">工艺监控</a></li>
                    <li class="layui-nav-item"><a href="javascript:;">物料监控</a></li>
                    <li class="layui-nav-item"><a href="javascript:;">质量监控</a></li>
                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;">人员监控</a>
                        <dl class="layui-nav-child">
                            <dd><a href="<%=request.getContextPath()%>/user/toList" target="iframe">人员管理</a></dd>
                            <dd><a href="javascript:;">权限管理</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item"><a href="javascript:;">系统管理</a></li>
                </ul>
            </div>
        </div>

        <div class="layui-body">
            <iframe style="width: 100%;height: 100%;" name="iframe" frameborder="0" scrolling="yes"></iframe>
        </div>
        <div class="layui-footer"></div>
</div>
<script>
    layui.use(['element', 'layer'],
        function() {
            var element = layui.element;
            var $ = layui.$;
            //监听导航点击
            element.on('nav(demoNav)',
                function(elem) {
                    //如果点击的是条目就不切换新增选项卡。
                    $(elem).parent().hasClass("layui-nav-item") || tabChange('demoTab', elem);
                });

            //选项卡是否存在
            function tabIsExist(filter, id) {
                //0=false, 1=true(存在一个选项卡)
                return !! $('.layui-tab[lay-filter="' + filter + '"]').find('.layui-tab-title li[lay-id="' + id + '"]').length;
            }
            //切换、新增选项卡
            tabChange = function(filter, elem) {
                var id = $(elem).attr('lay-id');
                if (!tabIsExist(filter, id)) {
                    //新增一个Tab项
                    element.tabAdd(filter, {
                        id: id,
                        title: elem.text(),
                        content: '内容' + (Math.random() * 1000 | 0)
                    })
                }
                //切换到指定Tab项
                element.tabChange(filter, id); //切换到
            }
            //定位菜单
            element.on('tab(demoTab)',
                function(elem) {
                    var filter = 'demoNav'; //菜单
                    var id = $(this).attr('lay-id');
                    var navElem = $('.layui-nav[lay-filter="' + filter + '"]'); //菜单导航元素
                    //移除所有选中、获取当前tab选择导航、标注选中样式、展开条目
                    navElem.find('dd').removeClass('layui-this').find('a[lay-id="' + id + '"]').parent().addClass('layui-this').parents('li,dl').addClass('layui-nav-itemed')
                });
        });
</script>
</body>
</html>
