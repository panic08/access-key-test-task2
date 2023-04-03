package com.example.accesskeybackend.utils.IPv6Validator.service;

import org.springframework.stereotype.Service;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;


@Service
public class IPv6Service {
    public boolean validate(String URL) {
        String domain = URL.toLowerCase().replaceAll("^https?://", "");
        try {

            InetAddress[] inetAddresses = InetAddress.getAllByName(domain);
            for (InetAddress address : inetAddresses) {
                if (address instanceof Inet6Address)
                    return true;
            }

        } catch (UnknownHostException e) {
            return false;
        }
        return false;
    }
}
