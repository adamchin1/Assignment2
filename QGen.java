
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QGen {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner data = new Scanner(new File("testdata.txt")); //READS .TXT FILE
        ArrayList<Person> personArray = new ArrayList<>();
        Random ran = new Random();
        while (data.hasNext()) {
            String[] parts = data.nextLine().split("\\|"); // creates person object and adds it to array 
            Person p = new Person(null, null, null);
            p.setName(parts[2]);
            p.setNumber(parts[1]);
            p.setAdress(parts[0]);
            personArray.add(p);
            }
        
            for (int i = 0; i < 10000; i++) {
                String output = personArray.get(ran.nextInt(9999)).getName();
                System.out.println(output);
            }
        

    }

}
