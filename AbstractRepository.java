package Repository;

import Model.Identifiable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AbstractRepository <ID, T extends Identifiable<ID>> implements IRepository<ID,T > {

    protected Map<ID,T> elem;

    public AbstractRepository(){
        elem= new HashMap<>();

    }
    public void add(T el){
        if(elem.containsKey(el.getID()))
        {
            throw new RepositoryException("Element already exists!!!"+el);

        }
        else
            elem.put(el.getID(),el);
    }

    public T findById( ID id){
        if(elem.containsKey(id))
            return elem.get(id);
        else
            throw new RepositoryException("Element doesn't exist"+id);
    }
    public Iterable<T> findAll() {
        return elem.values();
    }

    @Override
    public Collection<T> getAll() {
        return elem.values();
    }
}


