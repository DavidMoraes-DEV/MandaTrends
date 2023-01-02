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

import com.mandatrends.trends.DTO.TrendImageDTO;
import com.mandatrends.trends.entities.TrendImage;
import com.mandatrends.trends.repositories.TrendImageRepository;
import com.mandatrends.trends.repositories.TrendRepository;
import com.mandatrends.trends.services.exceptions.DataBaseException;
import com.mandatrends.trends.services.exceptions.ResourceNotFoundException;

@Service
public class TrendImageService {

	@Autowired
	private TrendImageRepository repository;
	
	@Autowired
	private TrendRepository trendRepository;
	
	@Transactional(readOnly = true)
	public Page<TrendImageDTO> findAllPaged (Pageable pageable) {
		Page<TrendImage> list = repository.findAll(pageable);
	
		Page<TrendImageDTO> listDto = list.map(x -> new TrendImageDTO(x));
		
		return listDto;
	}
	
	@Transactional(readOnly = true)
	public TrendImageDTO findById(Long id) {
		Optional<TrendImage> obj = repository.findById(id);
		TrendImage entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new TrendImageDTO(entity);
	}
	
	@Transactional
	public TrendImageDTO insert(TrendImageDTO dto) {
		TrendImage entity = new TrendImage();
		entity.setImgUrl(dto.getImgUrl());
		entity.setTrend(trendRepository.getOne(dto.getTrendId()));
		entity = repository.save(entity);
		return new TrendImageDTO(entity);
	}

	@Transactional
	public TrendImageDTO update(Long id, TrendImageDTO dto) {
		try {
		TrendImage entity = repository.getOne(id);
		entity.setImgUrl(dto.getImgUrl());
		entity.setTrend(trendRepository.getOne(dto.getTrendId()));
		entity = repository.save(entity);
		return new TrendImageDTO(entity);
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
	
}
