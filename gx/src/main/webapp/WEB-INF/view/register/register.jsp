<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" href="${path}/css/register/reset.css" rel="stylesheet">
<link type="text/css" href="${path}/css/register/public.css" rel="stylesheet">
<link type="text/css" href="${path}/css/register/register.css" rel="stylesheet">
<link rel="shortcut icon" href="favicon.ico" />
<script src="${path}/js/common/jquery.min.js" type="text/javascript"></script>
<script src="${path}/js/register/jquery.form.js" type="text/javascript"></script>
<script src="${path}/js/register/json.parse.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	if('1'==='${register_success}'){
		alert('注册成功，请去登录');
	}
	$(".btn").click(function(){
				var agreenMent=$("#agreement").attr("data");
				
				//alert(agreenMent);0
				var userName= $("#username").val();
				var userPass= $("#password1").val();
				var userPass2=$("#password2").val();
				var userEmail=$("#mail").val();
				
				userPass=$.trim(userPass);
				userPass2=$.trim(userPass2);
				
				$(".input_div1 span,.input_div2 span,.input_div3 span,.input_div4 span,.input_div6 span,.input_div5 span").html("");
				$(".btn").val('注册中...').attr('disabled','disabled');
				
				/* if(!isRegisterUserName(userName)){
					$(".input_div1 span").html('<img src="${path}/images/register/text_error.png"><font color=red>账户名格式不正确!</font>');
					$("#username").focus();
					$(".btn").val('注册').removeAttr('disabled');
					return false;
				}else if(!isEmail(userEmail)){
					$(".input_div2 span").html('<img src="${path}/images/register/text_error.png"><font color=red>邮箱格式不正确!</font>');
					$("#mail").focus();
					$(".btn").val('注册').removeAttr('disabled');
					return false;
				}else if(userPass.length <8){
					$(".input_div3 span").html('<img src="${path}/images/register/text_error.png"><font color=red>密码格式不正确!</font>');
					$("#password1").focus();
					$(".btn").val('注册').removeAttr('disabled');
					return false;
				}else if(userPass != userPass2){
					$(".input_div4 span").html('<img src="${path}/images/register/text_error.png"><font color=red>两次输入的密码不一致!</font>');
					$("#password2").focus();
					$(".btn").val('注册').removeAttr('disabled');
					return false;
				}  else if(agreenMent != '1'){
					//$(".agreenment-tips").html('请先同意用户条款!').fadeIn();
					$(".input_div6 span").html('<img src="${path}/images/register/text_error.png"><font color=red>请先同意用户条款!</font>');
					$(".btn").val('注册').removeAttr('disabled');
					return false;
				}else{ */
					$("#registerForm").ajaxSubmit(function(e){
						 if(e.success){
							alert('恭喜您，注册成功!');
							location.reload() 
							//window.location.href=obj.acturl;
						}else{
							alert('注册失败，请稍后再试!');
						}
						//flushCode();
						$(".btn").val('注册').removeAttr('disabled');
					})
				//}
				
		})
	
	
	$('.check2').click(function(){
		var rel = $('#agreement').attr("data");
		//alert(rel);
		if(rel =='1'){
			$('#agreement').attr("data","0");
		}else{
			$('#agreement').attr("data","1");
		}
		$('.check2').toggleClass("check1");
	});
	
});

function isRegisterUserName(s){  
	var patrn=/^[a-zA-Z0-9]{1}([a-zA-Z0-9]|[._]){5,19}$/;  
	if (!patrn.exec(s)) return false
	return true
}

function isEmail(email){
	   var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	   if(!myreg.test(email)) return false;
		return true; 
 }

