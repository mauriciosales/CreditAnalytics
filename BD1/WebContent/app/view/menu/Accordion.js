var store1 = Ext.create('Ext.data.TreeStore', {
    root: {
        expanded: true,
        children: [
            { text: "Treinamento", leaf: true,iconCls:'menucadastro',className:'' },
           	{ text:'Analise', leaf: true,iconCls:'menuentrada' ,className:'analise' }
            ]
    }
});

Ext.define('App.view.menu.Accordion', {
			extend : 'Ext.panel.Panel',
			
			alias : 'widget.mainmenu',
			
			width : 185,
			 //requires: ['App.store.ItemStoreEntrada'],
			//requires : [],
            //stores:['storeentrada'],
			//uses:['App.store.ItemStoreEntrada'],
			layout : {
				type : 'accordion'
			},
			
			
			collapsible : true,
			
			hideCollapseTool : false,
			
			iconCls : 'sitemap',
			
			title : 'Menu',
			
			items: [
        Ext.create('Ext.tree.Panel', {
       // alias:'widget.mainmenuitem',
        //id: 'tree-1',
        itemId:'mainmenuitem',
        store:store1 ,//Ext.create('App.store.ItemStoreEntrada'),
        title: 'Analise de risco',
        iconCls:'panelmovimento',
        rootVisible: false,
        layout: 'fit',
        draggable: false
    })
        ]
		});