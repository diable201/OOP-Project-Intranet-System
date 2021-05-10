import java.util.Date;

/**
* @generated
*/
public class News {

    public News() {}

    public News(Date date, String description, String title) {
        this.date = date;
        this.description = description;
        this.title = title;
    }

    /**
    * @generated
    */
    private Date date;
    
    /**
    * @generated
    */
    private String description;
    
    /**
    * @generated
    */
    private String title;

    /**
    * @generated
    */
    private Date getDate() {
        return this.date;
    }
    
    /**
    * @generated
    */
    private void setDate(Date date) {
        this.date = date;
    }
    
    /**
    * @generated
    */
    private String getDescription() {
        return this.description;
    }
    
    /**
    * @generated
    */
    private void setDescription(String description) {
        this.description = description;
    }
    
    /**
    * @generated
    */
    private String getTitle() {
        return this.title;
    }
    
    /**
    * @generated
    */
    private void setTitle(String title) {
        this.title = title;
    }

    //                          Operations
}
