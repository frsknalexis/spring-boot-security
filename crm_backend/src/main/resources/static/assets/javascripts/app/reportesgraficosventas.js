
(function( $ ) {

	'use strict';

	/*
	Flot: Bars
	*/
	(function() {
		var plot = $.plot('#flotBars', [flotBarsData], {
			colors: ['#8CC9E8'],
			series: {
				bars: {
					show: true,
					barWidth: 0.8,
					align: 'center'
				}
			},
			xaxis: {
				mode: 'categories',
				tickLength: 0
			},
			grid: {
				hoverable: true,
				clickable: true,
				borderColor: 'rgba(0,0,0,0.1)',
				borderWidth: 1,
				labelMargin: 15,
				backgroundColor: 'transparent'
			},
			tooltip: true,
			tooltipOpts: {
				content: '%y',
				shifts: {
					x: -10,
					y: 20
				},
				defaultTheme: false
			}
		});
	})();

	/*
	Morris: Line
	*/
	Morris.Line({
		resize: true,
		element: 'morrisLine',
		data: morrisLineData,
		xkey: 'y',
		ykeys: ['a', 'b'],
		labels: ['Series A', 'Series B'],
		hideHover: true,
		lineColors: ['#0088cc', '#734ba9'],
	});

	/*
	Morris: Donut
	*/
	Morris.Donut({
		resize: true,
		element: 'morrisDonut',
		data: morrisDonutData,
		colors: ['#0088cc', '#734ba9', '#E36159']
	});

	/*
	Morris: Bar
	*/
	Morris.Bar({
		resize: true,
		element: 'morrisBar',
		data: morrisBarData,
		xkey: 'y',
		ykeys: ['a', 'b'],
		labels: ['Series A', 'Series B'],
		hideHover: true,
		barColors: ['#0088cc', '#2baab1']
	});

	/*
	Morris: Area
	*/
	Morris.Area({
		resize: true,
		element: 'morrisArea',
		data: morrisAreaData,
		xkey: 'y',
		ykeys: ['a', 'b'],
		labels: ['Series A', 'Series B'],
		lineColors: ['#0088cc', '#2baab1'],
		fillOpacity: 0.7,
		hideHover: true
	});

	/*
	Morris: Stacked
	*/
	Morris.Bar({
		resize: true,
		element: 'morrisStacked',
		data: morrisStackedData,
		xkey: 'y',
		ykeys: ['a', 'b'],
		labels: ['Series A', 'Series B'],
		barColors: ['#0088cc', '#2baab1'],
		fillOpacity: 0.7,
		smooth: false,
		stacked: true,
		hideHover: true
	});
	
	/*
	Sparkline: Line
	*/
	$("#sparklineLine").sparkline(sparklineLineData, {
		type: 'line',
		width: '80',
		height: '30',
		lineColor: '#0088cc'
	});

	/*
	Sparkline: Bar
	*/
	$("#sparklineBar").sparkline(sparklineBarData, {
		type: 'bar',
		width: '80',
		height: '30',
		barColor: '#0088cc',
		negBarColor: '#B20000'
	});

	/*
	Sparkline: Tristate
	*/
	$("#sparklineTristate").sparkline(sparklineTristateData, {
		type: 'tristate',
		width: '80',
		height: '30',
		posBarColor: '#0088cc',
		negBarColor: '#B20000'
	});

	/*
	Sparkline: Discrete
	*/
	$("#sparklineDiscrete").sparkline(sparklineDiscreteData, {
		type: 'discrete',
		width: '80',
		height: '30',
		lineColor: '#0088cc'
	});

	/*
	Sparkline: Bullet
	*/
	$("#sparklineBullet").sparkline(sparklineBulletData, {
		type: 'bullet',
		width: '80',
		height: '30',
		targetColor: '#ff7f00',
		performanceColor: '#0088cc'
	});

	/*
	Sparkline: Pie
	*/
	$("#sparklinePie").sparkline(sparklinePieData, {
		type: 'pie',
		height: '30',
		barColor: '#0088cc'
	});

}).apply( this, [ jQuery ]);