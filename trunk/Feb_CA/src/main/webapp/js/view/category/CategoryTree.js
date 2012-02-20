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
    collapsible: true,
    viewConfig: {
            plugins: {
                ptype: 'treeviewdragdrop'
            }
        },
    rootVisible: false,
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
  	//	var store = Ext.data.StoreManager.lookup(this.store);
  	//	store.load();
	    this.callParent(arguments);
    }
});