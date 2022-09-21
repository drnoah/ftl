package ${package};

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ServiceTest {

private final Service service = new Service();

@Test
void shouldAddTextAndNumber() {
    //given
    var text = "the number is : ";
    var number = 10;

    //when
    var result = service.someMethod(text, number);

    //then
    assertThat(result).isEqualTo("the number is : 10");
    }
}