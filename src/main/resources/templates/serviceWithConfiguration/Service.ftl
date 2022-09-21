package ${package};
<#list imports as import>
import ${import};
</#list>

public class Service {
    public String someMethod(String input1, Integer input2) {
        return input1 + input1;
    }
}
