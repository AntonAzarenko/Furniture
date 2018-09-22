package azarenko.mock;


import azarenko.model.Facade;
import azarenko.model.Module;

import java.util.ArrayList;
import java.util.List;

public class DataModule {
    public static List<Facade> facades = new ArrayList<>();

    public static List<Module> getModule() {
        facades.add(DataFacade.facade);
        List<Module> list = new ArrayList<>();
        Module module = new Module(1L, DetailsData.detailList, DataFurniture.getList(), facades);
        list.add(module);
        return list;
    }

}
