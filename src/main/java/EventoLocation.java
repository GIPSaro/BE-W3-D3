import javax.persistence.*;

@Entity
@Table(name = "locations")
public class EventoLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String citta;

    // CONSTRUCTORS

    public EventoLocation() {
    }

    public EventoLocation(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    // OVERRIDES

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }


    // GETTERS

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // SETTERS

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}

