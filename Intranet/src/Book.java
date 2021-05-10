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
    private String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    private void setName(String name) {
        this.name = name;
    }
    
    /**
    * @generated
    */
    private Integer getId() {
        return this.id;
    }
    
    /**
    * @generated
    */
    private void setId(Integer id) {
        this.id = id;
    }
    
    /**
    * @generated
    */
    private String getAuthor() {
        return this.author;
    }
    
    /**
    * @generated
    */
    private void setAuthor(String author) {
        this.author = author;
    }
    
    /**
    * @generated
    */
    private String getLink() {
        return this.link;
    }
    
    /**
    * @generated
    */
    private void setLink(String link) {
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
    

    //                          Operations
}
