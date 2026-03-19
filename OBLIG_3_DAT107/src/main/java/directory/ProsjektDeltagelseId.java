import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

// Embeddable ID-klasse for sammensatt nøkkel
@Embeddable
public class ProsjektDeltagelseId implements Serializable {

    @Column(name = "ansattid")
    private int ansattId;

    @Column(name = "prosjekid")
    private int prosjektId;

    public ProsjektDeltagelseId() {
    }

    public ProsjektDeltagelseId(int ansattId, int prosjektId) {
        this.ansattId = ansattId;
        this.prosjektId = prosjektId;
    }

    public int getAnsattId() {
        return ansattId;
    }

    public void setAnsattId(int ansattId) {
        this.ansattId = ansattId;
    }

    public int getProsjektId() {
        return prosjektId;
    }

    public void setProsjektId(int prosjektId) {
        this.prosjektId = prosjektId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProsjektDeltagelseId that = (ProsjektDeltagelseId) o;
        return ansattId == that.ansattId && prosjektId == that.prosjektId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ansattId, prosjektId);
    }
}