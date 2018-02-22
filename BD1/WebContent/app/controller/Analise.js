
// ---------*******Funcao para Popular grid Cliente*************-----------------

function atualizaCliente(cliente) {

	FacadeCliente.atualizarCliente(cliente, {
		callback : function(returnBean) {

			if ((returnBean == "foi")) {
				
				var form = Ext.ComponentQuery.query('form#formatualizacliente')[0];
				form.getForm().reset(), Ext.MessageBox.show({
							title : 'Efetuado!!!',
							msg : 'Atualização efetuada com sucesso',
							buttons : Ext.MessageBox.OK,
							icon : Ext.MessageBox.WARNING,
							fn : function() {
								//document.location.reload(true);

								campo =Ext.ComponentQuery.query('window#atualizacliente')[0]; 
				                 campo.close();
							}
						});
				
				
			}
			if (returnBean == null) {

				

			}
			if (returnBean == "not exist") {

				Ext.MessageBox.show({
							title : 'Não Existe',
							msg : 'Usuario não existente no cadastro',
							buttons : Ext.MessageBox.OK,
							icon : Ext.MessageBox.WARNING,
							fn : function() {
								campo =Ext.ComponentQuery.query('window#atualizacliente')[0]; 
				                 campo.close();

							}
						});
				//dwr.util.setValue("senha2", "");
				//dwr.util.setValue("login2", "");

			}

		},
		errorHandler : function(errorstring, e) {
			var login = Ext.ComponentQuery.query('clientepanel')[0];
			login.getEl().unmask();

			Ext.MessageBox.show({
						title : 'Error',
						msg : errorstring,
						buttons : Ext.MessageBox.OK,
						icon : Ext.MessageBox.WARNING,
						fn : function() {
							Ext.getCmp('nome_crianca').focus();

						}
					});
		},
		timeout : 50000

	});
}

function treinoNaiveBayes(beanCliente) {

	Fachada.Analise(beanCliente, {
		callback : function(returnClientes) {
			var val = 1;
			// alert(returnClientes[0].fornecedor);
			if (returnClientes == '') {
				val = 2;

			} else {
				var retu = returnClientes[0].nome_crianca;

				// gridPesqContas.getSelectionModel().selectFirstRow();
				if (retu == "usenull") {

					val = 2;
					Ext.MessageBox.show({
						title : 'Alert',
						msg : 'Sua sessão Expirou!!! Você será redirecionado para pagina de login!!!',
						buttons : Ext.MessageBox.OK,
						icon : Ext.MessageBox.WARNING,
						fn : function() {
							document.location.reload(true);

						}
					});

				}
				if (retu == "notuse") {
					val = 2;
					Ext.MessageBox.show({
								title : 'Alert',
								msg : 'Usuario Invalido',
								buttons : Ext.MessageBox.OK,
								icon : Ext.MessageBox.WARNING,
								fn : function() {
									document.location.reload(true);

								}
							});
				}
				if (retu == "usenivel") {
					val = 2;
					Ext.MessageBox.show({
						title : 'Alert',
						msg : 'Usuario não Autorizado a executar esta operacao!!!',
						buttons : Ext.MessageBox.OK,
						icon : Ext.MessageBox.WARNING,
						fn : function() {

							Ext.getCmp('grididpesqsolicitacao').el.unmask();
						}
					});
				}
			}
			if (val == 1) {
									Ext.MessageBox.show({
								title : 'Alert',
								msg : returnClientes,
								buttons : Ext.MessageBox.OK,
								icon : Ext.MessageBox.WARNING,
								fn : function() {
									document.location.reload(true);

								}
							});
			} else {
			}
		},
		exceptionHandler : function(errorstring, exception) {

			Ext.MessageBox.show({
						title : '' + exception.javaClassName,
						msg : '' + errorstring,
						buttons : Ext.MessageBox.OK,
						icon : Ext.MessageBox.ERROR,
						fn : function() {
							Ext.getCmp('grididpesqsolicitacao').el.unmask();

						}
					});
		},
		timeout : 500000

	});

}


