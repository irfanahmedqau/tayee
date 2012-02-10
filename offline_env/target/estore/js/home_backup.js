



Ext.onReady( 
	function (){
	
	Ext.Loader.setConfig({enabled:true});//开启动态加载
	//var contextPath = '<%=request.getContextPath()%>';
	
	var catTreeDefStore = Ext.create('Ext.data.TreeStore', {
    root: {
        expanded: true,
        children: [
            { text: "detention", leaf: true },
            { text: "homework", expanded: true, children: [
                { text: "book report", leaf: true },
                { text: "alegrbra", leaf: true}
            ] },
            { text: "buy lottery tickets", leaf: true }
        ]
    }
});

//model
Ext.define('catModel',{
	extend: 'Ext.data.Model',
	fields: [
		{name:'categoryID', type: 'string'},
		{name:'categoryName', type: 'string'}
		]
});
//store

var catTreeStore = Ext.create('Ext.data.TreeStore',{
	model:	'catModel',
	proxy:	{
		type:	'ajax',
		url: 	'./loadingCategory',
		reader: {
			type:	'json',
			root:	'CantonStore'
		}
	},
	root: {
		expanded: true,
		text: 'CantonStore',
		id: "10001"
	},
	folderSort: true,
	sorters: [{
		property: 'text',
		direction: 'ASC'
	}] 
	/*listeners:	{
		append: function(thisNode, newChildNode, index, eOpts){
			if( !newChildNode.isRoot() ) { 
				newChildNode.set('leaf', false);          
				newChildNode.set('text', newChildNode.get('categoryName'));    
				newChildNode.set('icon', newChildNode.get('profile_image_url'));           
			} 
		}
	}*/
});
/*catTreeStore.setRootNode({
	text: 'ContonStore',
	leaf: false,
	expanded: false
});*/

var catTree = Ext.create('Ext.tree.Panel', {
			    title: 'Category',
			    width: 200,
			    height: 150,
			    store: catTreeStore,
			    rootVisible: true,
			    region : 'west',
			    dockedItems:[{
			    	xtype:'toolbar',
			    	items: [{
			    		text: 'Expand',
			    		handler: function(){
			    			catTree.expandAll();
			    		}
			    	},{
			    		text: 'Collapse',
			    		handler: function(){
			    			 catTree.collapseAll();
			    		}
			    	}]
			    }]
});
	//main layout
    var viewport =	Ext.create('Ext.container.Viewport', {
				    layout: 'border',
				    items: [{
				    	split: false,
				        region: 'north',
				        border: false ,
                        tbar: [{  
			                     text: 'Commerce',  
			                     menu: [{  
			                         text: 'Category Management',  
			                         handler: function() { // adding a handler to "Add New X" menu item  
			                             Ext.Msg.alert('Alert', 'Add new X item!');  
			                         }  
			                     }, {  
			                         text: 'Product Management'  
			                     },{
			                    	 text: 'Item Management'
			                     }]  
			                }, {  
			                     text: 'Refresh'  
			                }, {  
			                     text: 'Tools'  
			                }, '->', {  
			                     text: 'Options',  
			                     iconCls: 'options_icon',  
			                     menu: [{  
			                         text: 'User Info'  
			                     }, {  
			                        text: 'Settings'  
			                     }, {  
			                         text: 'Switch Theme'  
			                     }]  
			                 }, {  
			                     text: 'Help'  
			                 }, '-', {  
			                     text: 'Logout'  
			                }] 

				       // margins: '0 0 5 0'
				    	}, 
				        catTree,
				        {
				        // could use a TreePanel or AccordionLayout for navigational items, {
				        region: 'south',
				        title: 'South Panel',
				        collapsible: true,
				        html: 'Information goes here',
				        split: true,
				        height: 100,
				        minHeight: 100
				    }, {
				        region: 'east',
				        title: 'East Panel',
				        collapsible: true,
				        split: true,
				        width: 150
				    }, {
				        region: 'center',
				        xtype: 'tabpanel', // TabPanel itself has no title
				        activeTab: 0,      // First tab active by default
				        items: [{
				            title: 'Default Tab',
				            html: 'The first tab\'s content. Others may be added dynamically'
				        },{
				        	title: 'Second Tab',
				            html: 'The first tab\'s content. Others may be added dynamically'
				        }]
				    }],
				    renderTo: divExample
				});
	viewport.show();
	//catTreeDefStore.getRootNode().appendChild(catTreeStore.getRootNode()).expand(); 
	}
);


