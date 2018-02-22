package br.com.bd1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.smartcardio.ATR;

import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;

import br.com.bd1.bean.Analise;
import br.com.bd1.bean.Atributo;
import br.com.bd1.connection.IPool;
import br.com.bd1.connection.Pool;


public  class  Fachada {
	private IPool pool;
	public  List<Atributo>  ClassificadorNaiveBayes(){
		pool=new Pool();
		List<Atributo> list=new ArrayList<Atributo>();
		BDDAO bddao= new BDDAO(pool);
		TreinamentoRedesBayesianas t=new TreinamentoRedesBayesianas(pool);
		Atributo Hipotese=new Atributo();
		
		String classe="Atrasado";
		Hipotese.setNomeAtributo("classeHipotese");
		Hipotese.setAtributo("Atrasado");
		Hipotese.setClasse("Atrasado");
		Object obj= t.treinamentoDaClasse(classe);
		float classeInadimplente=Float.parseFloat(obj.toString());
		Hipotese.setProbabilidade(classeInadimplente);
		list.add(Hipotese);
		System.out.println("% classe dos Inadimpletes: "+classeInadimplente);
		
		Atributo Hipotese2 =new Atributo();
		classe="Pago";
		Hipotese2.setNomeAtributo("classeHipotese");
		Hipotese2.setAtributo("Pago");
		Hipotese2.setClasse("Pago");
		
		Object obj2= t.treinamentoDaClasse(classe);
		float classeAdimplente=Float.parseFloat(obj2.toString());
		Hipotese2.setProbabilidade(classeAdimplente);
		System.out.println("% classe dos Adimpletes: " +classeAdimplente);
		list.add(Hipotese2);
		
		Atributo sexo=new Atributo();
		sexo.setAtributo("M");
		sexo.setClasse("Atrasado");
		sexo.setNomeAtributo("c.sexo");
		Object treinoSexo=t.treinamentoAtributosBayesiano(sexo);
		sexo.setProbabilidade(Float.parseFloat(treinoSexo.toString()));
		list.add(sexo);
		
		System.out.println("% da classe Inadimplentes sao masculinos: "+treinoSexo.toString());
		sexo.setAtributo("M");
		sexo.setClasse("Pago");
		sexo.setNomeAtributo("c.sexo");
		treinoSexo=t.treinamentoAtributosBayesiano(sexo);
		sexo.setProbabilidade(Float.parseFloat(treinoSexo.toString()));
		list.add(sexo);
		
		System.out.println("% da classe Adimplentes sao masculinos: "+treinoSexo.toString());
		
		sexo.setAtributo("F");
		sexo.setClasse("Atrasado");
		sexo.setNomeAtributo("c.sexo");
		String atributoSexo="M";
		treinoSexo=t.treinamentoAtributosBayesiano(sexo);
		sexo.setProbabilidade(Float.parseFloat(treinoSexo.toString()));
		list.add(sexo);
		
		System.out.println("% da classe Inadimplentes sao Femininos: "+treinoSexo.toString());
		sexo.setAtributo("F");
		sexo.setClasse("Pago");
		sexo.setNomeAtributo("c.sexo");
		//String atributoSexo="M";
		treinoSexo=t.treinamentoAtributosBayesiano(sexo);
		sexo.setProbabilidade(Float.parseFloat(treinoSexo.toString()));
		list.add(sexo);
		
		System.out.println("% da classe Adimplentes sao Femininos: "+treinoSexo.toString());
		
		Object treinoEstadocivil;
		Atributo estadoCivil=new Atributo();
		estadoCivil.setClasse("Atrasado");
		estadoCivil.setAtributo("viuvo");
		estadoCivil.setNomeAtributo("c.estadocivil");
		treinoEstadocivil=t.treinamentoAtributosBayesiano(estadoCivil);
		estadoCivil.setProbabilidade(Float.parseFloat(treinoEstadocivil.toString()));
		list.add(estadoCivil);
		
		System.out.println("% da classe Inadimplentes sao Viuvo: "+treinoEstadocivil.toString());
		
		estadoCivil.setClasse("Atrasado");
		estadoCivil.setAtributo("casado");
		estadoCivil.setNomeAtributo("c.estadocivil");
		treinoEstadocivil=t.treinamentoAtributosBayesiano(estadoCivil);
		estadoCivil.setProbabilidade(Float.parseFloat(treinoEstadocivil.toString()));
		list.add(estadoCivil);
		
		System.out.println("% da classe Inadimplentes sao Casados: "+treinoEstadocivil.toString());
		
		estadoCivil.setClasse("Atrasado");
		estadoCivil.setAtributo("solteiro");
		estadoCivil.setNomeAtributo("c.estadocivil");
		treinoEstadocivil=t.treinamentoAtributosBayesiano(estadoCivil);
		estadoCivil.setProbabilidade(Float.parseFloat(treinoEstadocivil.toString()));
		list.add(estadoCivil);
		
		System.out.println("% da classe Inadimplentes sao Solteiro: "+treinoEstadocivil.toString());
		
		estadoCivil.setClasse("Atrasado");
		estadoCivil.setAtributo("divorciado");
		estadoCivil.setNomeAtributo("c.estadocivil");
		treinoEstadocivil=t.treinamentoAtributosBayesiano(estadoCivil);
		estadoCivil.setProbabilidade(Float.parseFloat(treinoEstadocivil.toString()));
		list.add(estadoCivil);
		
		System.out.println("% da classe Inadimplentes sao Divorciado: "+treinoEstadocivil.toString());
	
		
		estadoCivil.setClasse("Pago");
		estadoCivil.setAtributo("viuvo");
		estadoCivil.setNomeAtributo("c.estadocivil");
		treinoEstadocivil=t.treinamentoAtributosBayesiano(estadoCivil);
		estadoCivil.setProbabilidade(Float.parseFloat(treinoEstadocivil.toString()));
		list.add(estadoCivil);
		
		System.out.println("% da classe Adimplentes sao Viuvo: "+treinoEstadocivil.toString());
		
		estadoCivil.setClasse("Pago");
		estadoCivil.setAtributo("casado");
		estadoCivil.setNomeAtributo("c.estadocivil");
		treinoEstadocivil=t.treinamentoAtributosBayesiano(estadoCivil);
		estadoCivil.setProbabilidade(Float.parseFloat(treinoEstadocivil.toString()));
		list.add(estadoCivil);
		
		System.out.println("% da classe Adimplentes sao Casados: "+treinoEstadocivil.toString());
		
		estadoCivil.setClasse("Pago");
		estadoCivil.setAtributo("solteiro");
		estadoCivil.setNomeAtributo("c.estadocivil");
		treinoEstadocivil=t.treinamentoAtributosBayesiano(estadoCivil);
		estadoCivil.setProbabilidade(Float.parseFloat(treinoEstadocivil.toString()));
		list.add(estadoCivil);
		
		System.out.println("% da classe Adimplentes sao Solteiro: "+treinoEstadocivil.toString());
		
		estadoCivil.setClasse("Pago");
		estadoCivil.setAtributo("divorciado");
		estadoCivil.setNomeAtributo("c.estadocivil");
		treinoEstadocivil=t.treinamentoAtributosBayesiano(estadoCivil);
		estadoCivil.setProbabilidade(Float.parseFloat(treinoEstadocivil.toString()));
		list.add(estadoCivil);
		
		System.out.println("% da classe Adimplentes sao Divorciado: "+treinoEstadocivil.toString());
	
		
		Atributo rendimentos=new Atributo();
		Object treinoRendimentos;
		rendimentos.setClasse("Pago");
		rendimentos.setAtributo("Acima de tres salarios minino");
		rendimentos.setNomeAtributo("c.rendimentos");
		treinoRendimentos=t.treinamentoAtributosBayesiano(rendimentos);
		rendimentos.setProbabilidade(Float.parseFloat(treinoRendimentos.toString()));
		list.add(rendimentos);
		
		System.out.println("% da classe Adimplentes sao Acima de tres salarios : "+treinoRendimentos.toString());
	    
		rendimentos.setClasse("Pago");
		rendimentos.setAtributo("Um salario Minimo");
		rendimentos.setNomeAtributo("c.rendimentos");
		treinoRendimentos=t.treinamentoAtributosBayesiano(rendimentos);
		rendimentos.setProbabilidade(Float.parseFloat(treinoRendimentos.toString()));
		list.add(rendimentos);
		
		System.out.println("% da classe Adimplentes sao Um salario Minimo : "+treinoRendimentos.toString());
	
		rendimentos.setClasse("Pago");
		rendimentos.setAtributo("Dois salarios minino");
		rendimentos.setNomeAtributo("c.rendimentos");
		treinoRendimentos=t.treinamentoAtributosBayesiano(rendimentos);
		rendimentos.setProbabilidade(Float.parseFloat(treinoRendimentos.toString()));
		list.add(rendimentos);
		
		System.out.println("% da classe Adimplentes sao Dois salarios minino : "+treinoRendimentos.toString());
	
		rendimentos.setClasse("Atrasado");
		rendimentos.setAtributo("Acima de tres salarios minino");
		rendimentos.setNomeAtributo("c.rendimentos");
		treinoRendimentos=t.treinamentoAtributosBayesiano(rendimentos);
		rendimentos.setProbabilidade(Float.parseFloat(treinoRendimentos.toString()));
		list.add(rendimentos);
		
		System.out.println("% da classe Inadimplentes sao Acima de tres salarios : "+treinoRendimentos.toString());
	    
		rendimentos.setClasse("Atrasado");
		rendimentos.setAtributo("Um salario Minimo");
		rendimentos.setNomeAtributo("c.rendimentos");
		treinoRendimentos=t.treinamentoAtributosBayesiano(rendimentos);
		rendimentos.setProbabilidade(Float.parseFloat(treinoRendimentos.toString()));
		list.add(rendimentos);
		
		System.out.println("% da classe Inadimplentes sao Um salario Minimo : "+treinoRendimentos.toString());
	
		rendimentos.setClasse("Atrasado");
		rendimentos.setAtributo("Dois salarios minino");
		rendimentos.setNomeAtributo("c.rendimentos");
		treinoRendimentos=t.treinamentoAtributosBayesiano(rendimentos);
		rendimentos.setProbabilidade(Float.parseFloat(treinoRendimentos.toString()));
		list.add(rendimentos);
		
		System.out.println("% da classe Inadimplentes sao Dois salarios minino : "+treinoRendimentos.toString());
		
		Atributo idade=new Atributo();
		Object treinoidade=new Object();
	
		idade.setClasse("Atrasado");
		idade.setAtributo("0");
		idade.setNomeAtributo("c.idade");
		treinoidade=t.treinamentoAtributosBayesiano(idade);
		idade.setProbabilidade(Float.parseFloat(treinoidade.toString()));
		list.add(idade);
		
		System.out.println("% da classe Inadimplentes sao de (16-25) : "+treinoidade.toString());
	
		idade.setClasse("Atrasado");
		idade.setAtributo("1");
		idade.setNomeAtributo("c.idade");
		treinoidade=t.treinamentoAtributosBayesiano(idade);
		idade.setProbabilidade(Float.parseFloat(treinoidade.toString()));
		list.add(idade);
		
		System.out.println("% da classe Inadimplentes sao de (26-30) : "+treinoidade.toString());
	
		idade.setClasse("Atrasado");
		idade.setAtributo("2");
		idade.setNomeAtributo("c.idade");
		treinoidade=t.treinamentoAtributosBayesiano(idade);
		idade.setProbabilidade(Float.parseFloat(treinoidade.toString()));
		list.add(idade);
		
		System.out.println("% da classe Inadimplentes sao de (31-40) : "+treinoidade.toString());
	
		idade.setClasse("Atrasado");
		idade.setAtributo("3");
		idade.setNomeAtributo("c.idade");
		treinoidade=t.treinamentoAtributosBayesiano(idade);
		idade.setProbabilidade(Float.parseFloat(treinoidade.toString()));
		list.add(idade);
		
		System.out.println("% da classe Inadimplentes sao de (41-49) : "+treinoidade.toString());
	
		idade.setClasse("Atrasado");
		idade.setAtributo("4");
		idade.setNomeAtributo("c.idade");
		treinoidade=t.treinamentoAtributosBayesiano(idade);
		idade.setProbabilidade(Float.parseFloat(treinoidade.toString()));
		list.add(idade);
		
		System.out.println("% da classe Inadimplentes sao de (50-70) : "+treinoidade.toString());
	
		idade.setClasse("Atrasado");
		idade.setAtributo("5");
		idade.setNomeAtributo("c.idade");
		treinoidade=t.treinamentoAtributosBayesiano(idade);
		idade.setProbabilidade(Float.parseFloat(treinoidade.toString()));
		list.add(idade);
		
		System.out.println("% da classe Inadimplentes sao de (71-100) : "+treinoidade.toString());

		
		
		
		idade.setClasse("Pago");
		idade.setAtributo("0");
		idade.setNomeAtributo("c.idade");
		treinoidade=t.treinamentoAtributosBayesiano(idade);
		idade.setProbabilidade(Float.parseFloat(treinoidade.toString()));
		list.add(idade);
		
		System.out.println("% da classe Adimplentes sao de (16-25) : "+treinoidade.toString());
	
		idade.setClasse("Pago");
		idade.setAtributo("1");
		idade.setNomeAtributo("c.idade");
		treinoidade=t.treinamentoAtributosBayesiano(idade);
		idade.setProbabilidade(Float.parseFloat(treinoidade.toString()));
		list.add(idade);
		
		System.out.println("% da classe Adimplentes sao de (26-30) : "+treinoidade.toString());
	
		idade.setClasse("Pago");
		idade.setAtributo("2");
		idade.setNomeAtributo("c.idade");
		treinoidade=t.treinamentoAtributosBayesiano(idade);
		idade.setProbabilidade(Float.parseFloat(treinoidade.toString()));
		list.add(idade);
		
		System.out.println("% da classe Adimplentes sao de (31-40) : "+treinoidade.toString());
	
		idade.setClasse("Pago");
		idade.setAtributo("3");
		idade.setNomeAtributo("c.idade");
		treinoidade=t.treinamentoAtributosBayesiano(idade);
		idade.setProbabilidade(Float.parseFloat(treinoidade.toString()));
		list.add(idade);
		
		System.out.println("% da classe Adimplentes sao de (41-49) : "+treinoidade.toString());
	
		idade.setClasse("Pago");
		idade.setAtributo("4");
		idade.setNomeAtributo("c.idade");
		treinoidade=t.treinamentoAtributosBayesiano(idade);
		idade.setProbabilidade(Float.parseFloat(treinoidade.toString()));
		list.add(idade);
		
		System.out.println("% da classe Adimplentes sao de (50-70) : "+treinoidade.toString());
	
		idade.setClasse("Pago");
		idade.setAtributo("5");
		idade.setNomeAtributo("c.idade");
		treinoidade=t.treinamentoAtributosBayesiano(idade);
		idade.setProbabilidade(Float.parseFloat(treinoidade.toString()));
		list.add(idade);
		
		System.out.println("% da classe Adimplentes sao de (71-100) : "+treinoidade.toString());
		
		Atributo escolaridade=new Atributo();
		Object treinoescolaridade=new Object();

		escolaridade.setClasse("Pago");
		escolaridade.setAtributo("Ensino Medio Imcompleto");
		escolaridade.setNomeAtributo("c.escolaridade");
		treinoescolaridade=t.treinamentoAtributosBayesiano(escolaridade);
		escolaridade.setProbabilidade(Float.parseFloat(treinoescolaridade.toString()));
		list.add(escolaridade);
		
		System.out.println("% da classe Adimplentes sao Ensino Medio Imcompleto : "+treinoescolaridade.toString());
		
		escolaridade.setClasse("Pago");
		escolaridade.setAtributo("Ensino Medio Completo");
		escolaridade.setNomeAtributo("c.escolaridade");
		treinoescolaridade=t.treinamentoAtributosBayesiano(escolaridade);
		escolaridade.setProbabilidade(Float.parseFloat(treinoescolaridade.toString()));
		list.add(escolaridade);
		
		System.out.println("% da classe Adimplentes sao Ensino Medio Completo : "+treinoescolaridade.toString());
		escolaridade.setClasse("Pago");
		escolaridade.setAtributo("Ensino Superior Completo");
		escolaridade.setNomeAtributo("c.escolaridade");
		treinoescolaridade=t.treinamentoAtributosBayesiano(escolaridade);
		escolaridade.setProbabilidade(Float.parseFloat(treinoescolaridade.toString()));
		list.add(escolaridade);
		
		System.out.println("% da classe Adimplentes sao Ensino Superior Completo : "+treinoescolaridade.toString());
		
		escolaridade.setClasse("Atrasado");
		escolaridade.setAtributo("Ensino Medio Imcompleto");
		escolaridade.setNomeAtributo("c.escolaridade");
		treinoescolaridade=t.treinamentoAtributosBayesiano(escolaridade);
		escolaridade.setProbabilidade(Float.parseFloat(treinoescolaridade.toString()));
		list.add(escolaridade);
		
		System.out.println("% da classe Inadimplentes sao Ensino Medio Imcompleto : "+treinoescolaridade.toString());
		
		escolaridade.setClasse("Atrasado");
		escolaridade.setAtributo("Ensino Medio Completo");
		escolaridade.setNomeAtributo("c.escolaridade");
		treinoescolaridade=t.treinamentoAtributosBayesiano(escolaridade);
		escolaridade.setProbabilidade(Float.parseFloat(treinoescolaridade.toString()));
		list.add(escolaridade);
		
		System.out.println("% da classe Inadimplentes sao Ensino Medio Completo : "+treinoescolaridade.toString());
		escolaridade.setClasse("Atrasado");
		escolaridade.setAtributo("Ensino Superior Completo");
		escolaridade.setNomeAtributo("c.escolaridade");
		treinoescolaridade=t.treinamentoAtributosBayesiano(escolaridade);
		escolaridade.setProbabilidade(Float.parseFloat(treinoescolaridade.toString()));
		list.add(escolaridade);
		
		System.out.println("% da classe Inadimplentes sao Ensino Superior Completo : "+treinoescolaridade.toString());
		
		return list;		
	}

