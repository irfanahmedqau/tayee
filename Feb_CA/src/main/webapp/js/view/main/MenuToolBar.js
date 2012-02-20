Ext.define('CA.view.main.MenuToolBar',{
	extend: 'Ext.toolbar.Toolbar',
	alias : 'widget.menutoolbar',
    title : 'Menu Tool Bar',
   	renderTo: 'menuDiv',
	items :  [
		{
        		text: 'Category',  
                menu: [
                	 {  
                		 text: 'Category Management',
                		 handler: function() { 
                		 	click: window.location.href='/ca/app/category';
                		 }
       	 		 	 }, 
       	 		 	 {  
                		 text: 'Product Management',
                		 handler: function() { 
                			 click: window.location.href='/ca/app/category';
                		 }
           	 	  	 }, 
           	 	  	 {
                		 text: 'Item Management'
                  	 }
              	 ]  
		},
		{
				text: 'Product',
				handler: function() { 
                	click: window.location.href='/ca/app/category';
                 }
		},
		{
				text: 'Item'
		},
		'->',
		{  
                 text: 'Options',  
               	 iconCls: 'options_icon',  
	             menu: [
	             	 {  
           	 			 text: 'User Info'  
                	 }, 
            	 	 {  
                 		 text: 'Settings'  
                 	 },
                 	 {  
               		     text: 'Switch Theme'  
            		 }
        		 ]  
	     }, 
     	 {  
                 text: 'Help'  
         }, 
      	 '-', 
  	 	 {  
        		 text: 'Logout'  
         }
	]
});