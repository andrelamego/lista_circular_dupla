package model.estrutura;

public class No<T> {
	
	private T valor;
	private No<T> anterior;
	private No<T> proximo;
	
	public No(T valor){
		this.anterior = null;
		this.proximo = null;
		this.valor = valor;
	}
	
	public void setValor(T valor){
		this.valor = valor;
	}
	
	public T getValor(){
		return valor;
	}
	
	public void setAnterior(No<T> anterior){
		this.anterior = anterior;
	}
	
	public No<T> getAnterior(){
		return anterior;
	}
	
	public void setProximo(No<T> proximo){
		this.proximo = proximo;
	}
	
	public No<T> getProximo(){
		return proximo;
	}
	
	@Override
	public String toString(){
		return valor.toString();
	}
}