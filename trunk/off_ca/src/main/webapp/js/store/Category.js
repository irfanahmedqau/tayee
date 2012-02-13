Ext.define('CA.store.Category', {
    extend: 'Ext.data.Store',
    model: 'CA.model.Category',
	autoLoad: true,
	    proxy:	{
		type: 'rest',
    	url: '/ca/category',
		reader: {
			type:	'json',
			root:	'CantonStore'
		}
	}
});