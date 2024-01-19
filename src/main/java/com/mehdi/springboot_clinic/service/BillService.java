package com.mehdi.springboot_clinic.service;

import com.mehdi.springboot_clinic.dto.entityDTO.BillDTO;
import com.mehdi.springboot_clinic.entity.Bill;
import com.mehdi.springboot_clinic.entity.Client;
import com.mehdi.springboot_clinic.entity.Transaction;
import com.mehdi.springboot_clinic.repository.BillRepository;
import com.mehdi.springboot_clinic.repository.ClientRepository;
import com.mehdi.springboot_clinic.repository.TransactionRepository;
import com.mehdi.springboot_clinic.repository.UserRepository;
import com.mehdi.springboot_clinic.service.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Service
public class BillService {

    private final BillRepository billRepository;
    private final ModelMapper modelMapper;
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public BillService(BillRepository billRepository, ModelMapper modelMapper,
                       ClientRepository clientRepository,
                       UserRepository userRepository,
                       TransactionRepository transactionRepository) {
        this.billRepository = billRepository;
        this.modelMapper = modelMapper;

        modelMapper.addMappings(new PropertyMap<Bill, BillDTO>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
            }
        });
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public BillDTO generate(long clientId, Principal principal) {
        Bill bill = new Bill();
        Client client = clientRepository.findClientById(clientId).orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientId));
        //bill.setUser(userRepository.findByEmail(principal.getName()));
        bill.setClient(client);
        List<Transaction> transactions = transactionRepository.findAllByClientAndPaid(client, false);
        double total = 0;
        for (Transaction t : transactions) {
            total += t.getTotal();
            t.setPaid(true);
        }
        bill.setAmount(total);

        Bill savedBill = billRepository.save(bill);
        for (Transaction t : transactions) {
            t.setBill(bill);
            transactionRepository.save(t);
        }

        return modelMapper.map(savedBill, BillDTO.class);
    }
}

