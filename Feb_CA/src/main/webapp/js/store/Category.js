Ext.define('CA.store.Category', {
    extend: 'Ext.data.TreeStore',
    model: 'CA.model.Category',
	autoLoad: true,
	proxy:	
    	{
			type: 'rest',
			url: '/ca/CategoryTree',
			reader: 
				{
					type:	'json',
					root:	'data',
					successProperty: 'success'
				}
		},
	 root:
	 	{
			expanded: true,
			text: 'CantonStore'
		}	
	/*
	initComponent: function(){
  		this.store = Ext.data.StoreManager.lookup(this.store);
  		this.callParent(arguments);
	} */
});