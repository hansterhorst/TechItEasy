package com.techiteasy.models;

import javax.persistence.*;

@Entity(name = "Television")
@Table(name = "televisions")
public class Television {

   @Id
   @SequenceGenerator(name = "television_id_sequence", sequenceName = "television_id_sequence", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "television_id_sequence")
   @Column(name = "television_id", nullable = false, updatable = false)
   private Long id;
   private String type;
   private String brand;
   private String name;
   private Double price;

   public Television() {
   }

   public Television(Long id, String type, String brand, String name, Double price) {
      this.id = id;
      this.type = type;
      this.brand = brand;
      this.name = name;
      this.price = price;
   }


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getBrand() {
      return brand;
   }

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   @Override
   public String toString() {
      return "Television{" +
         "id=" + id +
         ", type='" + type + '\'' +
         ", brand='" + brand + '\'' +
         ", name='" + name + '\'' +
         ", price=" + price +
         '}';
   }
}
