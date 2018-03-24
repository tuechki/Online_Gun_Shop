package org.elsys.ip.online_gun_shop.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends AbstractTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

//    @Column(name = "is_admin", nullable = false)
//    private Boolean isAdmin;

    @OneToMany(mappedBy = "user")
    private List<Favourites> favourites;

    @OneToMany(mappedBy = "user")
    private List<Reviews> reviews;

    @OneToMany(mappedBy = "user")
    private List<Purchases> purchases;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//
//    public Boolean getAdmin() {
//        return isAdmin;
//    }
//
//    public void setAdmin(Boolean admin) {
//        isAdmin = admin;
//    }

    public List<Favourites> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<Favourites> favourites) {
        this.favourites = favourites;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public List<Purchases> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchases> purchases) {
        this.purchases = purchases;
    }

    public User() {}

    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;

        this.favourites = new LinkedList<Favourites>();
        this.reviews = new LinkedList<Reviews>();
        this.purchases = new LinkedList<Purchases>();
    }
}
