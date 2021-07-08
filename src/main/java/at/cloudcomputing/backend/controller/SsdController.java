package at.cloudcomputing.backend.controller;

import at.cloudcomputing.backend.models.Ssd;
import at.cloudcomputing.backend.repositories.SsdRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/ssd")
public class SsdController {
    private final SsdRepository ssdRepository;

    @GetMapping
    public List<Ssd> getSsd(){
        return ssdRepository.findAll();
    }

    @GetMapping(value = "/id")
    public Optional<Ssd> getSddById(@RequestParam(required = true, name = "id")Integer id){
        return ssdRepository.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addHdd(@RequestBody Ssd ssd){
        ssdRepository.save(ssd);
    }


    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateHdd(@RequestParam(required = true, name = "id")Integer id, @RequestBody Ssd ssd){
        Optional<Ssd> hddOptional = ssdRepository.findById(id);
        if(!hddOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        ssd.setIdssd(id);
        ssdRepository.save(ssd);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/delete")
    public void deleteHddbyId (@RequestParam(required = true, name = "id")Integer id){
        ssdRepository.deleteById(id);
    }
}
