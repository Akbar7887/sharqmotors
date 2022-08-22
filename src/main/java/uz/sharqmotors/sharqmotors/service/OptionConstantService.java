package uz.sharqmotors.sharqmotors.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sharqmotors.sharqmotors.models.ACTIVE;
import uz.sharqmotors.sharqmotors.models.OptionConstant;
import uz.sharqmotors.sharqmotors.repository.OptionConstantRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class OptionConstantService {

    @Autowired
    final OptionConstantRepo optionConstantRepo;

    public List<OptionConstant> getall(){
        return optionConstantRepo.getAllActive(ACTIVE.ACTIVE);
    }

    public OptionConstant add(OptionConstant optionConstant){
        return optionConstantRepo.save(optionConstant);
    }

    public OptionConstant remove(String id){
        OptionConstant optionConstant  = optionConstantRepo.getById(Long.parseLong(id));
        optionConstant.setActive(ACTIVE.NOACTIVE);
        return optionConstantRepo.save(optionConstant);
    }
}
