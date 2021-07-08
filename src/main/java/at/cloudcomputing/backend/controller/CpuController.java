package at.cloudcomputing.backend.controller;

import at.cloudcomputing.backend.models.Cpu;
import at.cloudcomputing.backend.repositories.CpuRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/Cpu")
public class CpuController {

    private final CpuRepository cpuRepository;


    @GetMapping
    public List<Cpu> getCpu(){
        return cpuRepository.findAll();
    }

    @GetMapping(value = "/id")
    public Optional<Cpu> getCpuById(@RequestParam(required = true, name = "id")Integer id){
        return cpuRepository.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addCpu(@RequestBody Cpu Cpu){
        cpuRepository.save(Cpu);
    }


    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateCpu(@RequestParam(required = true, name = "id")Integer id, @RequestBody Cpu Cpu){
        Optional<Cpu> CpuOptional = cpuRepository.findById(id);
        if(!CpuOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Cpu.setIdcpu(id);
        cpuRepository.save(Cpu);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/delete")
    public void deleteCpubyId (@RequestParam(required = true, name = "id")Integer id){
        cpuRepository.deleteById(id);
    }
}

