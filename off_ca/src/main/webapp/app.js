Ext.Loader.setConfig({
			enabled : true,
			paths : {
				'CA' : '/ca/js'
			}
		});
		
		
Ext.application({
			name : 'CA',
			appFolder : '/ca/js',
			controllers : ['Main'],
			launch : function() {
						Ext.create('Ext.container.Viewport', {
											alias : 'widget.viewport',
										    layout: 'border',
										    items: [{
											    	split: false,
											        region: 'north',
											        border: false ,
							                        tbar: [{  
										                     text: 'Commerce',  
										                     menu: [{  
										                         text: 'Category Management',  
										                         handler: function() { // 
										                          //   Ext.getCmp('content-panel').layout.setActiveItem('category-panel'); 
										                        		 }  
										                   	 	 }, {  
										                         text: 'Product Management', 
										                         iconCls: 'icon-send',
										                         handler: function() {
										                         //	Ext.getCmp('content-panel').layout.setActiveItem('product-panel'); 
										                        			 }
										                   	 	 },{
										                    	 text: 'Item Management',
										                    	 iconCls: 'icon-print',
										                    	 handler: function(){
										                    	 //	Ext.getCmp('content-panel').layout.setActiveItem('item-panel');
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
											    	 }, {
										        		region: 'south',
										       		    title: 'South Panel',
										       		    collapsible: true,
										     		    html: 'Information goes here',
										       		    split: true,
										       		    height: 100,
										      		    minHeight: 100
										   			 }, {
								            			 id: 'content-panel',
									        			 region: 'center', // this is what makes this panel into a region within the containing layout
									        			 layout: 'card',
									        			 margins: '2 5 5 0',
									       				 // activeItem: 1,
									       				  border: false
									     				  //  items: layoutInstances
										    }],
										    renderTo: 'mainDiv'
										});
										


			}
		});
