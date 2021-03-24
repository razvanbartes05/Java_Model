package Repository;

import Repository.RepositoryException;
import Model.Clasa1;
import Model.Clasa2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Clasa2FileRepository extends Clasa2InMemoryRepository {
    private String filename;
    private Clasa1Repository firstRepository;

    public Clasa2FileRepository(String filename, Clasa1Repository firstRepository) {
        this.filename = filename;
        this.firstRepository = firstRepository;
        //readFromFile();
    }

    private void readFromFile(){
        try(BufferedReader br=new BufferedReader(new FileReader(filename))){
            String line=br.readLine();
            while((line=br.readLine())!=null){
                String[] elems=line.split(";");
                if (elems.length!=6){
                    System.err.println("Invalid line ..."+line);
                    continue;
                }
                /*try {
                    int id = Integer.parseInt(elems[0]);
                    int requestId=Integer.parseInt(elems[1]);
                    double price=Double.parseDouble(elems[3]);
                    ComputerRepairRequest crr=requestRepository.findById(requestId);
                    ComputerRepairedForm crf=new ComputerRepairedForm(id,crr,elems[2],price,elems[4],elems[5]);
                    super.add(crf);

                }catch(NumberFormatException ex){
                    System.err.println("Invalid data "+ex);
                }catch (RepositoryException ex){
                    System.err.println("Repository Error "+ex);
                }

                */
            }

        }catch (IOException ex){
            throw new RepositoryException("Error reading "+ex);
        }

    }

    @Override
    public void add(Clasa2 el) {
        super.add(el);
        writeToFile();
    }

    private void writeToFile(){
        try(PrintWriter pw=new PrintWriter(filename)){
            for(Clasa2 crf:findAll()){
                //pw.println(crf.getID()+";"+crf.getRequest().getID()+";"+crf.getServices()+";"+crf.getPrice()+";"+crf.getDate()+";"+crf.getEmployee());
            }
        }catch(IOException ex){
            throw new RepositoryException("Error writing "+ex);
        }

    }
}
