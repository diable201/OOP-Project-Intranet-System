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

}
