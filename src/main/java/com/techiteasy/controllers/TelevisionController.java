package com.techiteasy.controllers;

import com.techiteasy.models.Television;
import com.techiteasy.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/television")
public class TelevisionController {

   private final TelevisionService televisionService;


   @Autowired
   public TelevisionController(TelevisionService televisionService) {
      this.televisionService = televisionService;
   }


   //   get all televisions
   @GetMapping
   public ResponseEntity<List<Television>> getAllTelevisions() {
      return new ResponseEntity<>(televisionService.getAllTelevisions(), HttpStatus.OK);
   }


   //   get television by index
   @GetMapping(value = "/{id}")
   public ResponseEntity<Television> getTelevisionByIndex(@PathVariable(value = "id") Long id) {
      return new ResponseEntity<>(televisionService.getTelevisionById(id), HttpStatus.OK);
   }


   //   add a new television
   @PostMapping
   public ResponseEntity<Television> addTelevision(@RequestBody Television television) {
      return new ResponseEntity<>(televisionService.createTelevision(television), HttpStatus.CREATED);
   }


   //   update television
   @PutMapping(value = "/{id}")
   public ResponseEntity<Television> updateTelevision(@PathVariable(value = "id") Long id, @RequestBody Television television) {

      return new ResponseEntity<>(televisionService.updateTelevision(id, television), HttpStatus.OK);
   }


   //   delete television by index
   @DeleteMapping(value = "/{id}")
   public ResponseEntity<List<Television>> deleteTelevision(@PathVariable(value = "id") Long id) {
      return new ResponseEntity<>(televisionService.deleteTelevision(id), HttpStatus.OK);
   }
}
