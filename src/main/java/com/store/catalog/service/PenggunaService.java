package com.store.catalog.service;

import com.store.catalog.entity.Pengguna;
import com.store.catalog.exeption.BadRequestException;
import com.store.catalog.exeption.ResourceNotFoundException;
import com.store.catalog.repository.PenggunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class PenggunaService {
    @Autowired
    private PenggunaRepository penggunaRepository;
    public Pengguna findById(String id){
        return penggunaRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Pengguna with id "+id+ " not found"));
    }
    public List<Pengguna> findAll(){

        return penggunaRepository.findAll();
    }
    public Pengguna create(Pengguna pengguna){
        pengguna.setId(UUID.randomUUID().toString());
        if(!StringUtils.hasText(pengguna.getId())){
            throw new BadRequestException("Username harus diisi");
        }
        if(penggunaRepository.existsById(pengguna.getId())){
            throw new BadRequestException("Username "+ pengguna.getId()+ "sudah terdaftar");
        }
        if(!StringUtils.hasText(pengguna.getEmail())){
            throw new BadRequestException("Email harus diisi");
        }
        if(penggunaRepository.existsByEmail(pengguna.getEmail())){
            throw new BadRequestException("Email "+ pengguna.getEmail()+ "sudah terdaftar");
        }
        return penggunaRepository.save(pengguna);
    }
    public Pengguna update(Pengguna pengguna){
        if (!StringUtils.hasText(pengguna.getId())) {
            throw new BadRequestException("Username harus diisi");
        }

        if (!StringUtils.hasText(pengguna.getEmail())) {
            throw new BadRequestException("Email harus diisi");
        }
        return penggunaRepository.save(pengguna);
    }
    public void deletedById(String id){
        penggunaRepository.deleteById(id);
    }

}
