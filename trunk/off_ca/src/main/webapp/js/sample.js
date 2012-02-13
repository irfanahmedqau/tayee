Ext.onReady(function() {
	var contentPanel = {
		id : 'content-panel',
		region : 'center', // this is what makes this panel into a region
							// within the containing layout
		layout : 'card',
		margins : '2 5 5 0',
		activeItem : 0,
		border : false,
		items : [ {
			xtype : 'tabpanel',
			activeTab : 0,
			items : [ {
				title : 'Tab1',
				html : 'This is the tab 1.'
			}, {
				title : 'Tab2',
				html : 'This is the tab 2.'
			}, {
				title : 'Tab3',
				html : 'This is the tab 3.'
			} ]
		} ]
	};
	Ext.create('Ext.Viewport', {
		layout : 'border',
		title : 'Ext Layout Browser',
		items : [ {
			xtype : 'box',
			id : 'header',
			region : 'north',
			html : '<h1> Ext.Layout.Browser</h1>',
			height : 30
		}, contentPanel ],
		renderTo : Ext.getBody()
	});
});