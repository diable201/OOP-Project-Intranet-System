import java.io.Serializable;
import java.util.ArrayList;

/**
* @generated
*/
public class Database implements Serializable {
    
    /**
    * @generated
    */
    private ArrayList<User> users;
    
    /**
    * @generated
    */
    private ArrayList <Message> messages;
    
    
    /**
    * @generated
    */
    private User user;
    
    /**
    * @generated
    */
    private Message message;
    
    
    /**
    * @generated
    */
    private ArrayList <User> getUsers() {
        return this.users;
    }
    
    /**
    * @generated
    */
    private ArrayList <User> setUsers(ArrayList <User> users) {
        this.users = users;
    }
    
    /**
    * @generated
    */
    private ArrayList <Message> getMessages() {
        return this.messages;
    }
    
    /**
    * @generated
    */
    private ArrayList <Message> setMessages(ArrayList <Message> messages) {
        this.messages = messages;
    }
    
    
    /**
    * @generated
    */
    public Message getMessage() {
        return this.message;
    }
    
    /**
    * @generated
    */
    public Message setMessage(Message message) {
        this.message = message;
    }
    
    /**
    * @generated
    */
    public User getUser() {
        return this.user;
    }
    
    /**
    * @generated
    */
    public User setUser(User user) {
        this.user = user;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public sendMessagesToUser() {
        //TODO
    }
    /**
    * @generated
    */
    public getMessagesFromUser() {
        //TODO
    }
    /**
    * @generated
    */
    public getUnreadMessages() {
        //TODO
    }
    
}
