package azarenka.service.logic;

import azarenka.dto.DetailDTO;
import azarenka.entity.Detail;
import azarenka.repository.DetailRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailServiceImplTest {

    @InjectMocks
    private DetailServiceImpl detailService;

    @Mock
    private DetailRepository detailRepository;

    @Mock
    private DetailDTO detailDTO;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAll() {
        when(detailRepository.findAll()).thenReturn(Arrays.asList(buildDetail(), buildDetail()));
        List<Detail> expectedList = Arrays.asList(buildDetail(), buildDetail());
        assertEquals(expectedList, detailService.getAll());
        verify(detailRepository).findAll();
    }

    @Test
    public void getById() {
        when(detailRepository.getById(1L)).thenReturn(buildDetail());
        assertEquals(buildDetail(), detailService.getById(1L));
        verify(detailRepository).getById(1L);
    }

    @Test
    public void save() {
        when(detailRepository.save(buildDetail())).thenReturn(buildDetail());
        assertEquals(buildDetail(), detailService.save(buildDetail()));
        verify(detailRepository).save(buildDetail());
    }

    @Test
    public void testDelete() {
        doNothing().when(detailRepository).deleteById(1L);
        detailService.delete(1L);
        verify(detailRepository).deleteById(1L);
    }

    @Test
    public void getDTOByModuleId() {
        when(detailRepository.getAllByModule_Id(1L)).thenReturn(Arrays.asList(buildDetail()));
        when(detailDTO.asDetailDTO(Arrays.asList(buildDetail()))).thenReturn(Arrays.asList(buildDetailDTO()));
        assertEquals(Arrays.asList(buildDetailDTO()),detailService.getDTOByModuleId(1L));
    }

    @Test
    public void testGetByModuleId() {
        when(detailRepository.getAllByModule_Id(1L)).thenReturn(Arrays.asList(buildDetail()));
        Detail expectedDetail = buildDetail();
        assertEquals(Arrays.asList(expectedDetail), detailService.getByModuleId(1L));
        verify(detailRepository).getAllByModule_Id(1L);
    }

    private Detail buildDetail(){
        Detail detail = new Detail();
        detail.setX(500);
        detail.setY(2500);
        detail.setCount(50);
        return detail;
    }

    private DetailDTO buildDetailDTO(){
        DetailDTO detailDTO = new DetailDTO();
        detailDTO.setX(500);
        detailDTO.setY(2500);
        detailDTO.setCount(50);
        return detailDTO;
    }
}