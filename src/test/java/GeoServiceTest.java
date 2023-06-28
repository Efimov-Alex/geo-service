
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest {
    @Test
    void test_moscow_ip_equals() {
        GeoService geoServiceImpl = Mockito.spy(GeoServiceImpl.class);

        Location location = geoServiceImpl.byIp("172.0.32.11");

        Assertions.assertEquals("Moscow", location.getCity());
        Assertions.assertEquals(Country.RUSSIA, location.getCountry());
        Assertions.assertEquals("Lenina", location.getStreet());
        Assertions.assertEquals(15, location.getBuiling());
    }

    @Test
    void test_localhost_ip_equals() {
        GeoService geoServiceImpl = Mockito.spy(GeoServiceImpl.class);

        Location location = geoServiceImpl.byIp("127.0.0.1");

        Assertions.assertNull(location.getCity());
        Assertions.assertNull(location.getCountry());
        Assertions.assertNull(location.getStreet());
        Assertions.assertEquals(0, location.getBuiling());
    }

    @Test
    void test_new_york_ip_equals() {
        GeoService geoServiceImpl = Mockito.spy(GeoServiceImpl.class);

        Location location = geoServiceImpl.byIp("96.44.183.149");

        Assertions.assertEquals("New York", location.getCity());
        Assertions.assertEquals(Country.USA, location.getCountry());
        Assertions.assertEquals(" 10th Avenue", location.getStreet());
        Assertions.assertEquals(32, location.getBuiling());
    }

    @Test
    void test_moscow_ip_startswith() {
        GeoService geoServiceImpl = Mockito.spy(GeoServiceImpl.class);

        Location location = geoServiceImpl.byIp("172.16.30.1");

        Assertions.assertEquals("Moscow", location.getCity());
        Assertions.assertEquals(Country.RUSSIA, location.getCountry());
        Assertions.assertNull(location.getStreet());
        Assertions.assertEquals(0, location.getBuiling());
    }

    @Test
    void test_new_york_ip_startswith() {
        GeoService geoServiceImpl = Mockito.spy(GeoServiceImpl.class);

        Location location = geoServiceImpl.byIp("96.60.200.123");

        Assertions.assertEquals("New York", location.getCity());
        Assertions.assertEquals(Country.USA, location.getCountry());
        Assertions.assertNull(location.getStreet());
        Assertions.assertEquals(0, location.getBuiling());
    }

}
