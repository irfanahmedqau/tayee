var catTreeStore = Ext.create('Ext.data.TreeStore',{
	model:	'catModel',
	proxy:	{
		type:	'ajax',
		url: 	'/home',
		reader: {
			type:	'json',
			root:	'product'
		}
	},
	listeners:	{
		append: function(thisNode, newChildNode, index, eOpts){
			if( !newChildNode.isRoot() ) { 
				newChildNode.set('leaf', true);          
				newChildNode.set('text', newChildNode.get('name'));    
				newChildNode.set('icon', newChildNode.get('profile_image_url'));           
			} 
		}
	}
});
catTreeStore.setRootNode({
	text: 'Product',
	leaf: false,
	expanded: false
});