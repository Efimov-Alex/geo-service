package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {
    @Test
    void test_russian_ip() {
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        GeoService geoServiceImpl = Mockito.spy(GeoServiceImpl.class);

        MessageSender messageSender = new MessageSenderImpl(geoServiceImpl, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        String send = messageSender.send(headers);

        Assertions.assertEquals("Добро пожаловать", send);
    }

    @Test
    void test_american_ip() {
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        GeoService geoServiceImpl = Mockito.spy(GeoServiceImpl.class);

        MessageSender messageSender = new MessageSenderImpl(geoServiceImpl, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.45.200.150");
        String send = messageSender.send(headers);

        Assertions.assertEquals("Welcome", send);
    }


}
