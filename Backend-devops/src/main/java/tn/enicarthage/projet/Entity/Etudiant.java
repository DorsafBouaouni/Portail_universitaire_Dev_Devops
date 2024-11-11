package tn.enicarthage.projet.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@Entity
@Builder
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "T_Etudiant")

public class Etudiant implements Serializable{


    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column( name = "Email")
    String Email;
    @Column(name = "CIN")
     int CIN;

    @Column( name = "Password")
    String Password;

    @Column( name = "Nom")
    String Nom;

    @Column( name = "Prenom")
    String Prenom;

    @Enumerated(EnumType.STRING)
    @Column( name = "specialité")
    level level;
    @Column ( name="NumTel")
    String NumTel;
    @Column(name="adresse")
    String adresse;







    @OneToMany(mappedBy = "etudiant")
    private List<DemandeReleveNote> demandesReleveNote = new ArrayList<>();

    @OneToMany(mappedBy = "etudiant")
    private List<DemandeCertificatPresence> demandesCertificatsPresence = new ArrayList<>();

    public void setCin(int cin) {
        this.CIN=cin;
    }

    public int getCin() {
        return this.CIN;
    }
}