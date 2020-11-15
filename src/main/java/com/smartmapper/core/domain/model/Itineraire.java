package com.smartmapper.core.domain.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Itineraire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToMany(targetEntity=User.class, 
    fetch=FetchType.EAGER)
	private Map<String, PointInteret> points;
	@ManyToOne
    private User user;
	
	
	public Itineraire(String name) {
		this.name = name;
		this.points = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, PointInteret> getPointInteret() {
		return points;
	}

	public void setPointInteret(Map<String, PointInteret> p) {
		points = p;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Itineraire [name=");
		builder.append(name);
		builder.append(", points=");
		builder.append(points);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Itineraire other = (Itineraire) obj;
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (!points.equals(other.points))
			return false;
		return true;
	}

	public Itineraire() {
	}

	
    
}
