package Repository;

import Model.Identifiable;

import java.util.Collection;

public interface IRepository<Tid, T extends Identifiable<Tid>> {
    void add(T elem);
    T findById(Tid id);
    Iterable<T> findAll();
    Collection<T> getAll();
}
