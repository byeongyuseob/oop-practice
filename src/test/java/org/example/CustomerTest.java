package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

/*
* 1. 도메인을 구성하는 객체에는 어떤 것들이 있는지 고민
*   ㄴ 손님, 메뉴판, 메뉴(돈까스,냉면,만두), 요리사, 요리
* 2. 객체들 간의 관계를 고민
*   ㄴ 손님 -- 메뉴판
*   ㄴ 손님 -- 요리사
*   ㄴ 요리사 -- 요리
* 3. 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링하기
    ㄴ 손님 -- 손님 타입
    ㄴ 돈까스/냉면/만두 -- 요리 타입
    ㄴ 메뉴판 -- 메뉴판
    ㄴ 메뉴 -- 메뉴
* 4. 협력을 서계
* 5. 객체들을 포관하는 타입에 적절한 책임을 할당.
* 6. 구현하기
* */

public class CustomerTest {

    @DisplayName("메뉴 이름에 해당하는 요리를 주문을 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"돈까스", "만두", "냉면", "오징어"})
    void orderTest(String menuName) {
        Customer customer = new Customer();
        Cooking cooking = new Cooking();
        Menu menu = new Menu(
                List.of(
                        new MenuItem("돈까스", 5000),
                        new MenuItem("냉면", 7000))
        );

        assertThatCode(() -> customer.order(menuName, menu, cooking))
                .doesNotThrowAnyException();
    }
}
