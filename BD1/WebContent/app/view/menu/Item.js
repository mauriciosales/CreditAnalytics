var store = Ext.create('Ext.data.TreeStore', {
    root: {
        expanded: true,
        children: [
            { text: "Cadastro", leaf: true },
            { text: "Pesquisa", leaf: true},
            { text: "Movimento", leaf: true }
        ]
    }
});

Ext.create('Ext.tree.Panel', {
    title: 'Entrada',
    width: 200,
    height: 150,
    store: store,
    rootVisible: false,
    renderTo: Ext.getBody()
});