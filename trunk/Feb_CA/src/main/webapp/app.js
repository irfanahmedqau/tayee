Ext.Loader.setConfig({
			enabled : true,
			paths : {
				'CA' : '/ca/js'
			}
		});
		
		
Ext.application({
			name : 'CA',
			appFolder : '/ca/js',
			launch : function() {
				Ext.create('CA.view.main.MenuToolBar');
				}
		});
