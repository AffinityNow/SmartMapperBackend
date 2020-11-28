package com.smartmapper.core.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.springframework.lang.Nullable;

@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    
    @ManyToOne(targetEntity=User.class)
    private User user;

    private String lines;
    private String cedex;
    private String codePostal;
    private String ville;
    private String pays;
    private String telephone;
    @OneToOne(targetEntity = PointInteret.class)
    @JsonBackReference
    @Nullable
    private PointInteret point;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLines() {
        return lines;
    }

    public void setLines(String lines) {
        this.lines = lines;
    }

    public String getCedex() {
        return cedex;
    }

    public void setCedex(String cedex) {
        this.cedex = cedex;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public PointInteret getPoint() {
        return point;
    }

    public void setPoint(PointInteret point) {
        this.point = point;
        point.setAdresse(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
        result = prime * result + ((lines == null) ? 0 : lines.hashCode());
        result = prime * result + ((pays == null) ? 0 : pays.hashCode());
        result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
        Adresse other = (Adresse) obj;
        if (codePostal == null) {
            if (other.codePostal != null)
                return false;
        } else if (!codePostal.equals(other.codePostal))
            return false;
        if (lines == null) {
            if (other.lines != null)
                return false;
        } else if (!lines.equals(other.lines))
            return false;
        if (pays == null) {
            if (other.pays != null)
                return false;
        } else if (!pays.equals(other.pays))
            return false;
        if (ville == null) {
            if (other.ville != null)
                return false;
        } else if (!ville.equals(other.ville))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Adresse [cedex=");
        builder.append(cedex);
        builder.append(", codePostal=");
        builder.append(codePostal);
        builder.append(", lines=");
        builder.append(lines);
        builder.append(", name=");
        builder.append(name);
        builder.append(", pays=");
        builder.append(pays);
        builder.append(", point=");
        builder.append(point);
        builder.append(", user=");
        builder.append(user);
        builder.append(", ville=");
        builder.append(ville);
        builder.append("]");
        return builder.toString();
    }

    public Adresse() {
    }

    Adresse(String name, User user, String lines, String cedex, String codePostal, String ville, String pays, PointInteret point, String telephone) {
        this.name = name;
        this.user = user;
        this.lines = lines;
        this.cedex = cedex;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.point = point;
        this.telephone = telephone;
    }
}
