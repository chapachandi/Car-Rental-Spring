package lk.ijse.service;

import lk.ijse.dto.CustomerDTO;
import java.util.ArrayList;


public interface CustomerService {
    void addNewCustomer(CustomerDTO dto);

    void deleteCustomer(String id);

    CustomerDTO searchCustomer(String id);

    ArrayList<CustomerDTO> getAllCustomers();

    void updateCustomer(CustomerDTO dto);
}
