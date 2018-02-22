package br.com.bd1.dao;

import br.com.bd1.bean.Analise;



public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fachada f=new Fachada();
		Analise analise=new Analise();
		analise.setEscolaridade("Ensino Superior Completo");
		analise.setEstadocivil("Casado");
		analise.setIdade("0");
		analise.setRendimentos("Acima de tres salarios minino");
		analise.setSexo("M");
		String val=f.Analise(analise);
        System.out.println(val);
	}

}
