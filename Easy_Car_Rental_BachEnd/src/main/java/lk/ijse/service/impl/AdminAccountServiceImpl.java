package lk.ijse.service.impl;

import lk.ijse.dto.AdminAccountDTO;
import lk.ijse.entity.AdminAccount;
import lk.ijse.entity.Booking;
import lk.ijse.exception.ValidateException;
import lk.ijse.repo.AdminAccountRepo;
import lk.ijse.repo.BookingRepo;
import lk.ijse.service.AdminAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminAccountServiceImpl implements AdminAccountService {

    @Autowired
    private AdminAccountRepo adminAccountRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void addAdmin(AdminAccountDTO dto) {
        if (adminAccountRepo.existsById(dto.getUsername())){
            throw new ValidateException("Admin Already Exist");
        }
        adminAccountRepo.save(mapper.map(dto, AdminAccount.class));

    }

    @Override
    public void updateAdmin(AdminAccountDTO dto) {
        if (adminAccountRepo.existsById(dto.getUsername())) {
            adminAccountRepo.save(mapper.map(dto, AdminAccount.class));

        }
    }


}
