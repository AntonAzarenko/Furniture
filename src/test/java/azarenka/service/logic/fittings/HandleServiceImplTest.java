package azarenka.service.logic.fittings;



import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import azarenka.dto.fittingdto.HandleCreateDTO;
import azarenka.entity.Country;
import azarenka.entity.fitting.Handle;
import azarenka.entity.fitting.params.HandleColors;
import azarenka.repository.HandleColorsRepository;
import azarenka.repository.HandleParamsRepository;
import azarenka.repository.HandleRepository;

@RunWith(MockitoJUnitRunner.class)
public class HandleServiceImplTest {

    @Mock
    private HandleRepository repository;
    @Mock
    private HandleParamsRepository handleParamsRepository;
    @Mock
    private HandleColorsRepository handleColorsRepository;

    @InjectMocks
    private HandleServiceImpl handleService;

    private final static String HANDLE_ARTICLE = "AS23";

    @Before
    public void setUp() {
    }

    @Test
    public void testSave() {
      when(repository.save(buildHanle())).thenReturn(buildHanle());
      assertEquals(buildHanle(), handleService.save(buildHandleCreateDTO()));
    }

    @Test
    public void deleteById() {
        Handle handle = buildHanle();
        handleService.deleteById(handle.getId());
        verify(repository).deleteById(handle.getId());
    }

    @Test
    public void testGetById() {
        Handle handle = buildHanle();
        when(repository.getById(handle.getId())).thenReturn(handle);
        assertEquals(handle, handleService.getById(handle.getId()));
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getByOrderId() {
    }

    @Test
    public void addHandleParams() {
    }

    @Test
    public void getAllParamsById() {
    }

    @Test
    public void getHandleColorsByHandleId() {
    }

    @Test
    public void addHandleColors() {
    }

    @Test
    public void getParamsById() {
    }

    @Test
    public void addHandleOfOrder() {
    }

    @Test
    public void getHandleOfOrderByModuleId() {
    }

    @Test
    public void getHandleColorsById() {
    }

    private Handle buildHanle() {
        Handle handle = new Handle();
        handle.setArticle(HANDLE_ARTICLE);
        handle.setColor(buildHandleColor());
        handle.setCountry(Country.BELARUS);
        handle.setFileName("picture.jpg");
        return handle;
    }

    private List<HandleColors> buildHandleColor() {
        HandleColors colors = new HandleColors();
        colors.setArticle("RED");
        colors.setHandle(new Handle());
        return Collections.singletonList(colors);
    }

    private HandleCreateDTO buildHandleCreateDTO() {
        HandleCreateDTO handleCreateDTO = new HandleCreateDTO();
        handleCreateDTO.setArticle(HANDLE_ARTICLE);
        handleCreateDTO.setFileName("picture.jpg");
        handleCreateDTO.setCountry("BELARUS");
        handleCreateDTO.setChrome_bright(true);
        handleCreateDTO.setNinetySix(true);
        handleCreateDTO.setPriceNinetySix("2.45");
        return handleCreateDTO;
    }
}