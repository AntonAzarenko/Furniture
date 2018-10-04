package testdata;


import azarenko.entity.Facade;
import azarenko.entity.Module;

import java.util.ArrayList;
import java.util.List;

public class DataModule {
    public static List<Facade> facades = new ArrayList<>();

    public static List<Module> getModule() {
        facades.add(DataFacade.facade);
        List<Module> list = new ArrayList<>();
        list.add(new Module(null,"Камод", DetailsData.detailList, DataFurniture.getList(), facades));
        return list;
    }

}
