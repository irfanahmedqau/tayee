Ext.define('AM.model.User', {
    extend: 'Ext.data.Model',
    fields: [
    		 {name: 'id', type: 'string'},
             {name: 'userName', type: 'string'},
             {name: 'age', type: 'int'}
    ],
    proxy :{
    	type: 'rest',
    	url: '/ca/users',
    	reader: {
    		type: 'json',
    		root: 'data'
    	}
    }
});