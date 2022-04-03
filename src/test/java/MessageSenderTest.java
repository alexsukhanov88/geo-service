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

import static org.mockito.Mockito.when;

public class MessageSenderTest {


    @Test
    public void send_success_ru() {

        String expected = "Добро пожаловать";
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Country.RUSSIA)).thenReturn(expected);

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        when(geoService.byIp("172.123.12.19")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        Assertions.assertEquals(expected, messageSender.send(headers));

    }

    @Test
    public void send_success_eng() {

        String expected = "Welcome";
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Country.USA)).thenReturn(expected);

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        when(geoService.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        Assertions.assertEquals(expected, messageSender.send(headers));

    }
}
