package com.mandatrends.trends.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mandatrends.trends.DTO.TrendDTO;
import com.mandatrends.trends.DTO.TrendImageDTO;
import com.mandatrends.trends.entities.Trend;
import com.mandatrends.trends.entities.TrendImage;
import com.mandatrends.trends.repositories.TrendImageRepository;
import com.mandatrends.trends.repositories.TrendRepository;
import com.mandatrends.trends.services.exceptions.DataBaseException;
import com.mandatrends.trends.services.exceptions.ResourceNotFoundException;

@Service
public class TrendService {

	@Autowired
	private TrendRepository repository;
	
	@Autowired
	private TrendImageRepository trendImageRepository;
	
	@Transactional(readOnly = true)
	public Page<TrendDTO> findAllPaged (Pageable pageable) {
		Page<Trend> list = repository.findAll(pageable);
	
		Page<TrendDTO> listDto = list.map(x -> new TrendDTO(x, x.getImgsUrl()));
		
		return listDto;
	}
	
	@Transactional(readOnly = true)
	public TrendDTO findById(Long id) {
		Optional<Trend> obj = repository.findById(id);
		Trend entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new TrendDTO(entity, entity.getImgsUrl());
	}
	
	@Transactional
	public TrendDTO insert(TrendDTO dto) {
		Trend entity = new Trend();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new TrendDTO(entity, entity.getImgsUrl());
	}

	@Transactional
	public TrendDTO update(Long id, TrendDTO dto) {
		try {
		Trend entity = repository.getOne(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new TrendDTO(entity, entity.getImgsUrl());
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);	
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation");
		}
	}

	private void copyDtoToEntity(TrendDTO dto, Trend entity) {

		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setMainSubject(dto.getMainSubject());
		entity.setSource(dto.getSource());	
		entity.setSourceUrl(dto.getSourceUrl());
		
		for (TrendImageDTO trendImgDto : dto.getImgsUrl()) {
			TrendImage trendImage = trendImageRepository.getOne(trendImgDto.getId());
			entity.getImgsUrl().add(trendImage);
		}
		
	}
	
}
