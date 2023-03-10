package com.mandatrends.trends.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mandatrends.trends.DTO.TrendDTO;
import com.mandatrends.trends.services.TrendService;


@RestController
@RequestMapping(value = "/trends")
public class TrendResource {

	@Autowired
	private TrendService service;
	
	@GetMapping
	public ResponseEntity<Page<TrendDTO>> findAllPaged(Pageable pageable) {
			
		Page<TrendDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TrendDTO> findById(@PathVariable Long id) { 
		TrendDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto); 
	}
	
	@PostMapping
	public ResponseEntity<TrendDTO> insert(@Valid @RequestBody TrendDTO dto) { 
		dto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TrendDTO> update(@PathVariable Long id, @Valid @RequestBody TrendDTO dto) {
		
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<TrendDTO> delete(@PathVariable Long id) { 
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
