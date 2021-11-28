package com.techiteasy.services;

import com.techiteasy.exceptions.BadRequestException;
import com.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.models.Television;
import com.techiteasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {

   private final TelevisionRepository televisionRepository;

   @Autowired
   public TelevisionService(TelevisionRepository televisionRepository) {
      this.televisionRepository = televisionRepository;
   }


   /*
    * Get all televisions
    * */
   public List<Television> getAllTelevisions() {

      if (televisionRepository.findAll().isEmpty())
         throw new RecordNotFoundException("No televisions found!");

      return televisionRepository.findAll();
   }

   /*
    * Get television by id
    * */
   public Television getTelevisionById(Long id) {

      return televisionRepository.findById(id).orElseThrow(() ->
         new RecordNotFoundException(String.format("Television with id: %s not found", id)));
   }


   /*
    * Create a new television
    * */
   public Television createTelevision(Television television) {

      try {
         new ResponseEntity<>(televisionRepository.save(television), HttpStatus.CREATED);
         return getTelevisionById(television.getId());
      } catch (BadRequestException e) {
         throw new BadRequestException("Request body is empty!");
      }
   }


   /*
    * Update television by id
    * */
   public Television updateTelevision(Long id, Television television) {

      Television updateTelevision = televisionRepository.findById(id).orElseThrow(() ->
         new RecordNotFoundException(String.format("Television with id: %s not found", id)));

      updateTelevision.setBrand(television.getBrand());
      updateTelevision.setName(television.getName());
      updateTelevision.setType(television.getType());
      updateTelevision.setPrice(television.getPrice());

      return televisionRepository.save(updateTelevision);
   }


   /*
    * Delete television by id
    * */
   public List<Television> deleteTelevision(Long id) {

      if (!televisionRepository.existsById(id)) {
         throw new RecordNotFoundException(String.format("Television with id: %s not found", id));
      } else {
         televisionRepository.deleteById(id);
         return getAllTelevisions();
      }
   }

}
