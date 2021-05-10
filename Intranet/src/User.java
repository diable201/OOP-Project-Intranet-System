import java.io.Serializable;
import java.util.Objects;

/**
 * @generated
 */
public abstract class User implements Serializable, Comparable<User> {
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
    private String fullName;

    /**
     * @generated
     */
    private Boolean isLogged;

    /**
     * @generated
     */
    private Database database;

    public User() {}

    public User(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = "KBTU2021";
        this.username = this.name.substring(0, 1).toLowerCase() + '_' + this.surname.toLowerCase();
    }

    /**
     * @generated
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", isLogged=" + isLogged +
                ", database=" + database +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (!Objects.equals(id, user.id)) return false;
        if (!Objects.equals(username, user.username)) return false;
        if (!Objects.equals(password, user.password)) return false;
        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(surname, user.surname)) return false;
        if (!Objects.equals(isLogged, user.isLogged)) return false;
        return Objects.equals(database, user.database);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, username, password, id);
    }

    @Override
    public int compareTo(User user) {
        return username.compareTo(user.username);
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
    private void setFullName(String name, String surname) {
        this.fullName = name + " " + surname;
    }

    /**
     * @generated
     */
    private String getFullName() {
        return this.fullName;
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


    //                          Operations

    public boolean changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(this.password)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    public boolean login(String password) {
        this.isLogged = this.password.equals(password);
        return this.isLogged;
    }

    /**
     * @generated
     */
    public boolean logout() {
        return this.isLogged = false;
    }
}
