package rabbitmq.helloworld;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("hello-world")
@Configuration
public class Tut1Config {

    @Bean
    public Queue hello() {
        return QueueBuilder.durable("hello").quorum().build();
    }

    @Profile("receiver")
    @Bean
    public Tut1Receiver receiver() {
        return new Tut1Receiver();
    }

    @Profile("sender")
    @Bean
    public Tut1Sender sender(RabbitTemplate template, Queue queue) {
        return new Tut1Sender(template, queue);
    }
}
