Ext.onReady(showWin2);
/*function fn(){
	//Ext.MessageBox.alert("hello","HelloWorld");
	var filterPanel = Ext.create('Ext.panel.Panel', {
    bodyPadding: 5,  // Don't want content to crunch against the borders
    width: 300,
    title: 'Filters',
    items: [{
        xtype: 'datefield',
        fieldLabel: 'Start date'
    }, {
        xtype: 'datefield',
        fieldLabel: 'End date'
    }],
    renderTo: Ext.getBody()
});

}*/

function showWin2(){
	      Ext.create('Ext.window.Window', {
          title: 'Hello',
          height: 200,
          width: 400,
          layout: 'fit',
          items: {  // Let's put an empty grid in just to illustrate fit layout
              xtype: 'grid',
              border: false,
              columns: [{header: 'World'},{header:'China'}],                 // One header just for show. There's no data,
              store: Ext.create('Ext.data.ArrayStore', {}) // A dummy empty data store
          }
     }).show();
     	Ext.get("btnAlert").on("click",a,this,{delay:2000});
     	Ext.get("btnAlert").on("click",a);
     	
     	function a(){
     		alert("some thing");
     	}
}
/*function showWin(){
	var win = new Ext.Window({
	title:"hello",
	width:300,
	height:200,
	html:'<h1>Hello,easyjfopensource</h1>'
	});
	//win.show();
}
*/
/*function tabPanel() {
	var panel = new Ext.TabPanel({
	renderTo : Ext.getBody(),
	width :300,
	height : 200,
	activeTab:0,
	items : [new Ext.Panel({
					title : "面板1",
					height : 30,
					html : '面板1'
			}), new Ext.Panel()({
					title:'面板2',
					height : 30,
					html : '面板2'
			}), new Ext.Panel({
					title : '面板3',
					height : 30,
					html: '面板1'
			})]
	});
}*/

/*
Ext.require('Ext.container.Viewport');
Ext.application({
    name: 'HelloExt',
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
                {
                    title: 'Hello Ext1',
                    html : 'Hello! Welcome to Ext JS.'
                }
            ]
        });
    }
});*/