package com.mandatrends.trends.DTO;

import com.mandatrends.trends.entities.TrendImage;

public class TrendImageDTO {

	private Long id;
	private String imgUrl;

	private Long trendId;
	
	public TrendImageDTO() {
	}

	public TrendImageDTO(Long id, String imgUrl, Long trendId) {
		this.id = id;
		this.imgUrl = imgUrl;
		this.trendId = trendId;
	}
	
	public TrendImageDTO(TrendImage entity) {
		id = entity.getId();
		imgUrl = entity.getImgUrl();
		trendId = entity.getTrend().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Long getTrendId() {
		return trendId;
	}

	public void setTrendId(Long trendId) {
		this.trendId = trendId;
	}
	
}
