import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    // Creating a text File using FileWriter

        public void write(){
            // Accept a string
            try {
                String str = "";

                for (int i = 0; i < main.players.size(); i++) {
                     str += main.players.get(i).getName();
                     str += ",";
                     str +=main.players.get(i).getRating();
                     str+="\n";

                }

                // attach a file to FileWriter
                FileWriter fw = new FileWriter("Ratings.txt");

                // read character wise from string and write
                // into FileWriter
                for (int i = 0; i < str.length(); i++)
                    fw.write(str.charAt(i));

                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Writing successful");
                //close the file
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        public Writer(){

        }

}

