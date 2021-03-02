package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  // Test Case 구현
  @Test
  @DisplayName("Set의 크기 확인")
  public void checkSetSize() {
    final int testData = numbers.size();
    final int expectedData = 3;

    assertThat(testData).isEqualTo(expectedData);
  }

  @Test
  @DisplayName("Set에 적절한 요소가 포함되었는지 확인")
  public void contains() {
    assertThat(numbers.contains(1)).isTrue();
    assertThat(numbers.contains(2)).isTrue();
    assertThat(numbers.contains(3)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("Set에 적절한 요소가 포함되었는지 확인 -- ParameterizedTest")
  public void contains(int number) {
    assertThat(numbers.contains(number)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1:True", "2:True", "3:True", "4:False", "5:False"}, delimiter = ':')
  @DisplayName("Set에 적절한 요소외 여러 요소를 넣어 결과를 확인함")
  public void containsMultipleValues(String input, String expected) {
    final int testData = Integer.parseInt(input);
    final boolean expectedData = Boolean.parseBoolean(expected);

    assertThat(numbers.contains(testData)).isEqualTo(expectedData);
  }

}
