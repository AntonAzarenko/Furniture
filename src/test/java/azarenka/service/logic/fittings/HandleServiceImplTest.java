package azarenka.service.logic.fittings;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import azarenka.dto.fittingdto.HandleCreateDTO;
import azarenka.entity.Country;
import azarenka.entity.fitting.Handle;
import azarenka.entity.fitting.params.HandleColors;
import azarenka.repository.HandleRepository;

public class HandleServiceImplTest {

    private HandleRepository repository;

    private HandleServiceImpl handleService;

    private final static String HANDLE_ARTICLE = "AS23";

    @Before
    public void setUp() {
        repository = createMock(HandleRepository.class);
        handleService = createMock(HandleServiceImpl.class);
        handleService.setRepository(repository);
    }

    @Test
    public void testSave() {
        expect(handleService.save(buildHandleCreateDTO())).andReturn(buildHanle());
        expect(repository.save(buildHanle())).andReturn(buildHanle()).once();
        expect(handleService.save(buildHandleCreateDTO())).andReturn(buildHanle());
        replay(repository);
        //assertEquals(buildHanle(), handleService.save(buildHandleCreateDTO()));
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void testGetById() {
        expect(repository.getByArticle(HANDLE_ARTICLE)).andReturn(buildHanle());
        replay(repository);
//        assertEquals(=);
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
        return handleCreateDTO;
    }
}