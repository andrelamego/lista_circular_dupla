package model.estrutura;

import model.estrutura.No;
import java.lang.Exception;

public class CircularDupla<T>{
	private No<T> ultimo = null;
	
	//append			Adiciona elemento;
	//getLast			Retorna ultimo elemento;
	//remove			Remove elemento dado o elemento;
	//total				Retorna total de elementos;
	
	public void append(T elemento){
		No<T> novo = new No<T>(elemento);
		
		if(this.ultimo == null){
			this.ultimo = novo;
			novo.setProximo(novo);
			novo.setAnterior(novo);
		}
		else{
			No<T> buffer_ultimo = this.ultimo;
			No<T> buffer_proximo = this.ultimo.getProximo();
			
			novo.setAnterior(buffer_ultimo);
			novo.setProximo(buffer_proximo);
			
			buffer_proximo.setAnterior(novo);
			buffer_ultimo.setProximo(novo);
			
			this.ultimo = novo;
		}
	}
	
	public No<T> getLast() throws IllegalArgumentException{
		if(this.ultimo == null)
			throw new IllegalArgumentException("Nao existe item na lista");
		
		return this.ultimo;
	}
	
	public void remove(No<T> remover){
		No<T> anterior = remover.getAnterior();
		No<T> proximo = remover.getProximo();
		
		if(this.ultimo == remover && anterior == remover && proximo == remover){
			//somente 1 elemento na lista
			this.ultimo = null;
			return;
		}
		
		anterior.setProximo(proximo);
		proximo.setAnterior(anterior);
		
		if(this.ultimo == remover)
			this.ultimo = anterior;
		
		remover.setProximo(null);
		remover.setAnterior(null);
		remover.setValor(null);
	}
	
	public void remove() throws IllegalArgumentException{
		remove(getLast());
	}
	
	public int total(){
		if(this.ultimo == null)
			return 0;
		
		No<T> buffer = this.ultimo;
		int total_elementos = 0;
		
		do{
			total_elementos++;
			buffer = buffer.getProximo();
		} while(buffer != this.ultimo);
			
		return total_elementos;
	}
	
	public String toString(){
        if (this.ultimo == null)
            return "[]";

        StringBuilder builder = new StringBuilder("[");
        No<T> buffer = this.ultimo.getProximo();
        builder.append(buffer.getValor());
        while(buffer != this.ultimo){
            builder.append(", ");
            buffer = buffer.getProximo();
            builder.append(buffer.getValor());
        } 
        builder.append("]");

        return builder.toString();
	}
}
