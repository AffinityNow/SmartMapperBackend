package com.smartmapper.core.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Coordonnees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
	private Long id;
    private Double x;
    private Double y;



    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }


    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Coordonnees(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Coordonnees [x=");
        builder.append(x);
        builder.append(", y=");
        builder.append(y);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
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
        if (x == null) {
            if (other.x != null)
                return false;
        } else if (!x.equals(other.x))
            return false;
        if (y == null) {
            if (other.y != null)
                return false;
        } else if (!y.equals(other.y))
            return false;
        return true;
    }

    public Coordonnees() {
    }
}
