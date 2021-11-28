package com.techiteasy.controllers;

import com.techiteasy.exceptions.BadRequestException;
import com.techiteasy.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/television")
public class TelevisionController {

   private List<String> televisions;

   public TelevisionController(List<String> televisions) {
      this.televisions = televisions;
      televisions.add("Television 1");
      televisions.add("Television 2");
      televisions.add("Television 3");
   }


   //   get all televisions
   @GetMapping
   public ResponseEntity<List<String>> getAllTelevisions() {

      if (televisions.isEmpty())
         throw new RecordNotFoundException("No records found.");

      return new ResponseEntity<>(televisions, HttpStatus.OK);
   }


   //   get television by index
   @GetMapping(value = "/{index}")
   public ResponseEntity<String> getTelevisionByIndex(@PathVariable(value = "index") int index) {
      if (index > televisions.size())
         throw new RecordNotFoundException("Record with index: " + index + " not found.");

      return new ResponseEntity<>(televisions.get(index), HttpStatus.OK);
   }


   //   add a new television
   @PostMapping
   public ResponseEntity<String> addTelevision(@RequestBody String television) {

      if (television.isEmpty() || television.isBlank())
         throw new BadRequestException("Request body is empty!");

      televisions.add(television);
      return new ResponseEntity<>(television, HttpStatus.CREATED);
   }


   //   update television
   @PutMapping(value = "/{index}")
   public ResponseEntity<String> updateTelevision(@PathVariable(value = "index") int index, @RequestBody String television) {

      if (index > televisions.size())
         throw new RecordNotFoundException("Record with index: " + index + " not found.");

      televisions.set(index, television);
      return new ResponseEntity<>(television, HttpStatus.OK);
   }


   //   delete television by index
   @DeleteMapping(value = "/{index}")
   public ResponseEntity<List<String>> deleteTelevision(@PathVariable(value = "index") int index) {
      if (index > televisions.size())
         throw new RecordNotFoundException("Record with index: " + index + " not found.");

      televisions.remove(index);

      return new ResponseEntity<>(televisions, HttpStatus.OK);
   }
}
