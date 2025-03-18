package service;

public interface GenericService<T, V> {

	void criar(T t) throws Exception;

	int editar(V v, T t);

	int remover(V v);

	T visualizar(V v);

}
