package at.cloudcomputing.backend.controller;

import at.cloudcomputing.backend.models.Address;
import at.cloudcomputing.backend.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "api/v1/users/address")
public class AddressController {

    private final AddressRepository addressRepository;


    @GetMapping
    public List<Address> getAddress(){
        return addressRepository.findAll();
    }

    @GetMapping(value = "/id")
    public Optional<Address> getAddressById(@RequestParam(required = true, name = "id")Integer id){
        return addressRepository.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addAddress(@RequestBody Address Address){
        addressRepository.save(Address);
    }


    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateAddress(@RequestParam(required = true, name = "id")Integer id, @RequestBody Address Address){
        Optional<Address> AddressOptional = addressRepository.findById(id);
        if(!AddressOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Address.setId(id);
        addressRepository.save(Address);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/delete")
    public void deleteAddressbyId (@RequestParam(required = true, name = "id")Integer id){
        addressRepository.deleteById(id);
    }
}

