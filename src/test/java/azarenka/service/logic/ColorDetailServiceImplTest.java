package azarenka.service.logic;

import azarenka.entity.ColorDetail;
import azarenka.repository.ColorMaterialRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import resources.DataColorMaterial;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ColorDetailServiceImplTest {

    @InjectMocks
    private ColorDetailServiceImpl service;

    @Mock
    private ColorMaterialRepository repository;

    @Test
    public void getByID() {
        when(repository.read(anyString())).thenReturn(DataColorMaterial.colorDetailFive);
        ColorDetail colorDetail = service.getByID(anyString());
        assertThat(colorDetail).isEqualTo(DataColorMaterial.colorDetailFive);
        verify(repository).read(anyString());
    }

    @Test
    public void getAll() {
        when(repository.readAll()).thenReturn(DataColorMaterial.colorDetails);
        List<ColorDetail> colorDetail = service.getAll();
        assertThat(colorDetail).isEqualTo(DataColorMaterial.colorDetails);
        verify(repository).readAll();
    }

    @Test
    public void getByName() {
        when(repository.read(anyString())).thenReturn(DataColorMaterial.colorDetailFive);
        ColorDetail colorDetail = service.getByID(anyString());
        assertThat(colorDetail).isEqualTo(DataColorMaterial.colorDetailFive);
        verify(repository).read(anyString());
    }

    @Test
    public void save() {
        doNothing().when(repository).save(DataColorMaterial.colorDetailFour);
        service.save(DataColorMaterial.colorDetailFour);
        verify(repository).save(DataColorMaterial.colorDetailFour);
    }

    @Test
    public void delete() {
        doNothing().when(repository).delete(anyString());
        service.delete(anyString());
        verify(repository).delete(anyString());
    }
}
