package rabbitmq.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
public class RabbitAmqpTutorialsRunner implements CommandLineRunner {

    @Value("${tutorial.client.duration:0}")
    private int duration;
    @Autowired
    private ConfigurableApplicationContext ctx;

    @Override
    public void run(String @NonNull ... args) throws Exception {
        log.info("Ready ... running for {} ms", duration);
        Thread.sleep(duration);
        ctx.close();
    }
}
