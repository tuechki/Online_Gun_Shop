package org.elsys.ip.online_gun_shop.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "weapon")
public class Weapon extends AbstractTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "caliber", nullable = false)
    private String caliber;

    @Column(name = "barrel_length", nullable = false)
    private Double barrelLength;

    @Column(name = "capacity", nullable = false)
    private String capacity;

    @Column(name = "frame_finish", nullable = false)
    private String frameFinish;

    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "price", nullable = false, precision = 12, scale = 2)
    private Double price;

    private List<Favourites> favourites;

    private List<Reviews> reviews;

    private List<Purchases> purchases;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public Double getBarrelLength() {
        return barrelLength;
    }

    public void setBarrelLength(Double barrelLength) {
        this.barrelLength = barrelLength;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getFrameFinish() {
        return frameFinish;
    }

    public void setFrameFinish(String frameFinish) {
        this.frameFinish = frameFinish;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "weapon")
    public List<Favourites> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<Favourites> favourites) {
        this.favourites = favourites;
    }

    @OneToMany(mappedBy = "weapon")
    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    @OneToMany(mappedBy = "weapon")
    public List<Purchases> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchases> purchases) {
        this.purchases = purchases;
    }

    public Weapon(String category, String brand, String model, String caliber, Double barrelLength, String capacity,
                  String frameFinish, String material, Double weight, Double price) {
        this.category = category;
        this.brand = brand;
        this.model = model;
        this.caliber = caliber;
        this.barrelLength = barrelLength;
        this.capacity = capacity;
        this.frameFinish = frameFinish;
        this.material = material;
        this.weight = weight;
        this.price = price;

        this.favourites = new LinkedList<Favourites>();
        this.reviews = new LinkedList<Reviews>();
        this.purchases = new LinkedList<Purchases>();
    }
}