Ext.define('App.controller.Analise', {
	extend : 'Ext.app.Controller',

	requires : ['Ext.Date.*' ],

	views : ['Analise'],

	
	init : function(application) {

		this.control({

					" button#treino" : {

						click : this.onButtonClicTreino
					},
					" button#pesquisaCliente" : {

						click : this.onButtonClicPesquisaClienteList
					},
					" button#entradacliente" : {

						click : this.onButtonClickAdd
					}/*,
					"appheader button#entrada" : {
					click : this.onButtonClickEntrada
					}*/

				});
	},




	onButtonClickAdd : function(button, e, options) {

		var grid = Ext.ComponentQuery.query('clientelist')[0];

		var record = grid.getSelectionModel().getSelection();

		var panel = Ext.ComponentQuery.query('appheader displayfield#hora')[0];
        
        
        var data=panel.getValue();
		
		var cel3=Ext.util.Format.substr(data,11,5);
		
		
		if (record[0]) { // #2
			var win = Ext.create('App.view.movimento.Movimento');
            //record[0].set('entrada',cel3);
			 win.down('timefield[name=entrada]').setValue(cel3);
        
			win.down('form').loadRecord(record[0]);
            
            var mystore = Ext.data.StoreManager.lookup('StoreResponsavel');
            mystore.removeAll();
	
            mystore.add({responsavel: record[0].get('responsavel')}, {responsavel: record[0].get('responsavel2')},{responsavel: record[0].get('responsavel3')});
			win.setTitle(record[0].get('nome_crianca')); // #5
			win.show();
		}

	},

	onButtonClicTreino : function(button, e, options) {
		var pan = button.up('#analise');
		var form = pan.down('form');

		var Panel = button.up('analise');
		
		if (form.getForm().isValid()) {
			console.log('foi');
			
			
			//var date = Ext.util.Format.date(Panel.down('datefield[name=data_nascimento]').getRawValue(), "Ymd");
			var atributo={
			   idade:Panel.down('textfield[name=c.idade]').getValue(),
			   escolaridade:Panel.down('textfield[name=c.escolaridade]').getValue(),
			   rendimentos:Panel.down('textfield[name=c.rendimentos]').getValue(),
			   sexo:Panel.down('textfield[name=c.sexo]').getValue(),
			   estadocivil:Panel.down('textfield[name=c.estadocivil]').getValue()
			   
			}
			treinoNaiveBayes(atributo);
			//cadastraCliente(cliente);

			console.log('Form valido');

		} else {
			Ext.MessageBox.show({
				title : 'Campos Invalidos',
				msg : 'Os campos em vermelho precisam ser preenchidos corretamente',
				buttons : Ext.MessageBox.OK,
				icon : Ext.MessageBox.WARNING,
				fn : function() {
					//document.location.reload(true);

				}
			});
			console.log('camppos invalidos')
		}

	},

	onButtonClicPesquisaClienteList : function(button, e, options) {
		var tbar = button.up('toolbar#buttonClienteList');
		//console.log(tbar);
		var nome = tbar.down('textfield[name=nome_criancaList]').getValue();//,
		//console.log(nome);
		var cliente = {
			nome_crianca : nome,
			data_nascimento : '',
			// idade:Panel.down('textfield[name=idade]').getValue(),
			autorizado_banheiro : '',
			sexo : '',
			responsavel : '',
			parentesco : '',
			cpf : '',
			telefone : '',
			celular : '',
			email : '',

			responsavel2 : '',
			parentesco2 : '',
			cpf2 : '',
			telefone2 : '',
			celular2 : '',
			email2 : '',

			responsavel3 : '',
			parentesco3 : '',
			cpf3 : '',
			telefone3 : '',
			celular3 : '',
			email3 : '',
			ativo : 'S'

		};
		pesquisaCliente(cliente)
	}

})