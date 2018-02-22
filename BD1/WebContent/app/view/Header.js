Ext.define('App.view.Header', {
	extend : 'Ext.toolbar.Toolbar',
	alias : 'widget.appheader',
	cls : 'your-css',
	height : 30,
	ui : 'footer',
	style : 'border-bottom: 4px solid #4c72a4; ',
	//style: "background-image:url('img/degrade.png') !important",
	items : [

	{
		xtype : 'label',
		// iconCls:'logo',
		html : '<div id="titleHeader"> &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;   <span style="font-size:18px;"> Analise risco cliente</span></div>'

	}, {
		xtype : 'tbfill'
	}
		]
	
});