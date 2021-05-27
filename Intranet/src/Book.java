/**
* @generated
*/
public class Book {

    public Book() {}

    public Book(String name, Integer id, String author, String link) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.link = link;
    }

    /**
    * @generated
    */
    private String name;
    
    /**
    * @generated
    */
    private Integer id;
    
    /**
    * @generated
    */
    private String author;
    
    /**
    * @generated
    */
    private String link;
    
    
    /**
    * @generated
    */
    private Librarian librarian;
    
    
    /**
    * @generated
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
    * @generated
    */
    public Integer getId() {
        return this.id;
    }
    
    /**
    * @generated
    */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
    * @generated
    */
    public String getAuthor() {
        return this.author;
    }
    
    /**
    * @generated
    */
    public void setAuthor(String author) {
        this.author = author;
    }
    
    /**
    * @generated
    */
    public String getLink() {
        return this.link;
    }
    
    /**
    * @generated
    */
    public void setLink(String link) {
        this.link = link;
    }
    
    
    /**
    * @generated
    */
    public Librarian getLibrarian() {
        return this.librarian;
    }
    
    /**
    * @generated
    */
    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", author='" + author + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    //                          Operations
}
