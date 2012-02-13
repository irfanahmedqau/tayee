Ext.define('AM.view.user.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlist',
	store: 'Users',
    title : 'All Users',
	buttons: [{text: 'New User', action: 'create'}],
    initComponent: function() {
        this.columns = [
            {header: 'Name',  dataIndex: 'userName',  flex: 1},
            {header: 'Age', dataIndex: 'age', flex: 1}
        ];

        this.callParent(arguments);
    }
});