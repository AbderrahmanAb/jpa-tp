package ma.emsi.jpatp;

import ma.emsi.jpatp.entities.Patient;
import ma.emsi.jpatp.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaTpApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository PatientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaTpApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i=0;i<100;i++){
            PatientRepository.save(new Patient(null,"hassan",new Date(),Math.random()>0.5?true:false,(int)Math.random()));


        }
        Page<Patient> byMalade = PatientRepository.findByMalade(true, PageRequest.of(0,4));



        byMalade.forEach(p ->{
            System.out.println("************************");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());

        } );
        System.out.println("---------------------------------------------------");
         List<Patient> pmss = PatientRepository.findByMaladeAndAndScoreLessThan(false,40);
        pmss.forEach(p ->{
            System.out.println("************************");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());

        } );





        /*

        PatientRepository.save(new Patient(null,"hassafsfsn",new Date(),false,5));
        PatientRepository.save(new Patient(null,"hassfsfssan",new Date(),true,7));
        PatientRepository.save(new Patient(null,"sfs",new Date(),true,58));
        PatientRepository.save(new Patient(null,"hassan",new Date(),false,59));
           List<Patient> byMalade = PatientRepository.findByMalade(true);


        byMalade.forEach(p ->{
            System.out.println("************************");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());

        } );

        */




   /*     List<Patient> patients = PatientRepository.findAll();
       patients.forEach(p ->{
           System.out.println("************************");
           System.out.println(p.getId());
           System.out.println(p.getNom());
           System.out.println(p.getScore());
           System.out.println(p.getDateNaissance());
           System.out.println(p.isMalade());

       } );
        System.out.println("**********************");
        Patient p=PatientRepository.findById(1L).orElse(null);
        if (p!=null){
            System.out.println(p.getNom());
            System.out.println(p.isMalade());

        }
        p.setScore(870);
        PatientRepository.save(p);
        PatientRepository.deleteById(1L);*/


    }
}
