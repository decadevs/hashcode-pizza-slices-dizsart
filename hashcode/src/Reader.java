import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {

    public static void read()
    {

        Path path = Paths.get("src/pizzafile.txt");
        try(BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String currentLine = null;
            List<String[]> array = new ArrayList<>();
            while((currentLine = reader.readLine()) != null){
                array.add(currentLine.split(" "));
            }
            Arrays.sort(array.get(1));
            List<String> arrs = Arrays.asList(array.get(0));
            int sumOfslices = Integer.parseInt(arrs.get(0));
            String[] arr = array.get(1);
            int count = 0;
            int num = 0;
            List<Integer> index = new ArrayList<>();
            for(int i = arr.length-1; i >= 0; i--){
                int n = Integer.parseInt(arr[i]);
                if(count<=sumOfslices) {
                if(n<sumOfslices&&count+n<sumOfslices){
                        count +=n;
                        index.add(i);
                        num++;
                    }
                }
                else{
                    continue;
                }
            }
            String ans = "";
            for(int i = index.size()-1; i>=0;i--){
                ans+=index.get(i).toString()+" ";
            }
            Path path1 = Paths.get("src/pizzafile1.txt");
            try(BufferedWriter writer = Files.newBufferedWriter(path1, StandardCharsets.UTF_8)){

                writer.write(num+"\n" +
                        ans);
            }catch(IOException ex){
                ex.printStackTrace();
            }
            System.out.println(num);
            System.out.println(index.toString());
        }catch(IOException ex){
            ex.printStackTrace();
        }


    }
}
