package com.techiteasy.dtos;

import com.techiteasy.models.Television;

public class TelevisionDTO {

   private Long id;
   private String type;
   private String brand;
   private String name;
   private Double price;

   public TelevisionDTO() {
   }

   public TelevisionDTO(Long id, String type, String brand, String name, Double price) {
      this.id = id;
      this.type = type;
      this.brand = brand;
      this.name = name;
      this.price = price;
   }

   public static TelevisionDTO televisionToDTO(Television television) {


      TelevisionDTO televisionDTO = new TelevisionDTO();
      televisionDTO.setId(television.getId());
      televisionDTO.setType(television.getType());
      televisionDTO.setBrand(television.getBrand());
      televisionDTO.setName(television.getName());
      televisionDTO.setPrice(television.getPrice());

      return televisionDTO;
   }

   public static Television dtoToTelevision(TelevisionDTO televisionDTO) {

      Television television = new Television();
      television.setId(televisionDTO.getId());
      television.setType(televisionDTO.getType());
      television.setBrand(televisionDTO.getBrand());
      television.setName(televisionDTO.getName());
      television.setPrice(televisionDTO.getPrice());
      
      return television;
   }

   public static Long dtoId(Long id) {
      TelevisionDTO televisionDTO = new TelevisionDTO();
      televisionDTO.setId(id);
      return televisionDTO.getId();
   }

   public static Long televisionId(Long id) {
      Television television = new Television();
      television.setId(id);
      return television.getId();
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
      return "TelevisionDTO{" +
         "id=" + id +
         ", type='" + type + '\'' +
         ", brand='" + brand + '\'' +
         ", name='" + name + '\'' +
         ", price=" + price +
         '}';
   }
}
