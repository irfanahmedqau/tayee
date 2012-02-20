Ext.Loader.setConfig({
			enabled : true,
			paths : {
				'CA' : '/ca/js'
			}
		});
		
Ext.application({
			name : 'CA',
			appFolder : '/ca/js',
			controllers : ['Category'],
			launch : function() {
				//alert('ok');
				Ext.create('CA.view.category.CategoryPanel');
				}
		});