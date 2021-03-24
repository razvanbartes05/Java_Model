package Services;

import Model.Clasa1;
import Model.Clasa2;
import Repository.Clasa1Repository;
import Repository.Clasa2Repository;
import Repository.RepositoryException;

import java.util.List;

public class Service {

    private Clasa1Repository firstRepository;

    private Clasa2Repository secondRepository;

    public Service(Clasa1Repository firstRepository, Clasa2Repository secondRepository) {
        this.firstRepository = firstRepository;
        this.secondRepository = secondRepository;
    }

    public void addClasa1() throws ServicesException{
        try {
            Clasa1 c1 = new Clasa1();
            firstRepository.add(c1);
        }catch (RepositoryException ex){
            throw new ServicesException("Error adding request"+ex);
        }
    }

    public void addClasa2(Clasa1 c1) throws ServicesException {
        try {
            Clasa2 c2 = new Clasa2();
            secondRepository.add(c2);
        } catch (RepositoryException er) {
            throw new ServicesException("Error adding form" + er);
        }
    }

}