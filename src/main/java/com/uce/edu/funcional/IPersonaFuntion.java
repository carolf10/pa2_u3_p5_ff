package com.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaFuntion <T,R>{
	public T aplicar(R arg);
}
