package test_bazadanych.test_db.Controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import test_bazadanych.test_db.Email.EmailSenderService;
import test_bazadanych.test_db.Service.ClientServic;
import test_bazadanych.test_db.Service.EmailServic;
import test_bazadanych.test_db.models.Client;
import test_bazadanych.test_db.models.Email;
import test_bazadanych.test_db.models.Messgebox;
import test_bazadanych.test_db.repository.ClientRepo;
import test_bazadanych.test_db.repository.EmailRepo;
import test_bazadanych.test_db.repository.MessageboxRepo;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ApiController {
    @Autowired
    private ClientServic clientServic;
    @Autowired
    private EmailServic emailServic;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private EmailRepo emailRepo;
    @Autowired
    private MessageboxRepo messageboxRepo;
    @Autowired
    private EmailSenderService senderService;
    @GetMapping(value = "/")
    public String getpage(){
        return "hello world";
    }
    @GetMapping(value = "/allclients")
    public List<Client> getallClient(){
        return clientServic.getallClient();
    }

    @GetMapping(value = "/findclient/{Id}")
    public Optional<Client> getClient(@PathVariable Integer Id){
        return clientServic.getClient(Id);
    }

    @GetMapping(value = "/allclientsemail")
    public List<String> getClientemail(){
        return clientServic.getClientemail();
    }

    @PostMapping(value = "/addclient")
    public Client addclient(@RequestBody Client client){
        return clientServic.addclient(client);
    }

    @PutMapping(value = "update/{Id}")
    public Client updateclient(@PathVariable Integer Id, @RequestBody Client client){
        return clientServic.updateclient(Id,client);
    }

    @DeleteMapping(value = "delete/{Id}")
    public String deleteclient(@PathVariable Integer Id){
        try{
            clientServic.deleteclient(Id);
            return "Client o id "+Id+" zostal usuniety";
        }
        catch (Exception f){
            return "Brak takiego kilenta w bazie";
        }
    }

    @PostMapping(value = "sendemail")
    public String sendMail(@RequestBody String emailtext){
        Email newemail = new Email("test-aplikacji",emailtext);
        emailRepo.save(newemail);
        senderService.sendEmail("tomek4442@o2.pl","test-aplikacji",emailtext);
        Messgebox newmessage = new Messgebox("tomek4442@o2.pl",newemail);
        messageboxRepo.save(newmessage);
        return "email wyslany";
    }
    @PostMapping(value = "sendemailto/{Id}")
    public String sendMailto(@PathVariable Integer Id, @RequestBody String emailtext){
        Email newemail = new Email("test-aplikacji",emailtext);
        emailRepo.save(newemail);
        Client clientemial = clientRepo.findById(Id).get();
        String emailclient = clientemial.getEmail();
        senderService.sendEmail(emailclient,"test-aplikacji",emailtext);
        Messgebox newmessage = new Messgebox(emailclient,newemail);
        messageboxRepo.save(newmessage);
        return "email wyslany";
    }
    @PostMapping(value = "sendemailtoall")
    public List<String> sendMailtoall(@RequestBody String emailtext){
        Email newemail = new Email("test-aplikacji",emailtext);
        emailRepo.save(newemail);
        List<String> emailclients = clientRepo.findAll().
                stream().
                map(Client::getEmail).
                collect(Collectors.toList());
        for(String clientemail:emailclients){
            try{
            senderService.sendEmail(clientemail,"test-aplikacji",emailtext);
                Messgebox newmessage = new Messgebox(clientemail,newemail);
                messageboxRepo.save(newmessage);}
            catch (Exception e){
                System.out.println("problem wyslania emaila na adres :"+clientemail);
            }
        }
        return emailclients;
    }
    @GetMapping(value = "/allemails")
    public List<Email> getemails(){
        return emailServic.getallemails();
    }
}
