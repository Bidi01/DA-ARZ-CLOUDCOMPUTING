package at.cloudcomputing.backend.controller;

import at.cloudcomputing.backend.models.Cpu;
import at.cloudcomputing.backend.models.Ram;
import at.cloudcomputing.backend.repositories.RamRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping(value = "/ram")
public class RamController {


    private final RamRepository ramRepository;

    @GetMapping
    public List<Ram> getRam(){
        return ramRepository.findAll();
    }

    @GetMapping(value = "/id")
    public Optional<Ram> getRamById(@RequestParam(required = true, name = "id")Integer id){
        return ramRepository.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addRam(@RequestBody Ram ram){
        ramRepository.save(ram);
    }


    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateRam(@RequestParam(required = true, name = "id")Integer id, @RequestBody Ram ram){
        Optional<Ram> RamOptional = ramRepository.findById(id);
        if(!RamOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        ram.setIdram(id);
        ramRepository.save(ram);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/delete")
    public void deleteRambyId (@RequestParam(required = true, name = "id")Integer id){
        ramRepository.deleteById(id);
    }
}
