Ext.define('App.controller.menu', {
    extend: 'Ext.app.Controller',

    requires: [
        'App.view.menu.Accordion',
        'App.view.MainPanel',
        'App.view.Analise',
        'App.view.Header'
        
    ], 

    //models: ['menu.Root', 'menu.Item' ],
    //stores: ['Menu'],
    views: [
        'menu.Accordion','MainPanel'
        
    ],

    refs: [
        {
            ref: 'mainpanel',
            selector: 'mainviewport #mainpanel',
            
            xtype: 'Ext.tab.Panel'
        }
    ],
     init: function(application) {
        this.control({
            " mainmenu #mainmenuitem": {
            	select: this.onTreepanelSelect
                //itemclick: this.onTreepanelItemClick
                //click:this.onTreepanelSelect
                //render: this.onPanelRender
            },
            " mainmenu #mainmenuitem3": {
                select: this.onTreepanelSelect
                //itemclick: this.onTreepanelItemClick,
                //click:this.onTreepanelSelect
            },
            " mainmenu #mainmenuitem2": {
                select: this.onTreepanelSelect
                //itemclick: this.onTreepanelItemClick,
                //click:this.onTreepanelSelect
            }
        });
    },
    onPanelRender: function(abstractcomponent, options) {
         var menuPanel = Ext.ComponentQuery.query('mainmenu')[0];
        
        var panel = Ext.ComponentQuery.query('appheader displayfield#hora')[0];
        var relogio = {
	    run: function(){
	    	var data = Ext.Date.format(new Date(), 'd/m/Y H:i:s');
	        panel.setValue(data);
	    },
	    interval: 1000 //atualizando a cada 1 segundo
	}
	
	var execucaoRelogio = Ext.create('Ext.util.TaskRunner');
	execucaoRelogio.start(relogio);
         
         //console.log("foi");
         },

    onTreepanelSelect: function(selModel, record, index, options) {
        console.log(record.raw.className);

      // var mainPanel = this.getmainpanel();
       var mainPanel = Ext.ComponentQuery.query('mainpanel')[0];
      
        var newTab = mainPanel.items.findBy(
        function (tab){ 
            return tab.title === record.get('text'); 
        });

        //console.log(record.raw.className);
        var cls = "App.view." +record.raw.className;
         //var tab = tabs.child('#' + record.raw.className);
        if (!newTab){
            
            /*newTab=mainPanel.add(Ext.create(cls, {
                //itemId: record.raw.className
                //title: rec.get('text')
            }));*/
        	newTab = mainPanel.add({
               
            	 
            	
            	xtype: record.raw.className,
            	//items:[{xtype:record.raw.className}],
                closable: true,
                iconCls: record.get('iconCls'),
                autoDestroy:false,
                title: record.get('text')
            });
        }

        mainPanel.setActiveTab(newTab);
    },

    onTreepanelItemClick: function(view, record, item, index, event, options){
        this.onTreepanelSelect(view, record, index, options);
    }

    

});