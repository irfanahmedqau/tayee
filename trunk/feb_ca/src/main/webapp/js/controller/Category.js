Ext.define('CA.controller.Category',{
	extend: 'Ext.app.Controller',
	stores: ['Category'],
	model: ['Category'],
	views: ['category.CategoryTree'],
    
	init: function(){
		this.control({
			'categorytree' : 
				{
					
					itemclick : this.expandChild
				}
			
		});
	},
	

	
	expandChild: function(){
		alert('ok1');
	}
	
});

