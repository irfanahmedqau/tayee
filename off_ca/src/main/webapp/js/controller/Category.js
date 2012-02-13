Ext.define('CA.controller.Category',{
	extend: 'Ext.app.Controller',
	stores: ['Category'],
	model: ['Category'],
	views: ['category.CategoryTree'],
	
	init: function(){
		this.control({
		
		});
	}
	
});