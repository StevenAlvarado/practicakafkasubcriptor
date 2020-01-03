package microservicios.latam.practicakafkasuscriptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import microservicios.latam.practicakafkasuscriptor.model.Pedido;

@SpringBootApplication
@EnableBinding(Sink.class)
public class PracticaKafkaSuscriptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaKafkaSuscriptorApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void consumeOderUpdates(Pedido pedido) {
		System.out.println("Número de pedido : " + pedido.getPedidoId());
		System.out.println("Cliente : " + pedido.getClienteId());
	}
	
}
