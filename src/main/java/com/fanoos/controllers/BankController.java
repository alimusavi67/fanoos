package com.fanoos.controllers;

import com.fanoos.exceptions.BankNotFoundException;
import com.fanoos.exceptions.BankExistException;
import com.fanoos.models.dto.BankDto;
import com.fanoos.models.entities.BankEntity;
import com.fanoos.services.BankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/v1/banks")
public class BankController {
    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public List<BankDto> all() {
        List<BankDto> bankList = bankService.getAllBanks();
        return bankList;
    }

    @PostMapping
    public BankDto createBank(BankEntity bank) throws BankExistException
    {
        if (bankService.existBankByName(bank.getName())) {
            throw new BankExistException("bank with name" + bank.getName() + "is exist");
        } else {
            BankEntity updated = bankService.createBank(bank);
            BankDto bankDto = new BankDto(updated);
            return bankDto;
        }
    }

    @GetMapping("/{id}")
    public BankDto get(@PathVariable("id") Long id) throws BankNotFoundException{
        BankEntity bank = bankService.getBankById(id);
        BankDto bankDto = new BankDto(bank);
        return bankDto;
    }

    @DeleteMapping("/{id}")
    public void deleteBank(@PathVariable("id") Long id) throws BankNotFoundException {
       bankService.deleteBankById(id);
    }
}
