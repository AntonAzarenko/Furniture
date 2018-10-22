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
        booker.getPriceModule(DataOrder.ORDER_TEST2.getModuleList().get(0));
        verify(quadCount).getCountSquareDetailsList(DataOrder.ORDER_TEST.getDetailList());
        verify(edgeCount).getLengthEdgeMaterialForDetailList(DataOrder.ORDER_TEST.getDetailList());
    }

    @Test
    public void getPriceOrder() {
        booker.getPriceOrder(DataOrder.ORDER_TEST2);
        verify(quadCount).getCountSquareDetailsList(DataOrder.ORDER_TEST.getDetailList());
        verify(edgeCount).getLengthEdgeMaterialForDetailList(DataOrder.ORDER_TEST.getDetailList());
    }
}