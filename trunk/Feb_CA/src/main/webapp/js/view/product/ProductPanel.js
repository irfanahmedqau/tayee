Ext.define('Ca.view.main.ProductPanel',{
	extend: 'Ext.tree.Panel',
	alias: 'widget.productpanel',
	layout: 'border',
	requires: ['Ca.view.category.CategoryTree'],
    initComponent: function(){
    	this.items = [{
		        region: 'center',
		        xtype: 'tabpanel', // TabPanel itself has no title
		        activeTab: 0,      // First tab active by default
		        items: [
		        	Ext.create('Ca.view.category.CategoryTree'),
		        		{
		            title: 'General Information',
		            html: 'The first tab\'s content. Others may be added dynamically'
		        },{
		        	title: 'Category Products',
		            html: 'The first tab\'s content. Others may be added dynamically'
		        }]
            }];
	    this.callParent(arguments);
    }
});