package ai.mengdejia.springevent.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MyTask {
  private Long id;

  private String name;

  private boolean published;
}
