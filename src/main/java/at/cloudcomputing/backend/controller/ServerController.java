package at.cloudcomputing.backend.controller;

import at.cloudcomputing.backend.models.Server;
import at.cloudcomputing.backend.repositories.ServerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/server")
public class ServerController {

    private final ServerRepository serverRepository;


    @GetMapping
    public List<Server> getServer(){
        return serverRepository.findAll();
    }

    @GetMapping(value = "/id")
    public Optional<Server> getServerById(@RequestParam(required = true, name = "id")Integer id){
        return serverRepository.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addServer(@RequestBody Server server){
        serverRepository.save(server);
    }


    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateServer(@RequestParam(required = true, name = "id")Integer id, @RequestBody Server server){
        Optional<Server> serverOptional = serverRepository.findById(id);
        if(!serverOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        server.setIdserver(id);
        serverRepository.save(server);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/delete")
    public void deleteServerbyId (@RequestParam(required = true, name = "id")Integer id){
        serverRepository.deleteById(id);
    }
}

