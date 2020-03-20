<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><meta charset="UTF-8">
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.1</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/cookie.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form">
        <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>模块Id
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="plateId" name="plateId" required="" lay-verify="plateId"
                  autocomplete="off" class="layui-input" value="${plate.plateId}" readonly="readonly"> 
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>模块名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="plateTitle" name="plateTitle" required="" lay-verify="plateTitle"
                  autocomplete="off" class="layui-input" value="${plate.plateTitle}">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>模块标题
              </div>
          </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>模块描述
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="plateMessage" name="plateMessage" required="" lay-verify="plateMessage"
                  autocomplete="off" class="layui-input" value="${plate.plateMessage}">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>模块信息介绍
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="edit" lay-submit="">
                  修改
              </button>
          </div>
      </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          });

          //监听提交
          form.on('submit(edit)', function(data){
        	  console.log(data);
        	  $.ajax({
        		 url:"${pageContext.request.contextPath}/PlateServlet?op=update",
        		 type:"post",
        		 data:data.field,
        		 dataType:"text",
        		 success:function(text){
        			 if(text.trim()=="true"){
        				 layer.alert("修改成功", {icon: 6},function () {
        					 //关闭当前frame
 	                        x_admin_close();
 	                        // 可以对父窗口进行刷新 
 	                        x_admin_father_reload();
 	                    }); 
        			 }else{
        				 layer.alert("修改失败", {icon: 2},function () {
        					//关闭当前frame
 	                        x_admin_close();
 	                        // 可以对父窗口进行刷新 
 	                        x_admin_father_reload();
 	                    }); 
        			 }
        		 }
        	  });
            //console.log(data);
            //发异步，把数据提交给php
            
            return false;
          });
          
          
        });
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>