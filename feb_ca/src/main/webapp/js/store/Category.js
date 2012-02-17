Ext.define('CA.store.Category', {
    extend: 'Ext.data.TreeStore',
    model: 'CA.model.Category',
	autoLoad: false,
    proxy:	
    	{
			type: 'rest',
			url: '/ca/loadingCategoryTree',
			reader: 
				{
					type:	'json',
					root:	'data',
					successProperty: 'success'
				}
		},
	 root:
	 	{
			expanded: false,
			text: 'CantonStore',
			id: "10001"
		}
		

	/*
	initComponent: function(){
  		this.store = Ext.data.StoreManager.lookup(this.store);
  		this.callParent(arguments);
	} */
});