package com.example.demo.form;

import com.example.demo.domain.Client;
import org.springframework.beans.BeanUtils;

public class ClientForm implements BaseForm<Client> {
    @Override
    public Client covert() {
        Client client = new Client();
        BeanUtils.copyProperties(this, client);
        return client;
    }
}