</script>
<style>
.input_div span{ background:#FFF;}
</style>
<!--[if IE 6]>
<script src="themes/js/DD_belatedPNG.js"  type="text/javascript"></script>
<script>DD_belatedPNG.fix('.png_bg');</script>
<![endif]-->
</head>
<body>
	<div id="header">
		<div class="header">
			<h1 class="png_bg"></h1>
		
			<a class="png_bg" href="">返回主页</a>
		</div>
	</div>
	
	<div class="register_content">
	
		<ul class="step_ul step1 clear">
			<li class="li1">01、填写资料</li>
			<li class="li2">02、完成注册</li>
		</ul>
		
		 <form name="registerForm" id='registerForm' action="${path}/user/register"  style="padding:60px 40px 88px 40px;font-family:Microsoft Yahei" modelAttribute="user" method="post">
			<div class="div_form clear ">
				<label>账户名：</label>
				<div class="input_div input_div1">
					<input id="username" name="name" type="text" placeholder="格式6-24位数字字母组合" maxlength="24">
					<span></span>
				</div>
			</div>
			<div class="div_form clear ">
				<label>常用的邮箱帐号：</label>
				<div class="input_div input_div2" >
					<input id="mail" name="email"  type="text" placeholder="请填写正确的邮箱，以便接收账号激活邮件" maxlength="64">
					<span></span>
				</div>
			</div>
			<div class="div_form clear ">
				<label>请创建一个密码：</label>
				<div class="input_div input_div3">
					<input id="password1" name="password" type="password" placeholder="最少 8 个字符，区分大小写" maxlength="32">
					<span></span>
				</div>
			</div>
			<div class="div_form clear ">
				<label>重新输入密码：</label>
				<div class="input_div input_div4">
					<input id="password2" name="userpass2" type="password" placeholder="再次输入密码" maxlength="32">
					<span></span>
				</div>
			</div>
			
			 <div class="div_form clear " style="height:200px;">
            	<label>验证码：</label>
				<div id="div_geetest_lib"></div>
				<div id="div_id_embed" style="float:left;"></div>

				<%--End  Code--%>



				<script type="text/javascript">
					var gtFailbackFrontInitial = function(result) {
						var s = document.createElement('script');
						s.id = 'gt_lib';
						s.src = 'http://static.geetest.com/static/js/geetest.0.0.0.js';
						s.charset = 'UTF-8';
						s.type = 'text/javascript';
						document.getElementsByTagName('head')[0].appendChild(s);
						var 
					loaded = false;
						s.onload = s.onreadystatechange = function() {
							if (!loaded
									&& (!this.readyState
											|| this.readyState === 'loaded' || this.readyState === 'complete')) {
								loadGeetest(result);
								loaded = true;
							}
						};
					}
					//get  geetest server status, use the failback solution


					var loadGeetest = function(config) {

						//1. use geetest capthca
						window.gt_captcha_obj = new window.Geetest({
							gt : config.gt,
							challenge : config.challenge,
							product : 'embed',
							offline : !config.success
						});

						gt_captcha_obj.appendTo("#div_id_embed");

						//Ajax request demo,if you use submit form ,then ignore it 
						gt_captcha_obj.onSuccess(function() {
							//alert(1);
							//geetest_ajax_results()
						});
					}

					s = document.createElement('script');
					s.src = 'http://api.geetest.com/get.php?callback=gtcallback';
					$("#div_geetest_lib").append(s);
					
					var gtcallback =( function() {
						var status = 0, result, apiFail;
						return function(r) {
							status += 1;
							if (r) {
								result = r;
								setTimeout(function() {
									if (!window.Geetest) {
										apiFail = true;
										gtFailbackFrontInitial(result)
									}
								}, 1000)
							}
							else if(apiFail) {
								return
							}
							if (status == 2) {
								loadGeetest(result);
							}
						}
					})()
					
					$.ajax({
								url : "StartCapthcaServlet",
								type : "get",
								dataType : 'JSON',
								success : function(result) {
									gtcallback(result)
								}
							})
				</script>
			</div>
			
			
			<div class="div_form clear ">
				<label></label>
				<div class="input_div check2 input_div6" data="0" id="agreement">
					我已阅读并接受《xxxxx用户服务协议》
                    <span></span>
				</div>
			</div>
            
			<div class="div_form clear ">
				<label></label>
				<div class="input_div">
					<input id="btn" class="btn" type="button" value="注册" />
				</div>
			</div>
			
		</form>
		
		<div class="reg_login">
			<p>已有帐号？</p>
			<a class="btn2" href="login">登录</a>
		</div>
		<div class="bg"></div>
	</div>
	
	<!-- footer start -->
<div id="footer" class="clear">
    <h1 class="png_bg"></h1>
    <div class="friendLink clear">
        <a  href="#" target="_blank" title="隐私政策" rel="nofollow">隐私政策</a>
        <a href="#" target="_blank" rel="nofollow">服务条款</a>
        <a href="#" target="_blank" rel="nofollow">关于我们</a>
        <a href="#" target="_blank" rel="nofollow">js代码招聘</a>
        <a href="#" target="_blank" rel="nofollow">联系我们</a>
        <a href="#" target="_blank" rel="nofollow">友情链接</a>
    </div>
    <p>上海xxxx有限公司©版权所有 沪ICP备83823823号</p>
    <div class="weixin">
        <img src="${path}/images/register/weiyi_qr.png" alt="" />
        <h3>关注xx官网微信</h3>
    </div>
</div>
<script type="text/javascript">
    var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F5d12e2b4eed3b554ae941c0ac43c330a' type='text/javascript'%3E%3C/script%3E"));
</script>
<!-- footer end -->
</body>
</html>