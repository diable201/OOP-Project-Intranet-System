import java.util.Objects;

/**
* @generated
*/
public class Message {

    public Message() {}

    public Message(String body, User sender, User receiver, Boolean isRead) {
        this.body = body;
        this.sender = sender;
        this.receiver = receiver;
        this.isRead = isRead;
    }

    /**
    * @generated
    */
    private String body;
    
    /**
    * @generated
    */
    private User sender;
    
    /**
    * @generated
    */
    private User receiver;
    
    /**
    * @generated
    */
    private Boolean isRead;
    
    
    /**
    * @generated
    */
    private Database database;
    
    
    /**
    * @generated
    */
    private String getBody() {
        return this.body;
    }
    
    /**
    * @generated
    */
    private void setBody(String body) {
        this.body = body;
    }
    
    /**
    * @generated
    */
    private User getSender() {
        return this.sender;
    }
    
    /**
    * @generated
    */
    private void setSender(User sender) {
        this.sender = sender;
    }
    
    /**
    * @generated
    */
    private User getReceiver() {
        return this.receiver;
    }
    
    /**
    * @generated
    */
    private void setReceiver(User receiver) {
        this.receiver = receiver;
    }
    
    /**
    * @generated
    */
    private Boolean getIsRead() {
        return this.isRead;
    }
    
    /**
    * @generated
    */
    private void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }
    
    
    /**
    * @generated
    */
    public Database getDatabase() {
        return this.database;
    }
    
    /**
    * @generated
    */
    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!Objects.equals(body, message.body)) return false;
        if (!Objects.equals(sender, message.sender)) return false;
        if (!Objects.equals(receiver, message.receiver)) return false;
        if (!Objects.equals(isRead, message.isRead)) return false;
        return Objects.equals(database, message.database);
    }

    @Override
    public int hashCode() {
        int result = body != null ? body.hashCode() : 0;
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (receiver != null ? receiver.hashCode() : 0);
        result = 31 * result + (isRead != null ? isRead.hashCode() : 0);
        result = 31 * result + (database != null ? database.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "body='" + body + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", isRead=" + isRead +
                ", database=" + database +
                '}';
    }
}
