package at.cloudcomputing.backend.controller;

import at.cloudcomputing.backend.models.Hdd;
import at.cloudcomputing.backend.models.Ram;
import at.cloudcomputing.backend.repositories.HddRepository;
import at.cloudcomputing.backend.repositories.RamRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/hdd")
public class HddController {

    private final HddRepository hddRepository;

    @GetMapping
    public List<Hdd> getHdd(){
        return hddRepository.findAll();
    }

    @GetMapping(value = "/id")
    public Optional<Hdd> getHddById(@RequestParam(required = true, name = "id")Integer id){
        return hddRepository.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addHdd(@RequestBody Hdd hdd){
        hddRepository.save(hdd);
    }


    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateHdd(@RequestParam(required = true, name = "id")Integer id, @RequestBody Hdd hdd){
        Optional<Hdd> hddOptional = hddRepository.findById(id);
        if(!hddOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        hdd.setIdhdd(id);
        hddRepository.save(hdd);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/delete")
    public void deleteHddbyId (@RequestParam(required = true, name = "id")Integer id){
        hddRepository.deleteById(id);
    }
}
