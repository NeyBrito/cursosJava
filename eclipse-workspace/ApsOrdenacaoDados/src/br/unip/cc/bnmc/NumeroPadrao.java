package br.unip.cc.bnmc; 
public class NumeroPadrao { 
	public static void insere() { 
		for(int i = 0; i < 100; i++) 
			Insere.insere(((int)Math.ceil(Math.random()*1000))); 
		} 
	}