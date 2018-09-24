package azarenko;

import azarenko.mock.DataOrder;
import azarenko.model.Detail;
import azarenko.model.Furniture;
import azarenko.model.furnitures.Handle;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Проект: - " + DataOrder.order.getName());
        System.out.println("Высота: - " + DataOrder.order.getModuleList().get(0).getDetailList().get(0).getY());
        System.out.println("Ширина: - " + DataOrder.order.getModuleList().get(0).getDetailList().get(1).getY());
        System.out.println("Кол-во фасадов: - " + DataOrder.order.getModuleList().get(0).getFacadeList().get(0).getDetail().getCount());
        System.out.println("Тип васада: - " + DataOrder.order.getModuleList().get(0).getFacadeList().get(0).getFacadeType());
        System.out.println("Цвет васада: - " + DataOrder.order.getModuleList().get(0).getFacadeList().get(0).getDetail().getColor().getTitle());
        System.out.println("Петли: - " + DataOrder.order.getModuleList().get(0).getFurnitureList().get(0).getFurnitures());
        List<Furniture> furnitures = DataOrder.order.getModuleList().get(0).getFurnitureList();
        Handle handle = null;
        for (Furniture cur : furnitures) {
            if (cur.getFurnitures().getClass().equals(Handle.class)) {
                handle = (Handle) cur.getFurnitures();
            }
        }
        System.out.println("Ручки: - " + handle);
        System.out.println("Деталировка: ");
        List<Detail> list = DataOrder.order.getModuleList().get(0).getDetailList();
        list.forEach(m -> System.out.println(m.getX() + " * " + m.getY() + " - " + m.getCount() +"  " + m.getName()));

    }
}
