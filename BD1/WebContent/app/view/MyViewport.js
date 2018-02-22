Ext.define('App.view.MyViewport', {
extend: 'Ext.container.Viewport', // #1
alias: 'widget.mainviewport', // #2
itemId: 'mainviewport',
requires: [
'App.view.Header','App.view.menu.Accordion','App.view.MainPanel' // #3
],
layout: {
type: 'border' // #4
},
items: [
{
xtype: 'mainmenu',
width: 190,
collapsible: true,
region: 'west'//,
//style: 'background-color: 
},
{
xtype: 'appheader', // #6
region: 'north',
height:70
//style:"background-image:url('img/degrade.png') repeat !important"

},
//{ xtype: 'tabpanel',region: 'center',itemId: 'mainPanel',activeTab: 0,items: [{xtype: 'panel',title: 'Home'}] },
{xtype: 'mainpanel',region: 'center'},
{
xtype: 'container', // #8
region: 'south',
height: 30,
style:'border-top: 1px solid #4c72a4;'
//html: '<div id="titleHeader"><center><span style="fontsize:10px;">Siem  Sistema Integrado Casman </span></center></div>'
}
]
});