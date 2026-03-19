package directory;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema = "oblig3")

public class Ansatt {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ansattId;

    private String brukernavn;
    private String fornavn;
    private String etternavn;
    private String ansattDato;
    private String stilling;
    private double lonnMande;

    @ManyToOne
    @JoinColumn(name="avdeling", referencedColumnName="avdelingNr")
    private Avdeling avdeling;

    @OneToMany(mappedBy = "ansatt")
    public List<Prosjekt_Deltagelse> prosjekter;

    public Ansatt (){}

    public Ansatt(int ansattId, String brukernavn, String fornavn, String etternavn,
                  String ansattDato, double lonnMande, Avdeling avdeling) {
        this.ansattId = ansattId;
        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.ansattDato = ansattDato;
        this.lonnMande = lonnMande;
        this.avdeling = avdeling;
    }

    public int getAnsattId() {
        return ansattId;
    }

    public void setAnsattId(int ansattId) {
        this.ansattId = ansattId;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getAnsattDato() {
        return this.ansattDato;
    }

    public void setAnsattDato(String ansattDato) {
        this.ansattDato = ansattDato;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public double getLonnMande() {
        return lonnMande;
    }

    public void setLonnMande(double lonnMande) {
        this.lonnMande = lonnMande;
    }

    public Avdeling getAvdeling() {
        return avdeling;
    }

    public void setAvdeling(Avdeling avdeling) {
        this.avdeling = avdeling;
    }

    public List<Prosjekt_Deltagelse> getProsjekter() {
        return prosjekter;
    }

    public void setProsjekter(List<Prosjekt_Deltagelse> prosjekter) {
        this.prosjekter = prosjekter;
    }

    @Override
    public String toString() {
        return "Ansatt{" +
                "ansattId=" + ansattId +
                ", brukernavn='" + brukernavn + '\'' +
                ", fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", ansattDato='" + ansattDato + '\'' +
                ", stilling='" + stilling + '\'' +
                ", lonnMande=" + lonnMande +
                ", avdeling=" + avdeling +
                ", prosjekter=" + prosjekter +
                '}';
    }
}


