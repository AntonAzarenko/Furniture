package azarenka.factories;

import azarenka.util.CheckUniqueElementHandle;
import org.springframework.stereotype.Component;

@Component
public class CheckHandleFactory implements AbstractFactory<CheckUniqueElementHandle> {

    @Override
    public CheckUniqueElementHandle create() {
        return new CheckUniqueElementHandle();
    }
}
