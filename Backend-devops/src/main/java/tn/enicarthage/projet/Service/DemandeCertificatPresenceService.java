package tn.enicarthage.projet.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import tn.enicarthage.projet.Entity.DemandeCertificatPresence;
import tn.enicarthage.projet.Entity.DemandeReleveNote;
import tn.enicarthage.projet.Repository.DemandeCertificatPresenceRepository;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service

public class DemandeCertificatPresenceService {

    @Autowired
    private DemandeCertificatPresenceRepository demandeCertificatPresenceRepository;
    private final EmailService emailService;


        public DemandeCertificatPresence creerDemandeCertificatPresence(DemandeCertificatPresence DemandeCertificatPresence) {
            // Enregistrer la demande de relevé de notes dans la base de données
            DemandeCertificatPresence savedDemande = demandeCertificatPresenceRepository.save(DemandeCertificatPresence);


            // Envoyer un mail à l'administration avec les détails de la demande
            String destinataire = "dorsaf.bouoni12@gmail.com";
            String sujet = "Nouvelle demande de relevé de notes";
            String contenu = "Une nouvelle demande de relevé de notes a été soumise avec les détails suivants : \n" +
                    "Raison : " + DemandeCertificatPresence.getRaison() + "\n" +
                    "Année académique : " + DemandeCertificatPresence.getAnneeAcademique() + "\n" +
                    "Étudiant : " + DemandeCertificatPresence.getEtudiant().getNom() + " " + DemandeCertificatPresence.getEtudiant().getPrenom();

            //sendEmail(destinataire, sujet, contenu);
            emailService.sendEmail("dorsaf.bouoni12@gmail.com",sujet,contenu);
            return savedDemande;
        }


    public DemandeCertificatPresenceService(DemandeCertificatPresenceRepository demandeCertificatPresenceRepository, EmailService emailService) {
        this.demandeCertificatPresenceRepository = demandeCertificatPresenceRepository;

        this.emailService = emailService;
    }

    public DemandeCertificatPresence createDemande(DemandeCertificatPresence demandeCertificatPresence) {
        return demandeCertificatPresenceRepository.save(demandeCertificatPresence);
    }

   /* JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dorsaf.bouoni12@gmail");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
*/
}





   /* private DemandeCertificatPresenceRepository demandeCertificatPresenceRepository;



    public DemandeCertificatPresence creerDemandeCertificatPresence(DemandeCertificatPresence demandeCertificatPresence) {
        // Enregistrer la demande de certificat de présence dans la base de données
        DemandeCertificatPresence savedDemande = demandeCertificatPresenceRepository.save(demandeCertificatPresence);

        // Envoyer un mail à l'administration avec les détails de la demande
        String destinataire = "administration@example.com";
        String sujet = "Nouvelle demande de certificat de présence";
        String contenu = "Une nouvelle demande de certificat de présence a été soumise avec les détails suivants : \n" +
                "Raison : " + demandeCertificatPresence.getRaison() + "\n" +
                "Année académique : " + demandeCertificatPresence.getAnneeAcademique() + "\n" +
                "Étudiant : " + demandeCertificatPresence.getEtudiant().getNom() + " " + demandeCertificatPresence.getEtudiant().getPrenom();

        sendEmail(destinataire, sujet, contenu);

        return savedDemande;
    }


    public DemandeCertificatPresenceService(DemandeCertificatPresenceRepository demandeCertificatPresenceRepository) {
        this.demandeCertificatPresenceRepository = demandeCertificatPresenceRepository;
    }

    public DemandeCertificatPresence createDemande(DemandeCertificatPresence demandeCertificatPresence) {
        return demandeCertificatPresenceRepository.save(demandeCertificatPresence);
    }

    private void sendEmail(String destinataire, String sujet, String contenu) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(destinataire);
        message.setSubject(sujet);
        message.setText(contenu);
        CertificateRequest.T10CertificateRequestMessage javaMailSender;
        javaMailSender.send(message);
    }
}*/

