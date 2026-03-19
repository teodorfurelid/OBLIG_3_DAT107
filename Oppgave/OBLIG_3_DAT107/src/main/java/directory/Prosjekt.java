package directory;

import jakarta.persistence.*;

@Entity
@Table(schema = "oblig3")

public class Prosjekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjektId;
    private String prosjektNavn;
    private String prosjektBeskrivelse;

    public int getProsjektId() {
        return this.prosjektId;
    }

    public void setProsjektId(int nyProsjektId) {
        this.prosjektId = nyProsjektId;
    }

    public String getProsjektNavn() {
        return this.prosjektNavn;
    }

    public void setProsjektNavn(String nyProsjektNavn) {
        this.prosjektNavn = nyProsjektNavn;
    }

    public String getProsjektBeskrivelse() {
        return this.prosjektBeskrivelse;
    }

    public void setProsjektBeskrivelse(String nyProsjektBeskrivelse) {
        this.prosjektBeskrivelse = nyProsjektBeskrivelse;
    }

    @Override
    public String toString() {
        return "Prosjekt{" +
                "prosjektId=" + prosjektId +
                ", prosjektNavn='" + prosjektNavn + '\'' +
                ", prosjektBeskrivelse='" + prosjektBeskrivelse + '\'' +
                '}';
    }
}

