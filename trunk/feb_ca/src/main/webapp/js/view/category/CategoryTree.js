Ext.define('CA.view.category.CategoryTree',{
	extend: 'Ext.tree.Panel',
	alias: 'widget.categorytree',
	store: 'Category',
	title: 'Category',
    width: 200,
    height: 600,
    autoShow: true,
    animate: true,
    useArrows: true,
    viewConfig: {
            plugins: {
                ptype: 'treeviewdragdrop'
            }
        },
    rootVisible: true,
    initComponent: function(){
    	
		this.dockedItems = [{
			    	xtype:'toolbar',
			    	dock: 'top',
			    	items: [{
			    		text: 'Add Category',
			    		handler: function(){
			    			
			    		}
			    	},{
			    		text: 'Delete Catecory',
			    		handler: function(){
			    			 
			    		}
			    	}]
			    }];
	    this.callParent(arguments);
    }
});