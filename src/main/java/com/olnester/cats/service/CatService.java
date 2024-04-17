package com.olnester.cats.service;

import com.olnester.cats.dto.CatDto;
import com.olnester.cats.entity.CatEntity;
import com.olnester.cats.exception.CatNotFoundException;
import com.olnester.cats.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CatService {
    private final CatRepository repository;

    public CatService(CatRepository repository) {
        this.repository = repository;
    }

    public CatEntity saveCat(CatDto cat) {
        CatEntity catEntity = new CatEntity();
        catEntity.setName(cat.getName());
        catEntity.setBirthDay(cat.getBirthDay());
        catEntity.setCreatedAt(LocalDateTime.now());
        return repository.save(catEntity);
    }

    public List<CatEntity> getAllCats() {
        return repository.findAll();
    }

    public CatEntity getCatById(Long id) {
        Optional<CatEntity> cat = repository.findById(id);
        if (cat.isEmpty()) {
            throw new CatNotFoundException("Cat not found");
        }
        return cat.get();
    }
}
