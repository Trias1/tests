package com.example.crud.repository;


import com.example.crud.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
    Optional<Mahasiswa> findByNama(String nama);
}
