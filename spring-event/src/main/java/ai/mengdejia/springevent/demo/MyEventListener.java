package ai.mengdejia.springevent.demo;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@Slf4j
public class MyEventListener implements ApplicationListener<MyEvent> {

  @Override
  public void onApplicationEvent(MyEvent event) {
    Assert.notNull(event, "event can not be null!");
    MyTask myTask = event.getTask();
    log.info("MyEventListener get task: {}", myTask.toString());
    myTask.setPublished(true);
    System.out.println(System.identityHashCode(myTask));
//    System.out.println(myTask.hashCode());
    log.info("task finished!");
  }
}
