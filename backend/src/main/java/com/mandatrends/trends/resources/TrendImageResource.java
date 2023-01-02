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

import com.mandatrends.trends.DTO.TrendImageDTO;
import com.mandatrends.trends.services.TrendImageService;


@RestController
@RequestMapping(value = "/trend-images")
public class TrendImageResource {

	@Autowired
	private TrendImageService service;
	
	@GetMapping
	public ResponseEntity<Page<TrendImageDTO>> findAllPaged(Pageable pageable) {
			
		Page<TrendImageDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TrendImageDTO> findById(@PathVariable Long id) { 
		TrendImageDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto); 
	}
	
	@PostMapping
	public ResponseEntity<TrendImageDTO> insert(@Valid @RequestBody TrendImageDTO dto) { 
		dto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TrendImageDTO> update(@PathVariable Long id, @Valid @RequestBody TrendImageDTO dto) {
		
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<TrendImageDTO> delete(@PathVariable Long id) { 
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
