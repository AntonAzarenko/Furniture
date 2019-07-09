package azarenka.util;

import azarenka.entity.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryFormatterUtil {

    public Country replaceCountry(String name) {
        switch (name) {
            case "AUSTRIA":
                return Country.AUSTRIA;

            case "GERMANY":
                return Country.GERMANY;

            case "POLAND":
                return Country.POLAND;

            case "RUSSIA":
                return Country.RUSSIA;

            case "UKRAINE":
                return Country.UKRAINE;

            case "BELARUS":
                return Country.BELARUS;

            case "CHINA":
                return Country.CHINA;

        }
        return null;
    }
}
