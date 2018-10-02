package azarenko;

import azarenko.entity.*;
import azarenko.repository.DetailRepository;
import azarenko.repository.logic.proxy.ProxyDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private ProxyDetailRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll(); //
        repository.save(new Detail( null,1L, edgeMaterialSideWall, "sidewall", 18,
                380, 1000, 2, Material.DSP, color));
        repository.save(new Detail( null,1L, edgeMaterialCounterTop, "table top", 18,
                410, 1000, 1, Material.DSP, color));
        repository.save(new Detail(null,1L, null, "back side", 4,
                995, 955, 1, Material.DVP, null));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");

        for (Detail detail : repository.findAll()) {
            System.out.println(detail);
        }
        System.out.println(repository.findByName("back side"));

        System.out.println();
    }


    public static Set<EdgeMaterial> edgeMaterialSideWall = new HashSet<>();
    public static Set<EdgeMaterial> edgeMaterialCounterTop = new HashSet<>();
    public static Set<EdgeMaterial> edgeMaterialFloor = new HashSet<>();
    public static Set<EdgeMaterial> buttCloseFacade = new HashSet<>();
    public static Color color = new Color( "Аляска", "Swisspan", Country.POLAND);


    static {
        edgeMaterialSideWall.add(new EdgeMaterial(Country.RUSSIA, "Egger", EdgeType.ABC, "pepel",
                new BigDecimal(0.35), 1, ButtClose.BUTT_Y));
        edgeMaterialSideWall.add(new EdgeMaterial( Country.RUSSIA, "noname", EdgeType.MALMIN, "pepel",
                new BigDecimal(0.01), 0.2, ButtClose.BUTT_X));
        edgeMaterialCounterTop.add(new EdgeMaterial( Country.RUSSIA, "Egger", EdgeType.ABC, "pepel",
                new BigDecimal(1.2), 2, ButtClose.BUTT_ARROUND));
        edgeMaterialFloor.add(new EdgeMaterial( Country.RUSSIA, "Egger", EdgeType.ABC, "pepel",
                new BigDecimal(0.35), 1, ButtClose.BUTT_Y));
        buttCloseFacade.add(new EdgeMaterial( Country.AUSTRIA, "Arpa", EdgeType.PVH, "graphit",
                new BigDecimal(2.3), 2, ButtClose.BUTT_ARROUND));

    }
}


