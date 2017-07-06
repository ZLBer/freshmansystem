<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/commonstyle.css" />
<div class="footer">
	<div class="footerinner">
		<ul class="share">
			<li><img class="weibo_icon" src="${pageContext.request.contextPath}/images/share1.png" alt="">
			</li>
			<li><img class="qq_icon" src="${pageContext.request.contextPath}/images/share2.png" alt="">
			</li>
			<li><img class="twitter_icon" src="${pageContext.request.contextPath}/images/share3.png" alt="">
			</li>
			<li><img class="wechat_icon" src="${pageContext.request.contextPath}/images/share4.png" alt="">
			</li>
		</ul>
		<div class="code_wrap">
			<ul class="code">
				<li><img class="weibo" src="${pageContext.request.contextPath}/images/weibo1.png" alt=""></li>
				<li><img class="qq" src="${pageContext.request.contextPath}/images/qq1.png" alt=""></li>
				<li><img class="twitter" src="${pageContext.request.contextPath}/images/twitter1.png" alt="">
				</li>
				<li><img class="wechat" src="${pageContext.request.contextPath}/images/wechat1.png" alt="">
				</li>
			</ul>
		</div>
	</div>
	<div class="footerinfo">
		<div class="footerinfoTop">
			<span>鲁ICP备05002369号|地址:山东省泰安市岱宗大街61号|邮编:271018|版权所有©山东农业大学|</span>
		</div>

	</div>
</div>
<script>
	/*底部二维码*/

	$(".weibo_icon").hover(function() {
		$(".weibo").fadeIn(500);
		$(".qq,.twitter,.wechat").fadeOut(0);
		$(".code_wrap").css("z-index", 200);
	}, function() {
		$(".weibo").fadeOut(0);
		$(".code_wrap").css("z-index", 50);
	});

	$(".qq_icon").hover(function() {
		$(".qq").fadeIn(500);
		$(".weibo,.twitter,.wechat").fadeOut(0);
		$(".code_wrap").css("z-index", 200);
	}, function() {
		$(".qq").fadeOut(0);
		$(".code_wrap").css("z-index", 50);
	});
	$(".twitter_icon").hover(function() {
		$(".twitter").fadeIn(500);
		$(".weibo,.qq,.wechat").fadeOut(0);
		$(".code_wrap").css("z-index", 200);
	}, function() {
		$(".twitter").fadeOut(0);
		$(".code_wrap").css("z-index", 50);
	});
	$(".wechat_icon").hover(function() {
		$(".wechat").fadeIn(500);
		$(".weibo,.qq,.twitter").fadeOut(0);
		$(".code_wrap").css("z-index", 200);
	}, function() {
		$(".wechat").fadeOut(0);
		$(".code_wrap").css("z-index", 50);
	});
	$(".weibo,.twitter,.wechat").hover(function() {
		$(this).fadeIn(0);
		$(".code_wrap").css("z-index", 200);
	}, function() {
		$(this).fadeOut(500);
		$(".code_wrap").css("z-index", 50);
	});
</script>