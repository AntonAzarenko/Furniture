package azarenka.service;

import azarenka.entity.fitting.Loops;

import java.util.List;

public interface LoopService {

    List<Loops> getAllByModule(Long id);

    List<Loops> getAll();

    List<Loops> getAllByManufacturerName(String name);

    Loops save(Loops loop);

    void save(LoopParams params);

    LoopParams getParamsById(Long id);

    void save(LoopsOfOrder loopsOfOrder);
}
