package azarenka.service.logic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import resources.DataOrder;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class BookerTest {

    @InjectMocks
    private Booker booker;

    @Mock
    private ManagerEdgeCount edgeCount;

    @Mock
    private ManagerQuadCount quadCount;

    @Test
    public void getPriceModule() {
        }

    @Test
    public void getPriceOrder() {
      }
}