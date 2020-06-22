package com.fanoos.repositories;

import com.fanoos.models.entities.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankEntity, Long> {
    boolean existsBankEntityByName(String name);
}
