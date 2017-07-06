/**
 * 
 */
function initialize() {
	var position = new AMap.LngLat(117.11915016, 36.19422642);// 创建中心点坐标
	var mapObj = new AMap.Map("container", {
		view : new AMap.View2D({
			center : position,
			zoom : 17
		}),
		resizeEnable : true,
		mapStyle : "normal",
		features : [ 'bg', 'point', 'road', 'building' ]
	});
	var icon = new AMap.Icon({
		image : 'http://vdata.amap.com/icons/b18/1/2.png',// 24px*24px
		// icon可缺省，缺省时为默认的蓝色水滴图标，
		size : new AMap.Size(24, 24)
	});

	var marker = new AMap.Marker({
		// icon : icon,// 24px*24px
		position : position,
		offset : new AMap.Pixel(-12, -12),
		map : mapObj
	});

	var position2 = new AMap.LngLat(117.12958395, 36.20052081);// 创建中心点坐标
	var marker = new AMap.Marker({
		// icon : icon,// 24px*24px
		position : position2,
		offset : new AMap.Pixel(-12, -12),
		map : mapObj
	});

	var position3 = new AMap.LngLat(117.15745211, 36.16337052);// 创建中心点坐标
	var marker = new AMap.Marker({
		// icon : icon,// 24px*24px
		position : position3,
		offset : new AMap.Pixel(-12, -12),
		map : mapObj
	});

	AMap.plugin('AMap.AdvancedInfoWindow', function() {
		var infowindow = new AMap.AdvancedInfoWindow({
			content : '<div class="info-title">山东农业大学</div>',
			offset : new AMap.Pixel(0, -10),
			// offset用来调整使锚点和position重合
			asOrigin : false
		// 不显示出发功能
		});
		var openLngLat = position;
		infowindow.open(mapObj, openLngLat);

	});
	AMap.plugin([ 'AMap.ToolBar', 'AMap.Scale', 'AMap.OverView' ], function() {
		mapObj.addControl(new AMap.ToolBar());
		mapObj.addControl(new AMap.Scale());
		mapObj.addControl(new AMap.OverView({
			isOpen : true
		}));
	});
};

