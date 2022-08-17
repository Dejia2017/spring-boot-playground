package ai.mengdejia.springevent.demo;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

  private MyTask myTask;

  // 继承父类的类，实例化时会先调用父类的构造方法; 因为父类没有默认构造函数，因此此处需要主动调用。
  public MyEvent(MyTask myTask) {
    // 且super必须执行在第一步，否则 this.task 无法被赋值。
    super(myTask);
    this.myTask = myTask;
  }

  public MyTask getTask() {
    return myTask;
  }
}
