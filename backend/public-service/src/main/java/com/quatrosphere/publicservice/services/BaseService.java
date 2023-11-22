package com.quatrosphere.publicservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quatrosphere.publicservice.repositories.BaseRepository;

@Service
public abstract class BaseService<T> {
    
    private BaseRepository<T> baseRepository;

    public BaseService(BaseRepository<T> repository) {
        this.baseRepository = repository;
    }

    public List<T> findAll() {
        return baseRepository.findAll();
    } 

    public T findById(long id) {
        Optional<T> opt = baseRepository.findById(id);
        return opt.orElse(null);
    }

    public T save(T template) {
        return baseRepository.save(template);
    }

    public void deleteById(long id) {
        baseRepository.deleteById(id);
    }

    public Page<T> findAllWithPage(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }
}
