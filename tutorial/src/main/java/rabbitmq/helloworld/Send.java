package rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Send {
    private final static Logger LOG = LoggerFactory.getLogger(Send.class);
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        // Создаём соединение к серверу
        var factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // Объявляем очередь
            Map<String, Object> args = Map.of("x-queue-type", "quorum");
            channel.queueDeclare(QUEUE_NAME, true, false, false, args);

            // Отправляем сообщение
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            LOG.info(" [x] Sent '{}'", message);
        }
    }
}
