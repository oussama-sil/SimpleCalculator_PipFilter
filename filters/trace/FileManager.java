package filters.trace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


//? A simple class that will handle the input/output on the log file 
public class FileManager implements IOInterface{
    private final String fileName ;


    public FileManager(String fileName){
        this.fileName = fileName;
    }

    //* Write new information to the file 
    public void store(String str){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(str);
            writer.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    //* Load the content of a file
    public String load(){
        String line = "";
        try {
            line = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

}
