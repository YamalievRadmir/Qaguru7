package quru.qa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ParamsTest {

    @ValueSource(strings = {"Rorsche Cayenne", "Renault Logan"})
    @ParameterizedTest(name = "При поиске на сайте авито по запросу {0} в результатах отображается - {0}")
    void avitoTestCars(String cars) {
        Selenide.open("https://www.avito.ru");
        $(".input-input-Zpzc1").setValue(cars).pressEnter();
        $(".items-items-kAJAg").find(String.valueOf(text(cars)));

    }

    @Disabled
    @CsvSource(value = {
            "Rorsche Cayenne, Купить Porsche Cayenne в Уфе",
            "Renault Logan, Купить Renault Logan в Уфе"})
    @ParameterizedTest(name = "При поиске на сайте авито по запросу {0} в результатах отображается - {1}")
    void avitoTestCars1(String searchData, String expectedResult) {
        Selenide.open("https://www.avito.ru");
        $(".input-input-Zpzc1").setValue(searchData).pressEnter();
        $(".index-center-_TsYY index-center_withTitle-_S7ge index-centerWide-_7ZZ_").find(String.valueOf(text(expectedResult)));

    }

    static Stream<Arguments> avitoTestCarsComplex() {
        return Stream.of(
                Arguments.of("Porsche Cayenne", "внедорожник"),
                Arguments.of("Renault Logan", "седан")
        );
    }

    @MethodSource(value = "avitoTestCarsComplex")
    @ParameterizedTest(name = "При поиске на сайте авито по запросу {0} в результатах отображается - {1}")
    void avitoTestCars2(String searchData, String expectedResult) {
        Selenide.open("https://www.avito.ru");
        $(".input-input-Zpzc1").setValue(searchData).pressEnter();
        $(".index-center-_TsYY index-center_withTitle-_S7ge index-centerWide-_7ZZ_").find(String.valueOf(text(expectedResult)));

    }

    @EnumSource(Cars.class)
    @ParameterizedTest(name = "При поиске на сайте авито по запросу {0} в результатах отображается - {1}")
    void avitoEnumTest(Cars cars) {
        Selenide.open("https://www.avito.ru");
        $(".input-input-Zpzc1").setValue(cars.desc).pressEnter();
        $(".index-center-_TsYY index-center_withTitle-_S7ge index-centerWide-_7ZZ_").find(String.valueOf(text(cars.desc)));

    }


}
