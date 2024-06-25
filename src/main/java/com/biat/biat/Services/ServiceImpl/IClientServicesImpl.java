package com.biat.biat.Services.ServiceImpl;

import com.biat.biat.Entites.Client;
import com.biat.biat.Repository.IClientRepository;
import com.biat.biat.Services.IServices.IClientServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class IClientServicesImpl  implements IClientServices {
    private final IClientRepository clientRepository;


}
