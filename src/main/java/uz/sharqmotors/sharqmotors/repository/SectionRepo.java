package uz.sharqmotors.sharqmotors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.sharqmotors.sharqmotors.models.Section;

@Repository
public interface SectionRepo extends JpaRepository<Section, Long> {

}
