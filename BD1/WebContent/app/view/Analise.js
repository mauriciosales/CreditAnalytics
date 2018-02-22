Ext.define('App.view.Analise', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.analise',
    itemId:'analise',
    closable:false,
    height: 290,
    width: 570,
    closeAction:'destroy',
   // requires: ['Packt.util.Util'],
requires:[],
    layout: {
        align: 'stretch',
        type: 'vbox'
    },
    title: 'User',

    items: [
        {
            xtype: 'form',
            bodyPadding: 5,
            layout: {
                type: 'hbox',
                align: 'stretch'
            },
            items: [
                {
                    xtype: 'fieldset',
                    flex: 2,
                    title: 'Entrada',
                    defaults: {
                        //afterLabelTextTpl: Packt.util.Util.required,
                        anchor: '100%',
                        xtype: 'textfield',
                        allowBlank: false,
                        labelWidth: 120
                    },
                    items: [
                         {
									xtype : 'combobox', //9
									fieldLabel : 'Sexo',
									name:'c.sexo',
									
									flex : 2,
									displayField : 'name',
									valueField:'value',
									blankText :'Este campo precisa ser prenchido ',
									valueNotFoundText :'Valor não corresponde',
									forceSelection:true,
									autoSelect :true,
									store : Ext.create('Ext.data.Store', {
												fields : [
															'value',
															'name'
														],
												data : [{
															"name" : "Masculino","value":"M"
														}, {
															"name" : "Feminino" , "value":"F"
														}]
											}),
									queryMode : 'local',
								allowBlank : false ,
									typeAhead : true
								},{
									xtype : 'combobox', //9
									fieldLabel : 'Idade',
									name:'c.idade',
									
									flex : 2,
									displayField : 'name',
									valueField:'value',
									blankText :'Este campo precisa ser prenchido ',
									valueNotFoundText :'Valor não corresponde',
									forceSelection:true,
									autoSelect :true,
									store : Ext.create('Ext.data.Store', {
												fields : [
															'value',
															'name'
														],
												data : [{
															"name" : "(16 - 25)","value":"0"
														}, {
															"name" : "(26 - 30)" , "value":"1"
														},{
															"name" : "(31 - 40)","value":"2"
														}, {
															"name" : "(41 - 49)" , "value":"3"
														},{
															"name" : "(50 - 70)","value":"4"
														}, {
															"name" : "(71 - 100)" , "value":"5"
														}]
											}),
									queryMode : 'local',
								allowBlank : false ,
									typeAhead : true
								},{
									xtype : 'combobox', //9
									fieldLabel : 'Escolaridade',
									name:'c.escolaridade',
									
									flex : 2,
									displayField : 'name',
									valueField:'value',
									blankText :' ',
									valueNotFoundText :'Valor não corresponde',
									forceSelection:true,
									autoSelect :true,
									store : Ext.create('Ext.data.Store', {
												fields : [
															'value',
															'name'
														],
												data : [{
															"name" : "Ensino Medio Completo","value":"Ensino Medio Completo"
														}, {
															"name" : "Ensino Superior Completo" , "value":"Ensino Superior Completo"
														},{
															"name" : "Ensino Medio Imcompleto","value":"Ensino Medio Imcompleto"
														}]
											}),
									queryMode : 'local',
								allowBlank : false ,
									typeAhead : true
								},{
									xtype : 'combobox', //9
									fieldLabel : 'Rendimentos',
									name:'c.rendimentos',
									
									flex : 2,
									displayField : 'name',
									valueField:'value',
									blankText :' ',
									valueNotFoundText :'Valor não corresponde',
									forceSelection:true,
									autoSelect :true,
									store : Ext.create('Ext.data.Store', {
												fields : [
															'value',
															'name'
														],
												data : [{
															"name" : "Um salario Minimo","value":"Um salario Minimo"
														}, {
															"name" : "Acima de tres salarios minino" , "value":"Acima de tres salarios minino"
														},{
															"name" : "Dois salarios minino","value":"Dois salarios minino"
														}]
											}),
									queryMode : 'local',
								allowBlank : false ,
									typeAhead : true
								},{
									xtype : 'combobox', //9
									fieldLabel : 'Estado Civil',
									name:'c.estadocivil',
									
									flex : 2,
									displayField : 'name',
									valueField:'value',
									blankText :' ',
									valueNotFoundText :'Valor não corresponde',
									forceSelection:true,
									autoSelect :true,
									store : Ext.create('Ext.data.Store', {
												fields : [
															'value',
															'name'
														],
												data : [{
															"name" : "Casado","value":"Casado"
														}, {
															"name" : "Viuvo" , "value":"Viuvo"
														},{
															"name" : "Solteiro","value":"Solteiro"
														},{
															"name" : "Divorciado","value":"Divorciado"
														}]
											}),
									queryMode : 'local',
								allowBlank : false ,
									typeAhead : true
								},{
                           xtype:'hiddenfield',
                         //  type:'textfield',
                           name:'idcliente',
                           itemId:'idcliente'
                           
                        }
                    ]
                }
            ]
        }
    ],
    dockedItems: [
        {
            xtype: 'toolbar',
            flex: 1,
            dock: 'bottom',
            //ui: 'footer',
            layout: {
                pack: 'end',
                type: 'hbox'
            },
            items: [
                {
                    xtype: 'button',
                    text: 'Treino',
                    formBind:true,
                    itemId: 'treino',
                    iconCls: 'criancaverde'
                },
                {
                    xtype: 'button',
                    text: 'Analise',
                    itemId: 'analise',
                    iconCls: 'cancel'
                }
            ]
        }
    ]
});