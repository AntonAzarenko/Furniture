package azarenka.service.logic;

import azarenka.entity.Fitting;
import azarenka.service.FittingService;
import azarenka.service.HandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FittingServiceImpl implements FittingService {

    @Autowired
    HandleService handleService;

    @Override
    public Fitting addHandleToOrder(Fitting fitting) {
        return null;
    }

    @Override
    public Fitting save(Fitting fitting) {
        return save(fitting);
    }
}
