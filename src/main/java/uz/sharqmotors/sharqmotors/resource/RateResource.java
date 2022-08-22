package uz.sharqmotors.sharqmotors.resource;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.sharqmotors.sharqmotors.models.Rate;
import uz.sharqmotors.sharqmotors.service.RateService;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class RateResource {

    final RateService rateService;

    @GetMapping("getrate")
    private ResponseEntity<List<Rate>> getall() {
        return ResponseEntity.ok().body(rateService.getAll());
    }


    @PostMapping("addrate")
    private ResponseEntity<Rate> add(@RequestBody Rate rate) {
        return ResponseEntity.ok().body(rateService.add(rate));
    }

    @DeleteMapping("removerate")
    private void remove(@RequestBody Rate rate){
        rateService.remove(rate);
    }
}
