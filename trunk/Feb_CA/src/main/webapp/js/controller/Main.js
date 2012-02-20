Ext.define('CA.controller.Main',{
	extend: 'Ext.app.Controller',
	refs: [
        {
            ref: 'viewport',
            selector: 'Viewport'
        }
    ],
	
	init: function(){
		this.control({
			'viewport': {
				render: this.onPanelRendered
			}
		});
	},
	
	onPanelRendered: function() {
      //  console.log('The panel was rendered');
    }
	
});