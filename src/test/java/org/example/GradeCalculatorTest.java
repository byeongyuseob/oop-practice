package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
1. 도메인을 구성하는 객체에는 어떤 것들이 있는지 고민
    // 학점 계산기 도메인 : 이수한 과목(객체지향프로그래밍, 자료구조, 중국어회화), 학점 계산기
2. 객체들 간의 관계를 고민
    // 학점 계산기가 이수한 과목을 인스턴스 변수로 가지면서 평균 학점은 계산하면 되겠다.
3. 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 하기
    // 객체지향프로그래밍, 자료구조, 중국어회화 --> 과목(코스) 클레스화
4. 적절한 객체에 적절한 동작을 할당해서 협력 설계 (핵심 포인트)
    // 이수한 과목을 인자로 학점 계산기에게 전달하여 평균 학점 계산을 요청 --> (학점수 * 교과목 평점)의 합계 --> 과목(코스)
    //                                                      --> 수강신청 총 학정의 수        --> 과목(코스)
5. 객체들을 포관하는 타입에 적절한 책임을 할당 (public interface)

6. 구현
* */


public class GradeCalculatorTest {
    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(
                new Course("OOP", 3, "A+"),
                new Course("자료구조", 3, "A+"));

        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double gradeResult = gradeCalculator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);
    }
}
