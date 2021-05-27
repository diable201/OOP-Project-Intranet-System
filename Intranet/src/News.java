import java.io.Serializable;
import java.util.Date;

/**
 * @generated
 */
public class News implements Cloneable, Serializable {

    public News() {}

    public News(String description, String title) {
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

    public Date getDate() {
        return this.date;
    }

    /**
     * @generated
     */

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @generated
     */

    public String getDescription() {
        return this.description;
    }

    /**
     * @generated
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @generated
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @generated
     */
    public void setTitle(String title) {
        this.title = title;
    }

    //                          Operations
    public String showNews() {
        StringBuilder s = new StringBuilder();
        for (News n: Database.news) {
            s.append(n).append("\n");
        }
        return s.toString();
    }


    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public String toString() {
        return "Title: " + title + "\nDescription: " + description;
    }

}
