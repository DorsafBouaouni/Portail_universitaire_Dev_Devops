package tn.enicarthage.projet.service;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestMiseAJourProfilEtudiant {

    @Test
    public void verifierMiseAJourProfilEtudiant() {
        // Configurer WebDriver pour utiliser Edge
        System.setProperty("webdriver.edge.driver", "C://EdgeDriver//edgedriver_win64//msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
/*
        try {
            System.out.println("Ouverture de l'application...");
            driver.get("http://localhost:4200"); // Remplacez par l'URL de votre application

            // Attendre que le champ d'email soit visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            System.out.println("Attente du champ d'email...");
            WebElement champEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            System.out.println("Champ d'email trouvé.");

            // Saisir l'email
            champEmail.sendKeys("nouvel.email@example.com");
            System.out.println("Email saisi : nouvel.email@example.com");

            // Cliquer sur le bouton "Modifier"
            WebElement boutonModifier = driver.findElement(By.xpath("//button[contains(text(),'Modifier')]"));
            boutonModifier.click();
            System.out.println("Clique sur le bouton 'Modifier'.");

            // Vérifiez la présence d'un message de succès
            System.out.println("Vérification du message de confirmation...");
            WebElement messageConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message-confirmation")));
            String messageText = messageConfirmation.getText();
            System.out.println("Message de confirmation reçu : " + messageText);

            // Vérifiez que le message contient "Mise à jour réussie"
            assert messageText.contains("Mise à jour réussie") : "Le message de confirmation n'a pas été affiché!";
            System.out.println("Test réussi : Mise à jour confirmée.");

        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit(); // Ferme le navigateur
            System.out.println("Navigateur fermé.");
        }*/


        try {
            System.out.println("Ouverture de l'application...");
            driver.get("http://localhost:4200"); // Remplacez par l'URL de votre application

            // Attendre que le champ d'email soit visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            System.out.println("Attente du champ d'email...");
            WebElement champEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            System.out.println("Champ d'email trouvé.");

            // Saisir l'email
            champEmail.sendKeys("nouvel.email@example.com");
            System.out.println("Email saisi : nouvel.email@example.com");

            // Saisir le CIN
            WebElement champCIN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cin")));
            champCIN.sendKeys("12345678");
            System.out.println("CIN saisi : 12345678");

            // Saisir l'adresse
            WebElement champAdresse = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("adresse")));
            champAdresse.sendKeys("123 Rue Exemple, Ville");
            System.out.println("Adresse saisie : 123 Rue Exemple, Ville");

            // Cliquer sur le bouton "Modifier"
            WebElement boutonModifier = driver.findElement(By.xpath("//button[contains(text(),'Modifier')]"));
            boutonModifier.click();
            System.out.println("Clique sur le bouton 'Modifier'.");

            // Vérifiez la présence d'un message de succès
            System.out.println("Vérification du message de confirmation...");
            WebElement messageConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message-confirmation")));
            String messageText = messageConfirmation.getText();
            System.out.println("Message de confirmation reçu : " + messageText);

            // Vérifiez que le message contient "Mise à jour réussie"
            assert messageText.contains("Mise à jour réussie") : "Le message de confirmation n'a pas été affiché!";
            System.out.println("Test réussi : Mise à jour confirmée.");

        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit(); // Ferme le navigateur
            System.out.println("Navigateur fermé.");

        }
    }}
    
