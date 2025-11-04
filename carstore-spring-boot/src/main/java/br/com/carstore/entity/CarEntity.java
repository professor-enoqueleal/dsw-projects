package br.com.carstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String color;
    private String brand;
    private String model;
    private String yearFabric;
    private String yearModel;

    public CarEntity() {
    }

    public CarEntity(String name, String color, String brand, String model, String yearFabric, String yearModel) {
        this.name = name;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.yearFabric = yearFabric;
        this.yearModel = yearModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getYearFabric() {
        return yearFabric;
    }

    public void setYearFabric(String yearFabric) {
        this.yearFabric = yearFabric;
    }

    public String getYearModel() {
        return yearModel;
    }

    public void setYearModel(String yearModel) {
        this.yearModel = yearModel;
    }

}
