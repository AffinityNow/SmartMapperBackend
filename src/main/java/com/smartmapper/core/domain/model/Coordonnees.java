package com.smartmapper.core.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.springframework.lang.Nullable;


@Entity
public class Coordonnees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double longitude;
    private Double latitude;
    @OneToOne(targetEntity = PointInteret.class)
    @Nullable
    @JsonBackReference
    private PointInteret point;



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Coordonnees [x=");
        builder.append(longitude);
        builder.append(", y=");
        builder.append(latitude);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
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
        Coordonnees other = (Coordonnees) obj;
        if (longitude == null) {
            if (other.longitude != null)
                return false;
        } else if (!longitude.equals(other.longitude))
            return false;
        if (latitude == null) {
            if (other.latitude != null)
                return false;
        } else if (!latitude.equals(other.latitude))
            return false;
        return true;
    }

    public Coordonnees() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Coordonnees setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Coordonnees setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public PointInteret getPoint() {
        return point;
    }

    public Coordonnees setPoint(PointInteret point) {
        this.point = point;
        point.setCoordonnes(this);
        return this;
    }

    public Coordonnees(Double longitude, Double latitude, PointInteret point) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.point = point;
    }
}
