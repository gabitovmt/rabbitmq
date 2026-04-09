package rabbitmq.helloworld;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

@RequiredArgsConstructor
@Slf4j
public class RabbitAmqpTutorialsRunner implements CommandLineRunner {
    private final int duration;
    private final ConfigurableApplicationContext ctx;

    @Override
    public void run(String @NonNull ... args) throws Exception {
        log.info("Ready ... running for {} ms", duration);
        Thread.sleep(duration);
        ctx.close();
    }
}
