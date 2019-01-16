package azarenka.service.logic;

import azarenka.entity.Edge;
import azarenka.repository.EdgeRepository;
import azarenka.service.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdgeServiceImpl implements EdgeService {

    @Autowired
    private EdgeRepository repository;

    @Override
    public List<Edge> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void save(Edge edgeMaterial) {

    }

    @Override
    public Edge getById(Long id) {
        return null;
    }
}
