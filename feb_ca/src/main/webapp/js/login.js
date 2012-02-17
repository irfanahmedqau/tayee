Ext.require([ 'Ext.form.*' ]);
Ext.onReady(function() {
	var loginForm = Ext.create('Ext.form.Panel', {
		url : formAction,
		frame : true,
		title : 'CA Login',
		bodyStyle : 'padding:5px 5px 0',
		width : 350,
		fieldDefaults : {
			msgTarget : 'side',
			labelWidth : 75
		},
		defaultType : 'textfield',
		defaults : {
			anchor : '80%'
		},

		items : [ {
			fieldLabel : 'User Name',
			name : 'userName',
			allowBlank : false
		}, {
			fieldLabel : 'Password',
			name : 'password',
			inputType: 'password',
			allowBlank : false
		} ],

		buttons : [ {
			text : 'Save',
			handler : function() {
				var form = this.up('form').getForm();
				form.standardSubmit = true;
				if (form.isValid()) {
					form.submit();
				}
			}
		}, {
			text : 'Cancel'
		} ]
	});
	loginForm.render(document.getElementById('center_wrapper'));
});