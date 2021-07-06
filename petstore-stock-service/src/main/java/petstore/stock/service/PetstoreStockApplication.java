package petstore.stock.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PetstoreStockApplication {

        public static void main(String[] args) {
            SpringApplication.run(PetstoreStockApplication.class, args);
        }

}
