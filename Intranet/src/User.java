import java.io.Serializable;

/**
 * @generated
 */
public class User implements Serializable, Comparable {

    /**
     * @generated
     */
    private Integer id;

    /**
     * @generated
     */
    private String username;

    /**
     * @generated
     */
    private String password;

    /**
     * @generated
     */
    private String name;

    /**
     * @generated
     */
    private String surname;

    /**
     * @generated
     */
    private Boolean isLogged;


    /**
     * @generated
     */
    private Database database;


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
    private String getUsername() {
        return this.username;
    }

    /**
     * @generated
     */
    private void setUsername(String username) {
        this.username = username;
    }

    /**
     * @generated
     */
    private String getPassword() {
        return this.password;
    }

    /**
     * @generated
     */
    private void setPassword(String password) {
        this.password = password;
    }

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
    private String getSurname() {
        return this.surname;
    }

    /**
     * @generated
     */
    private void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @generated
     */
    private Boolean getIsLogged() {
        return this.isLogged;
    }

    /**
     * @generated
     */
    private void setIsLogged(Boolean isLogged) {
        this.isLogged = isLogged;
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
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


    //                          Operations

//    /**
//     * @generated
//     */
//    public getUsername() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public setUsername() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public getPassword() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public setPassword() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public getName() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public setName() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public getSurname() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public setSurname() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public login() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public getId() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public setId() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public int hashCode() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public equals() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public void toString() {
//        //TODO
//    }
//
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
}
