/**
 * 需要jquery
 * 
 */

//获取购物车数据
function cartlist() {
		$.ajax({
			url : "User/Cart/ajaxlist",
			type : "post",
			data : {},
			dataType : "json",
			success : function(data) {
				loadheadcart(data);
			}
		});
	}

//优化bootstrap加载速度
  var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-XXXXX-X' ]);
	_gaq.push([ '_trackPageview' ]);
	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();


    //图片实现懒加载
    $(function() {
        $("img").lazyload({effect: "fadeIn", threshold :80});
    });

    //顶部购物车的删除动画
	$("#headcart").on("click","#remove",function(){
		var pid=$(this).attr("pid");
		
		console.log($("#maincart").find("tr[pid="+pid+"]"));
			try{
				$("#maincart").find("tr[pid="+pid+"]").fadeOut("slow");
				mainRemove($("#maincart").find("tr[pid="+pid+"]").find(".remove"));
			}
			catch(error){
				console.log(error);
			}
	$(this).parents("li").fadeOut("slow");
	removeCartItem($(this).attr("pid")); });
	
	//加载顶部购物车cart为购物车数据
	function loadheadcart(cart) {
		
		var html="";
		var size=0;
		var sum=0;
		for ( var i in cart) {
			html += '<li class="single-cart-item media">'
					+ '<div class="shopping-cart-img mr-4">'
					+ '<a href="Common/Product/get?pid='+cart[i].pid+'">'
					+ ' <img class="img-fluid" alt="Cart Item" src="'+cart[i].productImgs[0].imgurl+'">'
					+ '<span class="product-quantity">'+cart[i].number+'x</span>'
					+ '</a>' + '</div>'
					+ '<div class="shopping-cart-title media-body">'
					+ '<h4><a href="Common/Product/get?pid='+cart[i].pid+'">'+cart[i].pname+'</a></h4>'
					+ '<p class="cart-price">$'+cart[i].pnewprice+'</p>'
					+ '<div class="product-attr"><span>Size: S</span>'
					+ ' <span>Color: Black</span>' + '</div>' + '</div>'
					+ '<div class="shopping-cart-delete">'
					+ '<a href="javascript:void(0)" id="remove" pid='+cart[i].pid+'><i class="ion ion-md-close"></i></a>'
					+ '</div>' + '</li>';
					size++;
					sum+=cart[i].pnewprice*cart[i].number;
		}
		console.log("loadheadcart"+size);
	 if(size!=0)	
		 {if(!($(".count-style").length > 0))
		minicart.innerHTML+="<span class='count-style' >"+size+"</span>"}
		else
			{
			console.log("等于零");
			$(".count-style").remove();}
		$(".count-style").text(size);
		$("#headcart").html(html);		
		$("#head-cart-sum span").each(function(){$(this).text("$"+sum);});
	}
	
	//ajax删除单个购物车商品
	function removeCartItem(pid){
		$.ajax({
			url : "User/Cart/ajaxdelete",
			type : "post",
			data : {	"pid" : pid},
			success : function(result) {
				todo(result);	
				cartlist();
			}
		});}
	
	//ajax修改单个购物车商品数据
	function updateCartItem(pid,number){
		if(number>0)
		$.ajax({
			url : "User/Cart/ajaxupdate",
			type : "post",
			data : {	"pid" : pid,"number":number},
			success : function(result) {
				todo(result);
				cartlist();
			}
		});
		else
			toastr.warning("警告","非法输入",{timeOut: 900});
		}
	
	
	//购物车添加商品
	function cartadd(pid, number) {
		$.ajax({
			url : "User/Cart/ajaxadd",
			type : "post",
			data : {"number" : number,"pid" : pid},
			success : function(result) {				
				todo(result);
				cartlist();
			}
		});
	}
		
	//判断ajax返回的字符串并做出响应
	function todo(result){
		if(result.indexOf("成功")>-1)
			toastr.success("成功",result,{timeOut: 900});
		else{
	    if(result.indexOf("登录")>-1)
	    	{
				window.location.href="/cart/User/login.jsp";
	    	}
			else{
		       if(result.indexOf("失败")>-1)
		    	   toastr.error("失败",result,{timeOut: 1500});
		       else
		    	   toastr.error("异常","操作异常！",{timeOut: 1500});
			}
	}
	}