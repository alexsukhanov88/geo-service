import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class LocalizationServiceLocaleTest {

    private LocalizationService localizationService = new LocalizationServiceImpl();

    @ParameterizedTest
    @EnumSource(Country.class)
    public void by_ip_success(Country country) {
        assertThat(localizationService.locale(country), instanceOf(String.class));
    }
}
