Ext.define('CA.controller.Category',{
	extend: 'Ext.app.Controller',
	stores: ['Category'],
	model: ['Category'],
	views: ['category.CategoryTree', 'category.InformationForm'],
   
	refs: [
        {
            ref: 'form',
            selector: 'informationform'
        }
    ],
    
	init: function(){
		this.control({
			
			'categorytree' : 
			{
				itemclick : this.setSelectedTree
			},
			'informationform button[action=save]' :
			{
				click: this.addCategory
			},
			'informationform button[action=reset]' :
			{
				click: this.resetForm
			}
			
		});
	},
	

	
	loadingCategoryTree: function(){
		//this.getStore('Category').load();
	},
	
	setSelectedTree: function(view,record,item,index,e){
		Ext.select("textfield[name=parentCategoryName]").text="df";
	//	alert("点击的节点ID是："+record.raw.id+",文字是："+record.raw.text);
	//	Ext.ModelManager.getModel('Category')
		//var catModel = Ext.ModelManager.look('CA.model.Category');
		var panelModel = view.getSelectionModel();
		alert(panelModel);
		//panelModel.set('parentID',record.raw.id);
	//	catModel.set('parentID',record.raw.id);
	//	e.getCategoryModel().set('parentID',record.raw.id);
	},
	
	addCategory: function(button) {
	    var form = button.up('form').getForm();
	    if (form.isValid()){
	    	form.submit({
	    	waitMsg: 'saving',
	    	waitTitle: 'info',
	    	method: 'POST',
	    	url: '/ca/CategoryTree',
	    	success: function(form, action) {
	    		Ext.Msg.alert('tip','save succeed');
	    	},
	    	failure: function(form, action) {
	    		Ext.Msg.alert('tip', 'caused: ' + action.result.errors.info);
	    	}
			});
	    }
	    
	},
	resetForm: function(button){
		button.up('form').getForm().reset();
	}
});

