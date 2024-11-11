package tn.enicarthage.projet.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeCertificatPresence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Raison;

    private String AnneeAcadémique;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;


    public String getAnneeAcademique() {
        return this.AnneeAcadémique;
    }

    public void setAnneeAcademique(String s) {
        this.AnneeAcadémique=s;
    }
}
