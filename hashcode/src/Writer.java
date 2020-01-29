import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Writer {

        public static void write()
        {

                Path path = Paths.get("src/pizzafile.txt");
                Scanner nn = new Scanner(System.in);
            Scanner mm = new Scanner(System.in);
                try(BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)){
                   String n ="";
                   n+= nn.nextLine()+" ";
                   String m = "";
                   m+= mm.nextLine()+" ";
                    writer.write(n+"\n" +
                            m);
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }

