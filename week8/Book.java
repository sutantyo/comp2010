


//public class Book {
public class Book implements Comparable<Book>{

    private String name;
    private Double rating;

    public Book(String name, Double rating){
        this.name = name;
        this.rating = rating;
    }

    public String getName(){
        return name;
    }

    public Double getRating(){
        return rating;
    }

    public int compareTo(Book other){
        return this.rating.compareTo(other.rating);
    }
}
