package com.smartmapper.core.domain.model;

import javax.persistence.Entity;

@Entity
public class Favori extends PointInteret {
    

    private Note note;

    public Favori(String name, Coordonnees coordonnes, String description, Note note) {
        super(name, coordonnes, description);
        this.note = note;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return super.toString() + "Favori [note=" + note + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        return true;
    }

    
}
