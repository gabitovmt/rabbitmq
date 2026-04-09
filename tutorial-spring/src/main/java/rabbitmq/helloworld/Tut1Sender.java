package rabbitmq.helloworld;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
@Slf4j
public class Tut1Sender {

    private final RabbitTemplate template;
    private final Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void send() {
        var message = "Hello World!";
        template.convertAndSend(queue.getName(), message);
        log.info(" [x] Sent '{}'", message);
    }
}
