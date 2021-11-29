package com.techiteasy.services;

import com.techiteasy.dtos.TelevisionDTO;
import com.techiteasy.exceptions.BadRequestException;
import com.techiteasy.exceptions.RecordNotFoundException;
import com.techiteasy.models.Television;
import com.techiteasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
   public List<TelevisionDTO> getAllTelevisions() {

      if (televisionRepository.findAll().isEmpty())
         throw new RecordNotFoundException("No televisions found!");

      List<TelevisionDTO> televisionDTOList = new ArrayList<>();

      for (Television television : televisionRepository.findAll()) {

         televisionDTOList.add(TelevisionDTO.televisionToDTO(television));
      }

      return televisionDTOList;
   }

   /*
    * Get television by id
    * */
   public TelevisionDTO getTelevisionById(Long id) {

      Television television = televisionRepository.findById(id).orElseThrow(() ->
         new RecordNotFoundException(String.format("Television with id: %s not found", id)));

      return TelevisionDTO.televisionToDTO(television);
   }


   /*
    * Create a new television
    * */
   public TelevisionDTO createTelevision(TelevisionDTO television) {

      try {
         Television newTelevision = televisionRepository.save(TelevisionDTO.dtoToTelevision(television));

         return TelevisionDTO.televisionToDTO(newTelevision);

      } catch (BadRequestException e) {
         throw new BadRequestException("Request body is empty!");
      }
   }


   /*
    * Update television by id
    * */
   public TelevisionDTO updateTelevision(Long id, TelevisionDTO televisionDTO) {

      Television updateTelevision = televisionRepository.findById(id).orElseThrow(() ->
         new RecordNotFoundException(String.format("Television with id: %s not found", id)));

      updateTelevision.setBrand(televisionDTO.getBrand());
      updateTelevision.setName(televisionDTO.getName());
      updateTelevision.setType(televisionDTO.getType());
      updateTelevision.setPrice(televisionDTO.getPrice());

      televisionRepository.save(updateTelevision);

      return getTelevisionById(id);
   }


   /*
    * Delete television by id
    * */
   public List<TelevisionDTO> deleteTelevision(Long id) {

      if (!televisionRepository.existsById(id)) {
         throw new RecordNotFoundException(String.format("Television with id: %s not found", id));
      } else {
         televisionRepository.deleteById(id);
         return getAllTelevisions();
      }
   }

}
