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

import com.qa.springApi.dto.ChannelDTO;
import com.qa.springApi.service.ChannelService;

@RestController
@RequestMapping("/channel")
public class ChannelController {

	ChannelService service;

	@Autowired
	public ChannelController(ChannelService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<ChannelDTO> create(@RequestBody ChannelDTO channelDTO){
		ChannelDTO created =this.service.create(channelDTO);
		return new ResponseEntity<>(created,HttpStatus.CREATED);
	}
	@GetMapping("/read")
	public ResponseEntity<List<ChannelDTO>> read(){
		return ResponseEntity.ok(this.service.read());
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<ChannelDTO> readAll(@PathVariable Long id){
		return ResponseEntity.ok(this.service.read(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ChannelDTO> update(@PathVariable Long id,
			@RequestBody ChannelDTO channelDTO){
		ChannelDTO updated = this.service.update(channelDTO, id);
		return new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ChannelDTO> delete(@PathVariable Long id){
		return this.service.delete(id)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
