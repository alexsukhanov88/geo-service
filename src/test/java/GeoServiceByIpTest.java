import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.netology.geo.GeoServiceImpl.*;

public class GeoServiceByIpTest {

    private GeoService geoService = new GeoServiceImpl();

    @ParameterizedTest
    @ValueSource (strings = {LOCALHOST, MOSCOW_IP, NEW_YORK_IP})
    public void by_ip_success(String argument) {
        assertThat(geoService.byIp(argument), instanceOf(Location.class));
    }

}