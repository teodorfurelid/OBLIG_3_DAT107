package directory;

import jakarta.persistence.*;

@Entity
@Table(schema = "oblig3", name = "prosjekt_deltagelse")
public class ProsjektDeltagelse {

    @EmbeddedId
    private ProsjektDeltagelse id = new ProsjektDeltagelseId();

    @ManyToOne
    @MapsId("ansattId")
    @JoinColumn(name = "ansattid", referencedColumnName = "ansattid")
    private Ansatt ansatt;

    @ManyToOne
    @MapsId("prosjektId")
    @JoinColumn(name = "prosjekid", referencedColumnName = "prosjektid")
    private Prosjekt prosjekt;

    @Column(name = "rolle", nullable = false)
    private String rolle;

    @Column(name = "antalltimer")
    private double antallTimer;

    // Tom konstruktør (påkrevd av JPA)
    public ProsjektDeltagelse(int ansattId, int prosjektId) {
    }

    public ProsjektDeltagelse(Ansatt ansatt, Prosjekt prosjekt, String rolle, double antallTimer) {
        this.ansatt = ansatt;
        this.prosjekt = prosjekt;
        this.rolle = rolle;
        this.antallTimer = antallTimer;
        this.id = new ProsjektDeltagelse(ansatt.getAnsattId(), prosjekt.getProsjektId());
    }

    // Gettere og settere
    public ProsjektDeltagelseId getId() {
        return id;
    }

    public void setId(ProsjektDeltagelseId id) {
        this.id = id;
    }

    public Ansatt getAnsatt() {
        return ansatt;
    }

    public void setAnsatt(Ansatt ansatt) {
        this.ansatt = ansatt;
        this.id.setAnsattId(ansatt.getAnsattId());
    }

    public Prosjekt getProsjekt() {
        return prosjekt;
    }

    public void setProsjekt(Prosjekt prosjekt) {
        this.prosjekt = prosjekt;
        this.id.setProsjektId(prosjekt.getProsjektId());
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public double getAntallTimer() {
        return antallTimer;
    }

    public void setAntallTimer(double antallTimer) {
        this.antallTimer = antallTimer;
    }

    @Override
    public String toString() {
        return "ProsjektDeltagelse{" +
                "ansatt=" + (ansatt != null ? ansatt.getBrukernavn() : "null") +
                ", prosjekt=" + (prosjekt != null ? prosjekt.getProsjektNavn() : "null") +
                ", rolle='" + rolle + '\'' +
                ", antallTimer=" + antallTimer +
                '}';
    }
}