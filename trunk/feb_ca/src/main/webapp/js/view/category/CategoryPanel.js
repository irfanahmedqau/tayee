Ext.define('CA.view.category.CategoryPanel',{
	extend: 'Ext.Viewport',
	alias: 'widget.categorypanel',
	layout: 'border',
	requires: ['CA.view.category.CategoryTree'],
	renderTo: 'categoryPanelDiv',
	autoShow: true,
	items: [
		  catTree = Ext.create('CA.view.category.CategoryTree',{
    				region: 'west',
    				tools: [
    					{
						    type:'expand',
						    tooltip: 'expand all the category',
						    handler: function(event, toolEl, panel){
				   				catTree.expandAll();
						    		}
						},
						{
				   			 type:'collapse',
				  		     tooltip: 'collapse all the category',
				  		     handler: function(event, toolEl, panel){
				       			catTree.collapseAll();
				    			}
						}]
    			})

            ,
    		{
		        region: 'center',
		        xtype: 'tabpanel', // TabPanel itself has no title
		        activeTab: 0,      // First tab active by default
		        items: [
		        	{
		            	title: 'General Information',
		            	html: 'The first tab\'s content. Others may be added dynamically'
		       		 },
	       		 	{
		        	title: 'Category Products',
		            html: 'The first tab\'s content. Others may be added dynamically'
		        	}
	        	]
            }
        ]

});
    
    
    