package com.fanoos.services;

import com.fanoos.exceptions.BankExistException;
import com.fanoos.exceptions.BankNotFoundException;
import com.fanoos.models.dto.BankDto;
import com.fanoos.models.entities.BankEntity;
import com.fanoos.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public List<BankDto> getAllBanks() {
        List<BankDto> bankList = bankRepository.findAll().stream().map(BankDto::new).collect(Collectors.toList());
        return bankList;
    }

    public BankEntity getBankById(Long id) throws BankNotFoundException {
        Optional<BankEntity> bank =  bankRepository.findById(id);

        if (bank.isPresent()) {
            return bank.get();
        } else {
            throw new BankNotFoundException(id);
        }
    }

    public BankEntity createBank(BankEntity entity) throws BankExistException
    {
        entity = bankRepository.save(entity);
        return  entity;
    }
    public void deleteBankById(Long id) throws BankNotFoundException
    {
        Optional<BankEntity> bank = bankRepository.findById(id);
        if (bank.isPresent()) {
            bankRepository.deleteById(id);
        } else {
            throw  new BankNotFoundException(id);
        }
    }
    public boolean existBankByName(String name) {
        return bankRepository.existsBankEntityByName(name);
    }
}
