import java.util.Objects;

/**
* @generated
*/
public class Message {
    /**
    * @generated
    */
    private String body;
    
    /**
    * @generated
    */
    private String sender;
    
    /**
    * @generated
    */
    private String receiver;
    
    /**
    * @generated
    */
    private Boolean isRead;

    public Message() {}

    public Message(String body, String sender, String receiver) {
        this.body = body;
        this.sender = sender;
        this.receiver = receiver;
    }
    
    /**
    * @generated
    */
    public String getBody() {
        return this.body;
    }
    
    /**
    * @generated
    */
    public void setBody(String body) {
        this.body = body;
    }
    
    /**
    * @generated
    */
    public String getSender() {
        return this.sender;
    }
    
    /**
    * @generated
    */
    public void setSender(String sender) {
        this.sender = sender;
    }
    
    /**
    * @generated
    */
    public String getReceiver() {
        return this.receiver;
    }
    
    /**
    * @generated
    */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    
    /**
    * @generated
    */
    public Boolean getIsRead() {
        return this.isRead;
    }
    
    /**
    * @generated
    */
    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        if (!Objects.equals(body, message.body)) return false;
        if (!Objects.equals(sender, message.sender)) return false;
        if (!Objects.equals(receiver, message.receiver)) return false;
        return Objects.equals(isRead, message.isRead);
    }

    @Override
    public int hashCode() {
        int result = body != null ? body.hashCode() : 0;
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (receiver != null ? receiver.hashCode() : 0);
        result = 31 * result + (isRead != null ? isRead.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message: " +
                "body = '" + body + '\'' +
                ", sender = " + sender +
                ", receiver = " + receiver;
    }
}
