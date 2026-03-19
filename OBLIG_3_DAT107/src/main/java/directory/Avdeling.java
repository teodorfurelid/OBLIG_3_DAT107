package directory;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "oblig3")

public class Avdeling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "avdelingNr")
    private int avdelingNr;

    private String avdelingNavn;

    @OneToOne
    @JoinColumn(name = "avdeling", referencedColumnName = "ansattId")
    private Ansatt sjef;

    @OneToMany(mappedBy = "avdeling")
    private List<Ansatt> ansatte = new ArrayList<>();

    private Avdeling() {
    }

    private Avdeling(String navn) {
        this.avdelingNavn = navn;
    }

    private Avdeling(String avdelingNavn, Ansatt sjef) {
        this.avdelingNavn = avdelingNavn;
        this.sjef = sjef;
    }

    public int getAvdelingNr() {
        return avdelingNr;
    }

    public void setAvdelingNr(int avdelingNr) {
        this.avdelingNr = avdelingNr;
    }

    public String getAvdelingNavn() {
        return avdelingNavn;
    }

    public void setAvdelingNavn(String avdelingNavn) {
        this.avdelingNavn = avdelingNavn;
    }

    public Ansatt getSjef() {
        return sjef;
    }

    public void setSjef(Ansatt sjef) {
        this.sjef = sjef;
    }

    public List<Ansatt> getAnsatte() {
        return ansatte;
    }

    public void setAnsatte(List<Ansatt> ansatte) {
        this.ansatte = ansatte;
    }

    @Override
    public String toString() {
        return "Avdeling{" +
                "avdelingNr=" + avdelingNr +
                ", avdelingNavn='" + avdelingNavn + '\'' +
                '}';
    }
}

