import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {
    @Test
    void test_text_russian() {
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

        String text = localizationService.locale(Country.RUSSIA);

        Assertions.assertEquals("Добро пожаловать", text);

    }

    @Test
    void test_text_american() {
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

        String text = localizationService.locale(Country.USA);

        Assertions.assertEquals("Welcome", text);

    }

    @Test
    void test_text_brazil() {
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

        String text = localizationService.locale(Country.BRAZIL);

        Assertions.assertEquals("Welcome", text);

    }
}
