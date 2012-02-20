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
    				split: true,
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
            	region: 'east',
            	html: 'east area',
            	width: 150,
            	collapsible: true,
            	split: true
            },
            {
            	region: 'south',
            	html: 'south area',
            	height: 150,
            	collapsible: true,
            	split: true
            },
    		
				Ext.create('CA.view.category.InformationForm',{
					region: 'center'
					
				})
        ]

});
    
    
    