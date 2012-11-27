package org.pmg.cellar.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Christophe Coenraets
 */
@XmlRootElement
public class Wine {

    private Long id;

    private String name;

    private String grapes;

    private String country;

    private String region;
    
    private String year;
    
    private String picture;

    private String description;
    
    public Wine() {}
    
    public Wine(Long id, String name, String year, String grapes, String country, String region, String description, String picture) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.grapes = grapes;
        this.country = country;
        this.region = region;
        this.description = description;
        this.picture = picture;
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrapes() {
		return grapes;
	}

	public void setGrapes(String grapes) {
		this.grapes = grapes;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Wine");
        sb.append("{id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", grapes='").append(grapes).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append(", year='").append(year).append('\'');
        sb.append(", picture='").append(picture).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
