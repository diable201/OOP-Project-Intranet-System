import java.io.Serializable;
import java.util.Objects;

/**
 * @generated
 */
public abstract class User implements Serializable, Comparable<User> {
    /**
     * @generated
     */
    private String id;

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

    public User() {}

    public User(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = "KBTU2021";
        this.username = this.name.substring(0, 1).toLowerCase() + '_' + this.surname.toLowerCase();
        this.fullName = name + " " + surname;
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
        if (!Objects.equals(fullName, user.fullName)) return false;
        return Objects.equals(isLogged, user.isLogged);
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
    public String getId() {
        return this.id;
    }

    /**
     * @generated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @generated
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @generated
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @generated
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @generated
     */
    public void setPassword(String password) {
        this.password = password;
    }

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
    public String getSurname() {
        return this.surname;
    }

    /**
     * @generated
     */
    public void setFullName(String name, String surname) {
        this.fullName = name + " " + surname;
    }

    /**
     * @generated
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * @generated
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @generated
     */
    public Boolean getIsLogged() {
        return this.isLogged;
    }

    /**
     * @generated
     */
    public void setIsLogged(Boolean isLogged) {
        this.isLogged = isLogged;
    }


    //                          Operations
    public boolean changePassword(String currentPassword, String newPassword) {
        // TODO add hash
        if (currentPassword.equals(this.password)) {
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
