package at.cloudcomputing.backend.controller;

import at.cloudcomputing.backend.models.History;
import at.cloudcomputing.backend.repositories.HistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(value= "/history")
public class HistoryController {


    private final HistoryRepository historyRepository;


    @GetMapping
    public List<History> getHistory(){
        return historyRepository.findAll();
    }

    @GetMapping(value = "/id")
    public Optional<History> getHistoryById(@RequestParam(required = true, name = "id")Integer id){
        return historyRepository.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addHistory(@RequestBody History history){
        historyRepository.save(history);
    }


    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateHistory(@RequestParam(required = true, name = "id")Integer id, @RequestBody History history){
        Optional<History> HistoryOptional = historyRepository.findById(id);
        if(!HistoryOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        history.setIdhistory(id);
        historyRepository.save(history);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/delete")
    public void deleteHistorybyId (@RequestParam(required = true, name = "id")Integer id){
        historyRepository.deleteById(id);
    }
}
