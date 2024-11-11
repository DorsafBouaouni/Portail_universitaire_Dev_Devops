package tn.enicarthage.projet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tn.enicarthage.projet.Repository.CourRepository;

import tn.enicarthage.projet.Entity.Cour;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CourStorageService {

    @Autowired
    private CourRepository fileDBRepository;

    public Cour store(MultipartFile file, String descrip, String createur, String name) throws IOException {

        Cour FileDB = new Cour(name, file.getContentType(), file.getBytes(),descrip,createur);
        FileDB.setUpDate(new Date());
        return fileDBRepository.save(FileDB);
    }

    public Cour getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<Cour> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }

    public void updateCours(String id, String descrip, String createur,String name) {
        Optional<Cour> optionalFileDB = fileDBRepository.findById(id);
        if (optionalFileDB.isPresent()) {
            Cour fileDB = optionalFileDB.get();
            fileDB.setDescrip(descrip);
            fileDB.setCreateur(createur);
            fileDB.setName(name);
            fileDBRepository.save(fileDB);
        }
    }
    public void deleteCours(String id) {
        fileDBRepository.deleteById(id);
    }

    public Optional<Cour> getFilee(String id) {
        return fileDBRepository.findById(id);
    }

}
