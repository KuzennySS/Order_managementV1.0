import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kuzenny.testwork.model.Order;
import ru.kuzenny.testwork.model.OrderList;
import ru.kuzenny.testwork.repository.JpaGoodsRepository;
import ru.kuzenny.testwork.service.GoodsService;
import ru.kuzenny.testwork.service.OrderListService;
import ru.kuzenny.testwork.service.OrderService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            OrderService jpa = appCtx.getBean(OrderService.class);
//            jpa.deleteByNumberOrder(112);
            System.out.println();
            System.out.println(jpa.getAll());
            System.out.println();
        }
    }
}
