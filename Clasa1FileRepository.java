package Repository;

import Repository.RepositoryException;
import Model.Clasa1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Clasa1FileRepository extends Clasa1InMemoryRepository {
    private String filename;

    public Clasa1FileRepository(String filename) {
        this.filename = filename;
        //readFromFile();
    }

    private void readFromFile(){
        try(BufferedReader br=new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] elems = line.split(";");
                if (elems.length != 8) {
                    System.err.println("Invalid line ..." + line);
                    continue;
                }
            }
                /*try{
                    RequestStatus status=RequestStatus.valueOf(RequestStatus.class,elems[7]);
                    ComputerRepairRequest crr=new ComputerRepairRequest(id,elems[1],elems[2],elems[3],elems[4],elems[5],elems[6]);
                    crr.setStatus(status);
                    super.add(crr);
                }catch(NumberFormatException ex){
                    System.err.println("Error converting "+elems[0]);
                }catch (IllegalArgumentException ex){
                    System.err.println("Error converting "+elems[7]);
                }
              }
              */

        }catch(IOException ex){
            throw new RepositoryException("Error reading "+ex);
        }

    }

    private void writeToFile(){
        try(PrintWriter pw=new PrintWriter(filename)){
            for(Clasa1 crr:findAll()){
                //pw.println(crr.getID()+";"+crr.getOwnerName()+";"+crr.getOwnerAddress()+";"+crr.getPhoneNumber()+";"+crr.getModel()+";"+crr.getDate()+";"+crr.getProblemDescription()+";"+crr.getStatus());
            }
        }catch(IOException ex){
            throw new RepositoryException("Error writing "+ex);
        }

    }


    @Override
    public void add(Clasa1 el) {
        super.add(el);
        writeToFile();
    }
}
