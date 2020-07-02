package lcl.mm.pattern.stretegy.demo1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlyImpl implements FlyBehavior {
    @Override
    public void fly() {
      log.info("i can fly");
    }
}
