Ext.Loader.setConfig({
			enabled : true,
			paths : {
				'AM' : '/ca/js'
			}
		});
Ext.application({
			name : 'AM',
			appFolder : '/ca/js',
			controllers : ['Users'],
			launch : function() {
				Ext.create('Ext.container.Viewport', {
							layout : 'border',
							title : 'Ext Layout Browser',
							items : [{
										xtype : 'box',
										id : 'header',
										region : 'north',
										html : '<h1> Ext.Layout.Browser</h1>',
										height : 30
									}, {
										xtype : 'userlist',
										region: 'center'
									}]
						})

			}
		});
