Ext.define('Ca.view.category.CategoryTree',{
	extend: 'Ext.tree.Panel',
	alias: 'widget.categorytree',
	store: 'Category',
	title: 'Category',
    width: 200,
    height: 600,
    autoShow: true,
    rootVisible: true,
    region : 'west',
    
    initComponent: function(){
    	this.tools = [{
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
				}];
		this.dockedItems = [{
			    	xtype:'toolbar',
			    	dock: 'top',
			    	items: [{
			    		text: 'Add Category',
			    		handler: function(){
			    			catTree.expandAll();
			    		}
			    	},{
			    		text: 'Delete Catecory',
			    		handler: function(){
			    			 catTree.collapseAll();
			    		}
			    	}]
			    }];
	    this.callParent(arguments);
    }
});