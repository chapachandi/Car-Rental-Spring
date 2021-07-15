package lk.ijse.service.impl;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.RegistrationDTO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Registration;
import lk.ijse.exception.ValidateException;
import lk.ijse.repo.CustomerRepo;
import lk.ijse.repo.RegistrationRepo;
import lk.ijse.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    @Autowired
    private ModelMapper mapper;




    @Override
    public void addNewCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCusId())) {
            throw new ValidateException("CusId Already Exist");
        }
        System.out.println(dto.toString());
        customerRepo.save(mapper.map(dto, Customer.class));
        System.out.println(mapper.map(dto, Customer.class).toString());

    }

    @Override
    public void deleteCustomer(String id) {
        if (!customerRepo.existsById(id)) {
            throw new ValidateException("No Customer for Delete..!");
        }
        customerRepo.deleteById(id);

    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), CustomerDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCusId())) {
            customerRepo.save(mapper.map(dto, Customer.class));

        }

    }
}
