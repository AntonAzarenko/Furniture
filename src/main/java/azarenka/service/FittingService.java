package azarenka.service;

import azarenka.entity.Fitting;

public interface FittingService {

    Fitting addHandleToOrder(Fitting fitting);

    Fitting save(Fitting fitting);
}
