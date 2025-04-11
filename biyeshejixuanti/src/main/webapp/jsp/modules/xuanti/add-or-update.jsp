<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑选题信息</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">选题信息管理</li>
                        <li class="breadcrumb-item active">编辑选题信息</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">选题信息信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa">
                                        <label>教师</label>
                                        <div>
                                            <select id="jiaoshiSelect" name="jiaoshiSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>教师姓名</label>
                                        <input id="jiaoshiName" name="jiaoshiName" class="form-control"
                                               placeholder="教师姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>照片</label>
                                        <img id="jiaoshiPhotoImg" src="" width="100" height="100">
                                    </div>
                                    <div class="form-group col-md-6 aaaaaa">
                                        <label>设计题目</label>
                                        <div>
                                            <select id="shejitimuSelect" name="shejitimuSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>题目名称</label>
                                        <input id="shejitimuName" name="shejitimuName" class="form-control"
                                               placeholder="题目名称" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>项目类型</label>
                                        <input id="shejitimuValue" name="shejitimuValue" class="form-control"
                                               placeholder="项目类型" readonly>
                                    </div>
                                    <div class="form-group col-md-6 aaaaaa">
                                        <label>用户</label>
                                        <div>
                                            <select id="yonghuSelect" name="yonghuSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>用户姓名</label>
                                        <input id="yonghuName" name="yonghuName" class="form-control"
                                               placeholder="用户姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>照片</label>
                                        <img id="yonghuPhotoImg" src="" width="100" height="100">
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="yonghuId" name="yonghuId" type="hidden">
                                <input id="jiaoshiId" name="jiaoshiId" type="hidden">
                                <input id="shejitimuId" name="shejitimuId" type="hidden">
                                    <div class="form-group col-md-6" id="xuanti">
                                        <label>开题报告</label>
                                        <input name="file" type="file" class="form-control-file" id="kaitibaogaoFileupload">
                                        <label id="kaitibaogaoFileName"></label>
                                        <input name="kaitibaogaoFile" id="kaitibaogaoFile-input" type="hidden">
                                    </div>
                                    <div class="form-group  col-md-6 aaaaaa" >
                                        <label>修改意见</label>
                                        <input id="kaitibaogaoContentupload" name="file" type="file">
                                        <script id="kaitibaogaoContentEditor" type="text/plain"
                                                style="width:100%;height:230px;"></script>
                                        <script type = "text/javascript" >
                                        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                        //相见文档配置属于你自己的编译器
                                        var kaitibaogaoContentUe = UE.getEditor('kaitibaogaoContentEditor', {
                                            toolbars: [
                                                [
                                                    'undo', //撤销
                                                    'bold', //加粗
                                                    'redo', //重做
                                                    'underline', //下划线
                                                    'horizontal', //分隔线
                                                    'inserttitle', //插入标题
                                                    'cleardoc', //清空文档
                                                    'fontfamily', //字体
                                                    'fontsize', //字号
                                                    'paragraph', //段落格式
                                                    'inserttable', //插入表格
                                                    'justifyleft', //居左对齐
                                                    'justifyright', //居右对齐
                                                    'justifycenter', //居中对
                                                    'justifyjustify', //两端对齐
                                                    'forecolor', //字体颜色
                                                    'fullscreen', //全屏
                                                    'edittip ', //编辑提示
                                                    'customstyle', //自定义标题
                                                ]
                                            ]
                                        });
                                        </script>
                                        <input type="hidden" name="kaitibaogaoContent" id="kaitibaogaoContent-input">
                                    </div>
                                    <div class="form-group col-md-6" id="zhongqibaogao">
                                        <label>中期报告</label>
                                        <input name="file" type="file" class="form-control-file" id="zhongqiFileupload">
                                        <label id="zhongqiFileName"></label>
                                        <input name="zhongqiFile" id="zhongqiFile-input" type="hidden">
                                    </div>
                                    <div class="form-group  col-md-6 aaaaaa">
                                        <label>修改意见</label>
                                        <input id="zhongqiContentupload" name="file" type="file">
                                        <script id="zhongqiContentEditor" type="text/plain"
                                                style="width:100%;height:230px;"></script>
                                        <script type = "text/javascript" >
                                        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                        //相见文档配置属于你自己的编译器
                                        var zhongqiContentUe = UE.getEditor('zhongqiContentEditor', {
                                            toolbars: [
                                                [
                                                    'undo', //撤销
                                                    'bold', //加粗
                                                    'redo', //重做
                                                    'underline', //下划线
                                                    'horizontal', //分隔线
                                                    'inserttitle', //插入标题
                                                    'cleardoc', //清空文档
                                                    'fontfamily', //字体
                                                    'fontsize', //字号
                                                    'paragraph', //段落格式
                                                    'inserttable', //插入表格
                                                    'justifyleft', //居左对齐
                                                    'justifyright', //居右对齐
                                                    'justifycenter', //居中对
                                                    'justifyjustify', //两端对齐
                                                    'forecolor', //字体颜色
                                                    'fullscreen', //全屏
                                                    'edittip ', //编辑提示
                                                    'customstyle', //自定义标题
                                                ]
                                            ]
                                        });
                                        </script>
                                        <input type="hidden" name="zhongqiContent" id="zhongqiContent-input">
                                    </div>


                                    <div class="form-group col-md-6" id="luenwen">
                                        <label>论文</label>
                                        <input name="file" type="file" class="form-control-file" id="luenwenFileupload">
                                        <label id="luenwenFileName"></label>
                                        <input name="luenwenFile" id="luenwenFile-input" type="hidden">
                                    </div>
                                    <div class="form-group  col-md-6 aaaaaa">
                                        <label>修改意见</label>
                                        <input id="luenwenContentupload" name="file" type="file">
                                        <script id="luenwenContentEditor" type="text/plain"
                                                style="width:100%;height:230px;"></script>
                                        <script type = "text/javascript" >
                                        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                        //相见文档配置属于你自己的编译器
                                        var luenwenContentUe = UE.getEditor('luenwenContentEditor', {
                                            toolbars: [
                                                [
                                                    'undo', //撤销
                                                    'bold', //加粗
                                                    'redo', //重做
                                                    'underline', //下划线
                                                    'horizontal', //分隔线
                                                    'inserttitle', //插入标题
                                                    'cleardoc', //清空文档
                                                    'fontfamily', //字体
                                                    'fontsize', //字号
                                                    'paragraph', //段落格式
                                                    'inserttable', //插入表格
                                                    'justifyleft', //居左对齐
                                                    'justifyright', //居右对齐
                                                    'justifycenter', //居中对
                                                    'justifyjustify', //两端对齐
                                                    'forecolor', //字体颜色
                                                    'fullscreen', //全屏
                                                    'edittip ', //编辑提示
                                                    'customstyle', //自定义标题
                                                ]
                                            ]
                                        });
                                        </script>
                                        <input type="hidden" name="luenwenContent" id="luenwenContent-input">
                                    </div>
                                    <div class="form-group col-md-12 mb-3">
                                        <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                        <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                    </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "xuanti";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var xuantiTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var jiaoshiOptions = [];
    var shejitimuOptions = [];
    var yonghuOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

        $('#kaitibaogaoFileupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                document.getElementById('kaitibaogaoFile-input').setAttribute('value', baseUrl + 'file/download?fileName=' + data.result.file);
                document.getElementById('kaitibaogaoFileName').innerHTML = "上传成功!";
            }
        });


        $('#kaitibaogaoContentupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                UE.getEditor('kaitibaogaoContentEditor').execCommand('insertHtml', '<img src=\"' + baseUrl + 'upload/' + data.result.file + '\" width=900 height=560>');
            }
        });


        $('#zhongqiFileupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                document.getElementById('zhongqiFile-input').setAttribute('value', baseUrl + 'file/download?fileName=' + data.result.file);
                document.getElementById('zhongqiFileName').innerHTML = "上传成功!";
            }
        });


        $('#zhongqiContentupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                UE.getEditor('zhongqiContentEditor').execCommand('insertHtml', '<img src=\"' + baseUrl + 'upload/' + data.result.file + '\" width=900 height=560>');
            }
        });


        $('#luenwenFileupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                document.getElementById('luenwenFile-input').setAttribute('value', baseUrl + 'file/download?fileName=' + data.result.file);
                document.getElementById('luenwenFileName').innerHTML = "上传成功!";
            }
        });


        $('#luenwenContentupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                UE.getEditor('luenwenContentEditor').execCommand('insertHtml', '<img src=\"' + baseUrl + 'upload/' + data.result.file + '\" width=900 height=560>');
            }
        });


    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';
            }
            httpJson("xuanti/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addxuanti');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        function xuantiTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=xuanti_types", "GET", {}, (res) => {
                if(res.code == 0){
                    xuantiTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function jiaoshiSelect() {
            //填充下拉框选项
            http("jiaoshi/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    jiaoshiOptions = res.data.list;
                }
            });
        }

        function jiaoshiSelectOne(id) {
            http("jiaoshi/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                jiaoshiShowImg();
                jiaoshiShowVideo();
                jiaoshiDataBind();
            }
        });
        }
        function shejitimuSelect() {
            //填充下拉框选项
            http("shejitimu/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    shejitimuOptions = res.data.list;
                }
            });
        }

        function shejitimuSelectOne(id) {
            http("shejitimu/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                shejitimuShowImg();
                shejitimuShowVideo();
                shejitimuDataBind();
            }
        });
        }
        function yonghuSelect() {
            //填充下拉框选项
            http("yonghu/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    yonghuOptions = res.data.list;
                }
            });
        }

        function yonghuSelectOne(id) {
            http("yonghu/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                yonghuShowImg();
                yonghuShowVideo();
                yonghuDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationXuantitypesSelect(){
        }

        function initializationjiaoshiSelect() {
            var jiaoshiSelect = document.getElementById('jiaoshiSelect');
            if(jiaoshiSelect != null && jiaoshiOptions != null  && jiaoshiOptions.length > 0 ) {
                for (var i = 0; i < jiaoshiOptions.length; i++) {
                        jiaoshiSelect.add(new Option(jiaoshiOptions[i].jiaoshiName, jiaoshiOptions[i].id));
                }

                $("#jiaoshiSelect").change(function(e) {
                        jiaoshiSelectOne(e.target.value);
                });
            }

        }

        function initializationshejitimuSelect() {
            var shejitimuSelect = document.getElementById('shejitimuSelect');
            if(shejitimuSelect != null && shejitimuOptions != null  && shejitimuOptions.length > 0 ) {
                for (var i = 0; i < shejitimuOptions.length; i++) {
                        shejitimuSelect.add(new Option(shejitimuOptions[i].shejitimuName, shejitimuOptions[i].id));
                }

                $("#shejitimuSelect").change(function(e) {
                        shejitimuSelectOne(e.target.value);
                });
            }

        }

        function initializationyonghuSelect() {
            var yonghuSelect = document.getElementById('yonghuSelect');
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                        yonghuSelect.add(new Option(yonghuOptions[i].yonghuName, yonghuOptions[i].id));
                }

                $("#yonghuSelect").change(function(e) {
                        yonghuSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var xuantiTypesSelect = document.getElementById("xuantiTypesSelect");
        if(xuantiTypesSelect != null && xuantiTypesOptions != null  && xuantiTypesOptions.length > 0 ) {
            for (var i = 0; i < xuantiTypesOptions.length; i++) {
                if (xuantiTypesOptions[i].codeIndex == ruleForm.xuantiTypes) {//下拉框value对比,如果一致就赋值汉字
                        xuantiTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var jiaoshiSelect = document.getElementById("jiaoshiSelect");
            if(jiaoshiSelect != null && jiaoshiOptions != null  && jiaoshiOptions.length > 0 ) {
                for (var i = 0; i < jiaoshiOptions.length; i++) {
                    if (jiaoshiOptions[i].id == ruleForm.jiaoshiId) {//下拉框value对比,如果一致就赋值汉字
                        jiaoshiSelect.options[i+1].selected = true;
                        $("#jiaoshiSelect" ).selectpicker('refresh');
                    }
                }
            }
            var shejitimuSelect = document.getElementById("shejitimuSelect");
            if(shejitimuSelect != null && shejitimuOptions != null  && shejitimuOptions.length > 0 ) {
                for (var i = 0; i < shejitimuOptions.length; i++) {
                    if (shejitimuOptions[i].id == ruleForm.shejitimuId) {//下拉框value对比,如果一致就赋值汉字
                        shejitimuSelect.options[i+1].selected = true;
                        $("#shejitimuSelect" ).selectpicker('refresh');
                    }
                }
            }
            var yonghuSelect = document.getElementById("yonghuSelect");
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                    if (yonghuOptions[i].id == ruleForm.yonghuId) {//下拉框value对比,如果一致就赋值汉字
                        yonghuSelect.options[i+1].selected = true;
                        $("#yonghuSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
        if (ruleForm.kaitibaogaoContent != null && ruleForm.kaitibaogaoContent != 'null' && ruleForm.kaitibaogaoContent != '' && $("#kaitibaogaoContentupload").length>0) {

            var kaitibaogaoContentUeditor = UE.getEditor('kaitibaogaoContentEditor');
            kaitibaogaoContentUeditor.ready(function () {
                var mes = '';
                if(ruleForm.kaitibaogaoContent != null){
                    mes = ''+ ruleForm.kaitibaogaoContent;
                    mes = mes.replace(/\n/g, "<br>");
                }
                kaitibaogaoContentUeditor.setContent(mes);
            });
        }
        if (ruleForm.zhongqiContent != null && ruleForm.zhongqiContent != 'null' && ruleForm.zhongqiContent != '' && $("#zhongqiContentupload").length>0) {

            var zhongqiContentUeditor = UE.getEditor('zhongqiContentEditor');
            zhongqiContentUeditor.ready(function () {
                var mes = '';
                if(ruleForm.zhongqiContent != null){
                    mes = ''+ ruleForm.zhongqiContent;
                    mes = mes.replace(/\n/g, "<br>");
                }
                zhongqiContentUeditor.setContent(mes);
            });
        }
        if (ruleForm.luenwenContent != null && ruleForm.luenwenContent != 'null' && ruleForm.luenwenContent != '' && $("#luenwenContentupload").length>0) {

            var luenwenContentUeditor = UE.getEditor('luenwenContentEditor');
            luenwenContentUeditor.ready(function () {
                var mes = '';
                if(ruleForm.luenwenContent != null){
                    mes = ''+ ruleForm.luenwenContent;
                    mes = mes.replace(/\n/g, "<br>");
                }
                luenwenContentUeditor.setContent(mes);
            });
        }
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
        if($("#kaitibaogaoContentupload").length>0) {
            var kaitibaogaoContentEditor = UE.getEditor('kaitibaogaoContentEditor');
            if (kaitibaogaoContentEditor.hasContents()) {
                $('#kaitibaogaoContent-input').attr('value', kaitibaogaoContentEditor.getPlainTxt());
            }
        }
        if($("#zhongqiContentupload").length>0) {
            var zhongqiContentEditor = UE.getEditor('zhongqiContentEditor');
            if (zhongqiContentEditor.hasContents()) {
                $('#zhongqiContent-input').attr('value', zhongqiContentEditor.getPlainTxt());
            }
        }
        if($("#luenwenContentupload").length>0) {
            var luenwenContentEditor = UE.getEditor('luenwenContentEditor');
            if (luenwenContentEditor.hasContents()) {
                $('#luenwenContent-input').attr('value', luenwenContentEditor.getPlainTxt());
            }
        }
    }
    //数字检查
        <!-- 当前表的数字检查 -->

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addxuanti');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                yonghuId: "required",
                jiaoshiId: "required",
                shejitimuId: "required",
                kaitibaogaoFile: "required",
                kaitibaogaoContent: "required",
                zhongqiFile: "required",
                zhongqiContent: "required",
                luenwenFile: "required",
                luenwenContent: "required",
                xuantiTypes: "required",
            },
            messages: {
                yonghuId: "选择学生不能为空",
                jiaoshiId: "选择题目不能为空",
                shejitimuId: "发布教师不能为空",
                kaitibaogaoFile: "开题报告不能为空",
                kaitibaogaoContent: "修改意见不能为空",
                zhongqiFile: "中期报告不能为空",
                zhongqiContent: "修改意见不能为空",
                luenwenFile: "论文不能为空",
                luenwenContent: "修改意见不能为空",
                xuantiTypes: "审核状态不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addxuanti = window.sessionStorage.getItem("addxuanti");
        if (addxuanti != null && addxuanti != "" && addxuanti != "null") {
            //注册表单验证
            $(validform());
            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("xuanti/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    $(".aaaaaa").attr("style","display: none")
                    if(res.data.xuantiTypes == 7){
                        $("#xuanti").attr("style","display: none")
                        $("#zhongqibaogao").attr("style","display: none")
                        $("#luenwen").attr("style","display: none")
                    }
                    if(res.data.xuantiTypes == 1 || res.data.xuantiTypes == 3){
                        $("#zhongqibaogao").attr("style","display: none")
                        $("#luenwen").attr("style","display: none")
                    }else if(res.data.xuantiTypes == 2 || res.data.xuantiTypes == 5){
                        $("#xuanti").attr("style","display: none")
                        $("#luenwen").attr("style","display: none")
                    }else if(res.data.xuantiTypes == 4 || res.data.xuantiTypes == 6){
                        $("#xuanti").attr("style","display: none")
                        $("#zhongqibaogao").attr("style","display: none")
                    }
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        jiaoshiDataBind();
        shejitimuDataBind();
        yonghuDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#yonghuId").val(ruleForm.yonghuId);
        $("#jiaoshiId").val(ruleForm.jiaoshiId);
        $("#shejitimuId").val(ruleForm.shejitimuId);
        $("#kaitibaogaoContent").val(ruleForm.kaitibaogaoContent);
        $("#zhongqiContent").val(ruleForm.zhongqiContent);
        $("#luenwenContent").val(ruleForm.luenwenContent);

    }
    <!--  级联表的数据回显  -->
    function jiaoshiDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#jiaoshiId").val(ruleForm.id);

        $("#jiaoshiName").val(ruleForm.jiaoshiName);
        $("#sexValue").val(ruleForm.sexValue);
        $("#jiaoshiIdNumber").val(ruleForm.jiaoshiIdNumber);
        $("#jiaoshiPhone").val(ruleForm.jiaoshiPhone);
    }

    function shejitimuDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#shejitimuId").val(ruleForm.id);

        $("#shejitimuName").val(ruleForm.shejitimuName);
        $("#jiaoshiId").val(ruleForm.jiaoshiId);
        $("#shejitimuValue").val(ruleForm.shejitimuValue);
        $("#insertTime").val(ruleForm.insertTime);
        $("#shejitimuZancheng").val(ruleForm.shejitimuZancheng);
        $("#shejitimuFandui").val(ruleForm.shejitimuFandui);
        $("#zhuangtaiValue").val(ruleForm.zhuangtaiValue);
        $("#shejitimuContent").val(ruleForm.shejitimuContent);
    }

    function yonghuDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#yonghuId").val(ruleForm.id);

        $("#yonghuName").val(ruleForm.yonghuName);
        $("#sexValue").val(ruleForm.sexValue);
        $("#yonghuIdNumber").val(ruleForm.yonghuIdNumber);
        $("#yonghuPhone").val(ruleForm.yonghuPhone);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        jiaoshiShowImg();
        shejitimuShowImg();
        yonghuShowImg();
    }


    <!--  级联表的图片  -->

    function jiaoshiShowImg() {
        $("#jiaoshiPhotoImg").attr("src",ruleForm.jiaoshiPhoto);
    }


    function shejitimuShowImg() {
    }


    function yonghuShowImg() {
        $("#yonghuPhotoImg").attr("src",ruleForm.yonghuPhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        jiaoshiShowVideo();
        shejitimuShowVideo();
        yonghuShowVideo();
    }


    <!--  级联表的视频  -->

    function jiaoshiShowVideo() {
        $("#jiaoshiPhotoV").attr("src",ruleForm.jiaoshiPhoto);
    }

    function shejitimuShowVideo() {
    }

    function yonghuShowVideo() {
        $("#yonghuPhotoV").attr("src",ruleForm.yonghuPhoto);
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            xuantiTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            jiaoshiSelect();
            shejitimuSelect();
            yonghuSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationXuantitypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationjiaoshiSelect();
            initializationshejitimuSelect();
            initializationyonghuSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
        window.sessionStorage.removeItem('addxuanti');
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events: none;');
        }else{
            $(".aaaaaa").remove();
        if(window.sessionStorage.getItem('addxuanti') != null && window.sessionStorage.getItem('addxuanti') !=""){//新增查询,修改不查
            // 查询当前登录账户的信息
            var userId = window.sessionStorage.getItem('userId');
                yonghuSelectOne(userId);
        }
        if(window.sessionStorage.getItem('addxuanti') != null && window.sessionStorage.getItem('addxuanti') !=""){//新增查询,修改不查
            // 查询当前登录账户的信息
            var userId = window.sessionStorage.getItem('userId');
                jiaoshiSelectOne(userId);
        }
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>