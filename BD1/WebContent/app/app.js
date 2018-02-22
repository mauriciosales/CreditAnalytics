Ext.require('Ext.container.Viewport');
Ext.Loader.setConfig({
   enbled:true,
   paths:{
      'Ext':'extjs4/src'
      //'App.util':'App.util.Util'
   }
})
Ext.application({
			name : 'App',

			appFolder : 'app',
			
			requires : [ 'App.view.menu.Accordion', 'Ext.tree.Panel'],
			
			//views : [''],
			
			controllers : ['App.controller.Analise','App.controller.menu'],

			init : function() {
			},

			launch : function() {
				Ext.tip.QuickTipManager.init();
				Ext.create('App.view.MyViewport');
			}
		});