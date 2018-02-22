Ext.define('App.view.MainPanel', {
extend: 'Ext.tab.Panel',
alias: 'widget.mainpanel',
itemId:'mainPanel',
activeTab: 0,
items: [
{
xtype: 'tabpanel',
closable: true,
 autoDestroy: false,
iconCls: 'home',
//cls : 'x-splash-icon',
title: 'Home'
}
]
});