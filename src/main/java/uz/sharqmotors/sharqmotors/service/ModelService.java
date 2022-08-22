package uz.sharqmotors.sharqmotors.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import uz.sharqmotors.sharqmotors.models.*;
import uz.sharqmotors.sharqmotors.repository.ModelRepo;
import uz.sharqmotors.sharqmotors.repository.OptionRepo;
import uz.sharqmotors.sharqmotors.repository.RateRepo;
import uz.sharqmotors.sharqmotors.service.fileupload.FileService;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ModelService {

    @Autowired
    final ModelRepo modelRepo;
    final ProducerService producerService;
    final RateRepo rateRepo;
    final OptionRepo optionRepo;
    final FileService fileService;


    public Model add(Model model, String id) {


        Producer producer = producerService.getbyid(Long.parseLong(id));
        model.setProducername(producer.getName());
        producer.addModel(model);
        producerService.add(producer);
        Rate rate = rateRepo.getMaxDate();
        if (rate != null && model.getPrice() != null) {
            double res = model.getPrice() * rate.getCourse();
            model.setPriceuzs(res);
        }
        return modelRepo.save(model);
    }

    public Model create(Model model) {
        Rate rate = rateRepo.getMaxDate();
        if (rate != null && model.getPrice() != null) {
            double res = model.getPrice() * rate.getCourse();
            model.setPriceuzs(res);
        }
        return modelRepo.save(model);
    }


    public Model remove(String id) throws IOException {

        Model model = modelRepo.getById(Long.parseLong(id));
        model.setActive(ACTIVE.NOACTIVE);
        Resource fileResource = fileService.getFile(model.getImagepath(), "models");
        File file = fileResource.getFile();
        file.delete();
        model.getOptionSet().clear();

        return modelRepo.save(model);
    }

    public List<Model> getall() {
        return modelRepo.getAllModels(ACTIVE.ACTIVE);
    }

    public Model getbyid(Long id) {
        return modelRepo.getById(id);
    }

    public Model modeloption(Option option, String id) {
        Optional<Model> model = modelRepo.findById(Long.parseLong(id));
        Model model1;

        model1 = model.get();
        Option option1 =  optionRepo.save(option);

        model1.addOption(option1);
        return modelRepo.save(model1);
    }

}
