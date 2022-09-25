package uz.sharqmotors.sharqmotors.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.sharqmotors.sharqmotors.models.OptionConstant;
import uz.sharqmotors.sharqmotors.service.OptionConstantService;

import java.util.List;

@RestController
@RequestMapping("/sharq/")
@RequiredArgsConstructor
public class OptionControlResource {

    final OptionConstantService optionConstantService;

    @PostMapping("optionConstantadd")
    private ResponseEntity<OptionConstant> add(@RequestBody OptionConstant optionConstant){
        return ResponseEntity.ok().body(optionConstantService.add(optionConstant));
    }

    @GetMapping("optionConstantget")
    private ResponseEntity<List<OptionConstant>> getall(){
        return ResponseEntity.ok().body(optionConstantService.getall());
    }

    @PostMapping("removeoptionconstant")
    private ResponseEntity<OptionConstant> remove(@RequestParam("id") String id){
        return ResponseEntity.ok().body(optionConstantService.remove(id));
    }
}
