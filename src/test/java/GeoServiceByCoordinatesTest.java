import org.junit.jupiter.api.Test;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import org.junit.jupiter.api.Assertions;

public class GeoServiceByCoordinatesTest {

    private GeoService geoService = new GeoServiceImpl();

    @Test
    public void by_ip_coordinates() {
        Assertions.assertThrows(RuntimeException.class, () -> geoService.byCoordinates(1.0, 2.0));
    }
}
