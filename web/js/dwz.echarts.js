$(function() {
	var dom = document.getElementById("container");
	var myChart = echarts.init(dom);
	var app = {};
	var option = null;
	option = {
		title : {
		// text : '未来一周气温变化',
		// subtext : '纯属虚构'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '联系方式', '交通方式', '注册人数' ]
		},
		toolbox : {
			show : true,
			feature : {
				dataZoom : {
					yAxisIndex : 'none'
				},
				dataView : {
					readOnly : false
				},
				magicType : {
					type : [ 'line', 'bar' ]
				},
				restore : {},
				saveAsImage : {}
			}
		},
		xAxis : {
			type : 'category',
			boundaryGap : false,
			data : []
		},
		yAxis : {
			type : 'value',
			axisLabel : {
				formatter : '{value} 人'
			}
		},
		dataZoom : [
				{
					type : 'inside',
					start : 0,
					end : 100
				},
				{
					start : 0,
					end : 100,
					handleIcon : 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
					handleSize : '80%',
					handleStyle : {
						color : '#fff',
						shadowBlur : 3,
						shadowColor : 'rgba(0, 0, 0, 0.6)',
						shadowOffsetX : 2,
						shadowOffsetY : 2
					}
				} ],

		series : [ {
			name : '联系方式',
			type : 'line',
			data : [],
			markPoint : {
				data : [ {
					type : 'max',
					name : '最大值'
				}, {
					type : 'min',
					name : '最小值'
				} ]
			},
			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ]
			}
		}, {
			name : '交通方式',
			type : 'line',
			data : [],
			markPoint : {
				data : [ {
					type : 'max',
					name : '最大值'
				}, {
					type : 'min',
					name : '最小值'
				} ]
			},
			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ]
			}
		}, {
			name : '注册人数',
			type : 'line',
			data : [],
			markPoint : {
				data : [ {
					type : 'max',
					name : '最大值'
				}, {
					type : 'min',
					name : '最小值'
				} ]
			},
			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ]
			}
		}

		]
	};
	if (option && typeof option === "object") {
		myChart.setOption(option, true);
	}

	$("#query").bind('click', function() {
		$.ajax({
			url : 'statistic!stage.action',
			type : 'post',
			dataType : 'json',
			data : {},
			success : function(data) {
				if (data && data.success) {
					option.xAxis.data.shift();
					option.xAxis.data.push(data.xAxis);
					option.series.shift();

					myChart.setOption({
						xAxis : {
							type : 'category',
							boundaryGap : false,
							data : data.xAxis
						},
						series : [ {
							data : data.scount
						}, {
							data : data.tcount
						}, {
							data : data.rcount
						} ]
					});
				} else {
					alert(data.message);
				}
			}
		});
	});

});