package repository;

public interface GenericDAO<T, V> {

	void criar(T t);

	int editar(V v, T t);

	int remover(V v);

	T visualizar(V v);

}
