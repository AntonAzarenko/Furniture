package azarenka.service;

import azarenka.entity.fitting.Loops;
import azarenka.entity.fitting.params.LoopParams;

import java.util.List;

public interface LoopService {

    List<Loops> getAllByModule(Long id);

    List<Loops> getAll(Long id);

    List<Loops> getAllByManufacturerName(String name);

    Loops save(Loops loop);

    void save(LoopParams params);
}
