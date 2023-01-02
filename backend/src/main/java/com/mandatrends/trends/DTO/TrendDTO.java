package com.mandatrends.trends.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.mandatrends.trends.entities.Trend;
import com.mandatrends.trends.entities.TrendImage;

public class TrendDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;

	@NotBlank(message = "Campo Obrigatório")
	private String title;
	
	@NotBlank(message = "Campo Obrigatório")
	private String description;
	

	@NotBlank(message = "Campo Obrigatório")
	private String mainSubject;

	@NotBlank(message = "Campo Obrigatório")
	private String sourceUrl;
	
	@NotBlank(message = "Campo Obrigatório")
	private String source;

	private List<TrendImageDTO> imgsUrl = new ArrayList<>();
	
	public TrendDTO() {
	}

	public TrendDTO(Long id, String title, String description, String mainSubject, String source, String sourceUrl) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.mainSubject = mainSubject;
		this.source = source;
		this.sourceUrl = sourceUrl;
	}
	
	public TrendDTO(Trend entity, List<TrendImage> trendImages) {
		id = entity.getId();
		title = entity.getTitle();
		description = entity.getDescription();
		mainSubject = entity.getMainSubject();
		source = entity.getSource();
		sourceUrl = entity.getSourceUrl();
		trendImages.forEach(img -> this.imgsUrl.add(new TrendImageDTO(img)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMainSubject() {
		return mainSubject;
	}

	public void setMainSubject(String mainSubject) {
		this.mainSubject = mainSubject;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public List<TrendImageDTO> getImgsUrl() {
		return imgsUrl;
	}
	
}
