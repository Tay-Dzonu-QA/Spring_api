package com.qa.springApi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springApi.dto.TvShowDTO;
import com.qa.springApi.service.TvShowService;

@RestController
@RequestMapping("/tvShow")
public class TvShowController {
	
	TvShowService service;

	@Autowired
	public TvShowController(TvShowService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<TvShowDTO> create(@RequestBody TvShowDTO tvShowDTO){
		TvShowDTO created =this.service.create(tvShowDTO);
		return new ResponseEntity<>(created,HttpStatus.CREATED);
	}
	
	@GetMapping("/read")
	public ResponseEntity<List<TvShowDTO>> read(){
		return ResponseEntity.ok(this.service.read());
	}
	
	@GetMapping("read/{id}")
	public ResponseEntity<TvShowDTO> readAll(@PathVariable Long id){
		return ResponseEntity.ok(this.service.read(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<TvShowDTO> update(@PathVariable Long id,
			@RequestBody TvShowDTO tvShowDTO){
		TvShowDTO updated = this.service.update(tvShowDTO, id);
		return new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TvShowDTO> delete(@PathVariable Long id){
		return this.service.delete(id)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
