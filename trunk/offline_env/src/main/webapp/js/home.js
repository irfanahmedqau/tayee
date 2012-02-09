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
			    height: 600,
			    store: catTreeStore,
			    tools:[{
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
				}],
			    rootVisible: true,
			    region : 'west',
			    dockedItems:[{
			    	xtype:'toolbar',
			    	dock: 'top',
			    	items: [{
			    		text: 'Add',
			    		handler: function(){
			    			catTree.expandAll();
			    		}
			    	},{
			    		text: 'Del',
			    		handler: function(){
			    			 catTree.collapseAll();
			    		}
			    	}]
			    }]
});

function getLayoutInstances(){
	return {
		CategoryLayout: {
			id:'category-panel',
         //   title: 'Category Management',
            layout: 'border',
            bodyBorder: false,
         /*   defaults: {
                collapsible: true,
                split: true,
                animFloat: false,
                autoHide: false,
                useSplitTips: true,
                bodyStyle: 'padding:15px'
            },*/
            items: [
        		catTree,
            {
		        region: 'center',
		        xtype: 'tabpanel', // TabPanel itself has no title
		        activeTab: 0,      // First tab active by default
		        items: [{
		            title: 'General Information',
		            html: 'The first tab\'s content. Others may be added dynamically'
		        },{
		        	title: 'Category Products',
		            html: 'The first tab\'s content. Others may be added dynamically'
		        }]
            }]
		},
		
		ProductLayout: {
            id:'product-panel',
            title: 'Product Layout',
            layout:'anchor',
            defaults: {bodyStyle: 'padding:15px'},
            items: [{
                title: 'Panel 1',
                height: 100,
                anchor: '50%',
                html: '<p>Width = 50% of the container</p>'
            },{
                title: 'Panel 2',
                height: 100,
                anchor: '-100',
                html: '<p>Width = container width - 100 pixels</p>'
            },{
                title: 'Panel 3',
                anchor: '-10, -262',
                html: '<p>Width = container width - 10 pixels</p><p>Height = container height - 262 pixels</p>'
            }]
        },
        
        ItemLayout: {
            id: 'item-panel',
            title: 'Accordion Layout',
            layout: 'accordion',
            bodyStyle: 'background-color:#DFE8F6',  // if all accordion panels are collapsed, this looks better in this layout
            defaults: {bodyStyle: 'padding:15px'},
            items: [{
                title: 'Introduction',
                tools: [{type:'gear'},{type:'refresh'}],
                html: '<p>Here is some accordion content.  Click on one of the other bars below for more.</p>'
            },{
                title: 'Basic Content',
                html: '<br /><br /><p>More content.  Open the third panel for a customized look and feel example.</p>',
                items: {
                    xtype: 'button',
                    text: 'Show Next Panel',
                    handler: function(){
                        Ext.getCmp('acc-custom').expand(true);
                    }
                }
            },{
                id: 'acc-custom',
                title: 'Custom Panel Look and Feel',
                cls: 'custom-accordion', // look in layout-browser.css to see the CSS rules for this class
                html: '<p>Here is an example of how easy it is to completely customize the look and feel of an individual panel simply by adding a CSS class in the config.</p>'
            }]
       	}
	};
}

Ext.onReady( 
	function (){

    Ext.Loader.setConfig({enabled:true});//开启动态加载
    var layoutInstances = [];
    Ext.Object.each(getLayoutInstances(), function(name, example) {
        layoutInstances.push(example);
    });
    
    
    
	/*	
	var person = { name: 'Jacky' ,
 				  hairColor: 'black', loves: ['food', 'sleeping', 'wife'] 
 	}; 
 	Ext.Object.each(person, function(key, value, myself) {
 		console.log(key + ":" + value); 
 		if (key === 'hairColor1') { 
 			return false; // stop the iteration
 			} }); 
 
    */
	
	//var contextPath = '<%=request.getContextPath()%>';
	
	var contentPanel = {
         id: 'content-panel',
         region: 'center', // this is what makes this panel into a region within the containing layout
         layout: 'card',
         margins: '2 5 5 0',
        // activeItem: 1,
         border: false,
         items: layoutInstances
    };

//model
Ext.define('catModel',{
	extend: 'Ext.data.Model',
	fields: [
		{name:'categoryID', type: 'string'},
		{name:'categoryName', type: 'string'}
		]
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
			                             Ext.getCmp('content-panel').layout.setActiveItem('category-panel'); 
			                         }  
			                     }, {  
			                         text: 'Product Management', 
			                         iconCls: 'icon-send',
			                         handler: function() {
			                         	Ext.getCmp('content-panel').layout.setActiveItem('product-panel'); 
			                         }
			                     },{
			                    	 text: 'Item Management',
			                    	 iconCls: 'icon-print',
			                    	 handler: function(){
			                    	 	Ext.getCmp('content-panel').layout.setActiveItem('item-panel');
			                    	 }
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
				    	}, {
				        // could use a TreePanel or AccordionLayout for navigational items, {
				        region: 'south',
				        title: 'South Panel',
				        collapsible: true,
				        html: 'Information goes here',
				        split: true,
				        height: 100,
				        minHeight: 100
				    }, 
				    contentPanel
				    ],
				    renderTo: divExample
				});
	viewport.show();
	
/*	Ext.Object.each(getBasicLayouts(), function(name, example) {
        layoutExamples.push(example);
    });*/
	//catTreeDefStore.getRootNode().appendChild(catTreeStore.getRootNode()).expand(); 
	}
);


