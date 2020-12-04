//加载事件
$(function() {
	//1.索引
	var index = 0;
	//2.标识:启动 or 停止
	var stop = false;
	//3.图片列表
	var imgLi = $(".slide_box").children("li");
	//4.数字列表
	var numLi = $(".num").children("li");
	console.log(numLi);
	//5.鼠标悬停上数字
	numLi.mouseover(function() {
		//启动
		stop = true;
		//获得索引
		index = numLi.index($(this));
		//图片显示，再隐藏它的兄弟
		imgLi.eq(index).stop().fadeIn().siblings().fadeOut();
		//数字加选中的颜色,其他取消
		numLi.eq(index).addClass("active").stop().siblings().removeClass("active");

	}).mouseout(function() {
		stop = false; //停止
	});

	//时钟特性
	var my = setInterval(function() {
		//判断
		if(stop) return;

		//索引
		index++;

		//判断
		if(index >= imgLi.length) {
			index = 0;
		}

		//图片显示，再隐藏它的兄弟
		imgLi.eq(index).stop().fadeIn().siblings().fadeOut();
		//数字加选中的颜色,其他取消
		numLi.eq(index).addClass("active").stop().siblings().removeClass("active");
	}, 3000)

});