// Adam Chin CHNADA002
// 2017-04-02
// CSC2001F Assignment 1 2017 

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchAVL {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        AVLTree avl = new AVLTree (); // Creates new AVL

        Scanner td = new Scanner(new File("testdata.txt"));
        String line;
        ArrayList<Person> personArray = new ArrayList<>(); //Creates an array of Person objects
        while (td.hasNext()) {
            line = td.nextLine();
            String[] parts = line.split("\\|");
            Person p = new Person(null, null, null);
            p.setName(parts[2]);
            p.setNumber(parts[1]);
            p.setAdress(parts[0]);
            personArray.add(p);

        }

        for (int i = 0; i < personArray.size(); i++) {
            avl.insert(personArray.get(i)); //Populates AVL
        }
        System.out.println("AVL Search");
        System.out.println("Searching...\n");
        Scanner sc = new Scanner(new File("Query.txt"));
        while (sc.hasNext()) {
            avl.find(sc.nextLine());
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        if (avl.isAVLTree() == true) {
            System.out.println("\nAVL Status: " + avl.isAVLTree());
        }
       System.out.println("Run Time: " + totalTime + "ms"); // Outputs runtime

    }
}
