package test_bazadanych.test_db.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import test_bazadanych.test_db.models.Client;
import test_bazadanych.test_db.repository.ClientRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServic {
    @Autowired
    private ClientRepo clientRepo;

    public List<Client> getallClient(){

        return clientRepo.findAll();
    }
    public Optional<Client> getClient(Integer Id){
        return clientRepo.findById(Id);
    }
    public Client addclient(Client client) {
        return clientRepo.save(client);
    }
    public Client updateclient(Integer Id,Client client) {
        Client updatedclient = clientRepo.findById(Id).get();
        updatedclient.setEmail(client.getEmail());
        updatedclient.setImie(client.getImie());
        updatedclient.setNazwisko(client.getNazwisko());
        updatedclient.setPlec(client.getPlec());
        updatedclient.setKraj(client.getKraj());
        return clientRepo.save(updatedclient);
    }
    public void deleteclient(Integer Id){
        Client deleteclient = clientRepo.findById(Id).get();
        clientRepo.delete(deleteclient);
    }
    public List<String> getClientemail() {
        return clientRepo.findAll().
                stream().
                map(Client::getEmail).
                collect(Collectors.toList());
    }
}
