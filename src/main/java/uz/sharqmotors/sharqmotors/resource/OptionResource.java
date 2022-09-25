package uz.sharqmotors.sharqmotors.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.sharqmotors.sharqmotors.models.Option;
import uz.sharqmotors.sharqmotors.service.OptionService;

import java.util.List;

@Log4j2
@RequestMapping("/sharq/")
@RestController
@RequiredArgsConstructor
public class OptionResource {

    final OptionService optionService;

    @GetMapping("optionget")
    private ResponseEntity<List<Option>> getall() {
        return ResponseEntity.ok().body(optionService.getall());
    }

    @PostMapping("optionadd")
    private ResponseEntity<Option> add(@RequestBody Option option) {
        return ResponseEntity.ok().body(optionService.add(option));
    }

    @PostMapping("removeoption")
    private ResponseEntity<Option> remove(@RequestParam("id") String id) {
        return ResponseEntity.ok().body(optionService.remove(id));
    }

}
