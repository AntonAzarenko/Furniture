package azarenka.service.logic;

import azarenka.entity.ColorMaterial;
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
public class ColorMaterialServiceImplTest {

    @InjectMocks
    private ColorMaterialServiceImpl service;

    @Mock
    private ColorMaterialRepository repository;

    @Test
    public void getByID() {
        when(repository.read(anyString())).thenReturn(DataColorMaterial.colorMaterialFive);
        ColorMaterial colorMaterial = service.getByID(anyString());
        assertThat(colorMaterial).isEqualTo(DataColorMaterial.colorMaterialFive);
        verify(repository).read(anyString());
    }

    @Test
    public void getAll() {
        when(repository.readAll()).thenReturn(DataColorMaterial.colorMaterials);
        List<ColorMaterial> colorMaterial = service.getAll();
        assertThat(colorMaterial).isEqualTo(DataColorMaterial.colorMaterials);
        verify(repository).readAll();
    }

    @Test
    public void getByName() {
        when(repository.read(anyString())).thenReturn(DataColorMaterial.colorMaterialFive);
        ColorMaterial colorMaterial = service.getByID(anyString());
        assertThat(colorMaterial).isEqualTo(DataColorMaterial.colorMaterialFive);
        verify(repository).read(anyString());
    }

    @Test
    public void save() {
        doNothing().when(repository).save(DataColorMaterial.colorMaterialFour);
        service.save(DataColorMaterial.colorMaterialFour);
        verify(repository).save(DataColorMaterial.colorMaterialFour);
    }

    @Test
    public void delete() {
        doNothing().when(repository).delete(anyString());
        service.delete(anyString());
        verify(repository).delete(anyString());
    }
}
