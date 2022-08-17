package ai.mengdejia.springevent;

import ai.mengdejia.springevent.demo.MyEvent;
import ai.mengdejia.springevent.demo.MyTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest(classes = SpringEventApplication.class)
@Slf4j
class SpringEventApplicationTests {

  @Autowired
  private ApplicationEventPublisher eventPublisher;

  @Test
  public void publishTest() {
    MyTask myTask = new MyTask(1L, "tracking_task", false);
    MyEvent event = new MyEvent(myTask);
    log.info("publish myTask: {}", myTask.getName());
//    System.out.println(myTask.hashCode()); // 这种用法要求hashcode() 方法没有被重写。
    System.out.println(System.identityHashCode(myTask));
    // hashcode 一致，说明发布订阅使用的是同一个对象。
    eventPublisher.publishEvent(event);
    log.info("task published!");
  }

}
