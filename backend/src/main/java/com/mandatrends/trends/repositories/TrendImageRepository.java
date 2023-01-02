package com.mandatrends.trends.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mandatrends.trends.entities.TrendImage;

public interface TrendImageRepository extends JpaRepository<TrendImage, Long>{

}
