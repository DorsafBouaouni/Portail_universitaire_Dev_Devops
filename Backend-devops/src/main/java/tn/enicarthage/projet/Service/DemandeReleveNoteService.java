package tn.enicarthage.projet.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.enicarthage.projet.Entity.DemandeReleveNote;
import tn.enicarthage.projet.Repository.DemandeReleveNoteRepository;

@Service
@RequiredArgsConstructor
public class DemandeReleveNoteService {

    @Autowired
    private DemandeReleveNoteRepository demandeReleveNoteRepository;


    private final EmailService emailService;
    //private  final MailSender mailSender;




    public DemandeReleveNote creerDemandeReleveNote(DemandeReleveNote demandeReleveNote) {
        // Enregistrer la demande de relevé de notes dans la base de données
        DemandeReleveNote savedDemande = demandeReleveNoteRepository.save(demandeReleveNote);


        // Envoyer un mail à l'administration avec les détails de la demande
        String destinataire = "dorsaf.bouoni12@gmail.com";
        String sujet = "Nouvelle demande de relevé de notes";
        String contenu = "Une nouvelle demande de relevé de notes a été soumise avec les détails suivants : \n" +
                "Raison : " + demandeReleveNote.getRaison() + "\n" +
                "Année académique : " + demandeReleveNote.getAnneeAcademique() + "\n" +
                "Étudiant : " + demandeReleveNote.getEtudiant().getNom() + " " + demandeReleveNote.getEtudiant().getPrenom();

        //sendEmail(destinataire, sujet, contenu);
        emailService.sendEmail("dorsaf.bouoni12@gmail.com",sujet,contenu);
        return savedDemande;
    }

    /*public void sendEmail(String to,String subject,String text)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("oussama.touati.178@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }*/

    public DemandeReleveNote createDemande(DemandeReleveNote demandeReleveNote) {
        return demandeReleveNoteRepository.save(demandeReleveNote);
    }


}


   /* public DemandeReleveNote creerDemandeReleveNote(DemandeReleveNote demandeReleveNote) {
        // Enregistrer la demande de relevé de notes dans la base de données
        DemandeReleveNote savedDemande = demandeReleveNoteRepository.save(demandeReleveNote);

        // Envoyer un mail à l'administration avec les détails de la demande
        String destinataire = "administration@example.com";
        String sujet = "Nouvelle demande de relevé de notes";
        String contenu = "Une nouvelle demande de relevé de notes a été soumise avec les détails suivants : \n" +
                "Raison : " + demandeReleveNote.getRaison() + "\n" +
                "Année académique : " + demandeReleveNote.getAnneeAcademique() + "\n" +
                "Étudiant : " + demandeReleveNote.getEtudiant().getNom() + " " + demandeReleveNote.getEtudiant().getPrenom();

        sendEmail(destinataire, sujet, contenu);

        return savedDemande;
    }


    public DemandeReleveNoteService(DemandeReleveNoteRepository demandeReleveNoteRepository) {
        this.demandeReleveNoteRepository = demandeReleveNoteRepository;
    }

    public DemandeReleveNote createDemande(DemandeReleveNote demandeReleveNote) {
        return demandeReleveNoteRepository.save(demandeReleveNote);
    }



    private void sendEmail(String destinataire, String sujet, String contenu) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(destinataire);
        message.setSubject(sujet);
        message.setText(contenu);
        javaMailSender.send(message);

}*/