    public String Analise(Analise obj){
    	List<Atributo> list=new ArrayList<Atributo>();
    	float probabilidadeInadimplente=0.0f;
    	float probabilidadeAdimplente=0.0f;
    	list=ClassificadorNaiveBayes();
    	int n = list.size();
    	for(int j=0;j<n;j++){
    		if(list.get(j).getNomeAtributo().equalsIgnoreCase("classeHipotese") & list.get(j).getAtributo().equals("Atrasado")){
    			probabilidadeInadimplente=list.get(j).getProbabilidade();
    		}
    		if(list.get(j).getNomeAtributo().equalsIgnoreCase("classeHipotese") & list.get(j).getAtributo().equals("Pago")){
    			probabilidadeAdimplente=list.get(j).getProbabilidade();
    		}
    	}
    	for (int i=0; i<n; i++) { 
    		if(obj.getEscolaridade().equalsIgnoreCase(list.get(i).getAtributo().toString())& list.get(i).getClasse().equals("Pago")){
    			probabilidadeAdimplente=probabilidadeAdimplente*list.get(i).getProbabilidade();
    		}
    		if(obj.getEscolaridade().equalsIgnoreCase(list.get(i).getAtributo().toString())& list.get(i).getClasse().equals("Atrasado")){
    			probabilidadeInadimplente=probabilidadeInadimplente*list.get(i).getProbabilidade();
    		}
    		if(obj.getEstadocivil().equalsIgnoreCase(list.get(i).getAtributo().toString())& list.get(i).getClasse().equals("Pago")){
    			probabilidadeAdimplente=probabilidadeAdimplente*list.get(i).getProbabilidade();
    		}
    		if(obj.getEstadocivil().equalsIgnoreCase(list.get(i).getAtributo().toString())& list.get(i).getClasse().equals("Atrasado")){
    			probabilidadeInadimplente=probabilidadeInadimplente*list.get(i).getProbabilidade();
    		}if(obj.getEstadocivil().equalsIgnoreCase(list.get(i).getAtributo().toString())& list.get(i).getClasse().equals("Pago")){
    			probabilidadeAdimplente=probabilidadeAdimplente*list.get(i).getProbabilidade();
    		}
    		if(obj.getEstadocivil().equalsIgnoreCase(list.get(i).getAtributo().toString())& list.get(i).getClasse().equals("Atrasado")){
    			probabilidadeInadimplente=probabilidadeInadimplente*list.get(i).getProbabilidade();
    		}
    		if(obj.getIdade().equalsIgnoreCase(list.get(i).getAtributo().toString())& list.get(i).getClasse().equals("Pago")){
    			probabilidadeAdimplente=probabilidadeAdimplente*list.get(i).getProbabilidade();
    		}
    		if(obj.getIdade().equalsIgnoreCase(list.get(i).getAtributo().toString())& list.get(i).getClasse().equals("Atrasado")){
    			probabilidadeInadimplente=probabilidadeInadimplente*list.get(i).getProbabilidade();
    		}
    		if(obj.getRendimentos().equalsIgnoreCase(list.get(i).getAtributo().toString())& list.get(i).getClasse().equals("Pago")){
    			probabilidadeAdimplente=probabilidadeAdimplente*list.get(i).getProbabilidade();
    		}
    		if(obj.getRendimentos().equalsIgnoreCase(list.get(i).getAtributo().toString())& list.get(i).getClasse().equals("Atrasado")){
    			probabilidadeInadimplente=probabilidadeInadimplente*list.get(i).getProbabilidade();
    		}
    		if(obj.getSexo().equalsIgnoreCase(list.get(i).getAtributo().toString())& list.get(i).getClasse().equals("Pago")){
    			probabilidadeAdimplente=probabilidadeAdimplente*list.get(i).getProbabilidade();
    		}
    		if(obj.getSexo().equalsIgnoreCase(list.get(i).getAtributo().toString())& list.get(i).getClasse().equals("Atrasado")){
    			probabilidadeInadimplente=probabilidadeInadimplente*list.get(i).getProbabilidade();
    		}
    		//System.out.printf("Posição "+list.get(i).getNomeAtributo());
    	//	System.out.printf("Posição "+list.get(i).getAtributo());
    		//System.out.printf("Posição "+list.get(i).getClasse());
    		//System.out.printf("Posição "+list.get(i).getProbabilidade());
    		}
    	
    	if(probabilidadeAdimplente<probabilidadeInadimplente){
    	   return "Risco"	;
    	}else{
    		return "Bom";
    	}

    	
    	
    }




}