import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ArrayList<Book> booklist = new ArrayList<>();

        // Option 1: BufferedReader
        // you need a try block here because the file may not exist
        try(BufferedReader reader = Files.newBufferedReader(Paths.get("src/books.txt")))
        {
            String line;
            String[] elements;
            // read a whole line until there are none left
            while( (line=reader.readLine() ) != null){
                // the next line splits the line on the , character
                elements = line.split(",");
                // create a new book based on the entries (read the Book class)
                booklist.add(new Book(elements[0], Double.parseDouble(elements[1])));
            }
        }
        // if the file is not found, what should we do?
        catch(IOException e){
            System.out.println("exception: " + e);
        }

        Collections.sort(booklist);
        //Collections.sort(booklist,new BookRater());
        printBookList(booklist);
        booklist.clear();

        // Option 2: Scanner
        // you need a try block here because the file may not exist
        try(Scanner in = new Scanner(new File("src/books.txt")))
        {
            String[] elements;
            // hasNext() check if there are still any tokens left
            while(in.hasNext()){
                // grab the nextLine and split on ,
                elements = in.nextLine().split(",");
                booklist.add(new Book(elements[0], Double.parseDouble(elements[1])));
            }
        }
        catch(IOException e){
            System.out.println("exception: " + e);
        }
        //printBookList(booklist);
    }


    public static void printBookList(ArrayList<Book> list){
        for (Book b : list){
            System.out.println(b.getName() + " " + b.getRating());
        }
    }
}
