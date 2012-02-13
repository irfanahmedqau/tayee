Ext.define('AM.controller.Users', {
    extend: 'Ext.app.Controller',
    stores: ['Users'],
    models: ['User'],
	views: ['user.List', 'user.Edit', 'user.Create'],
    init: function() {
        this.control({
            'userlist': {
                itemdblclick: this.showEditUserForm
            },
            'useredit button[action=save]': {
            	click: this.updateUser
            },
            'userlist button[action=create]': {
            	click: this.showCreateUserForm
            },
            'usercreate button[action=save]': {
            	click: this.createUser
            }
        });
    },

    onPanelRendered: function() {
        console.log('The panel was rendered');
    },
    
    showEditUserForm: function(grid, record) {
        var view = Ext.widget('useredit');
        view.down('form').loadRecord(record);
    },
    updateUser: function(button) {
	    var win    = button.up('window'),
	        form   = win.down('form'),
	        record = form.getRecord(),
	        values = form.getValues();
	
	    record.set(values);
	    win.close();
	    this.getUsersStore().sync();
    },
    showCreateUserForm: function() {
    	Ext.widget('usercreate');
    },
    createUser: function(button) {
	    var win    = button.up('window'),
	        form   = win.down('form'),
	        values = form.getValues();
	
	    this.getUsersStore().add(values);
	    win.close();
	    this.getUsersStore().sync();
    }
});