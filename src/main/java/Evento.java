import utilities.TipoEvento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Eventi")
public class Evento {
    @Id
    @GeneratedValue
    private long id;
    private String titolo;
    private LocalDate dataEvento;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_location")
    private EventoLocation location; // Usa EventoLocation
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    private int numeroMassimoPartecipanti;
    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> listaPartecipazioni;

    public Evento(String titolo, LocalDate dataEvento, EventoLocation location, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.location = location;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Evento() {
    }

    // Overrides, Getters, Setters...
}
