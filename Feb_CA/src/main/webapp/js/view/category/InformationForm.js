Ext.define('CA.view.category.InformationForm',{
	extend: 'Ext.form.Panel',
	alias: 'widget.informationform',
	layout: 'fit',
    border: false,
    bodyBorder: false,
    formBind: true,
    height: 200,
    fieldDefaults: {
        labelWidth: 75,
        msgTarget: 'side'
    },
    defaults: {
        anchor: '100%'
    },
    items: 
    	{
            xtype:'tabpanel',
            activeTab: 0,
            defaults:{
                bodyStyle:'padding:10px'
            },

            items:[{
                title:'基本信息',
                defaults: {width: 900},
                defaultType: 'textfield',
                items: [
               		 {
                    	fieldLabel: '上级类别名',
                    	name: 'parentCategoryName',
	                    allowBlank:false
               		 },
                	 {
                    	fieldLabel: 'Category ID',
                    	name: 'categoryCode',
	                    allowBlank:false,
	                    value: '10010',
	                    blankText : 'Category ID 不能为空'
               		 },
               		 {
                    	fieldLabel: 'Category Name',
                   	    name: 'categoryName',
                   	    allowBlank:false,
                    	value: 'Spencer',
                    	blankText : 'Category Name 不能为空'
                      },
                      {
		          	    xtype: 'textareafield',
		                name: '描述',
		                fieldLabel: 'Description',
		                value: 'This is description for this category'
        		       }
        		 ]
        	 }],
        buttons: [{
            text: 'Save',
            action: 'save'
        },{
            text: 'Reset',
            action: 'reset'
        },{
        	text: 'Cancel',
            action: 'cancel'
        }]
    }
});