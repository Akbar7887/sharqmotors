package uz.sharqmotors.sharqmotors.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sharqmotors.sharqmotors.models.ACTIVE;
import uz.sharqmotors.sharqmotors.models.News;
import uz.sharqmotors.sharqmotors.repository.NewsRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NewsService {

    @Autowired
    final NewsRepo newsRepo;


    public List<News> getAll() {
        return newsRepo.findAll();
    }

    public News add(News news) {
        return newsRepo.save(news);
    }

    public News getbyid(Long id) {
        return newsRepo.getById(id);
    }

    public News remove(String id) {
        News news = newsRepo.getById(Long.parseLong(id));
        news.setActive(ACTIVE.NOACTIVE);
        return newsRepo.save(news);
    }
}
