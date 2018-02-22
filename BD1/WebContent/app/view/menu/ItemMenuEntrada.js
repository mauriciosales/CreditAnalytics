Ext.define('App.view.menu.Entrada',{

	extend: 'Ext.tree.Panel',
    alias: 'widget.grouppermissions',

    requires: ['App.store.ItemStoreEntrada'],

    title: 'Entrda',
    rootVisible: false,
    useArrows: true,
    frame: false,
    viewConfig: {
	    markDirty: false
	},

    store: Ext.create('App.store.ItemStoreEntrada')

});
