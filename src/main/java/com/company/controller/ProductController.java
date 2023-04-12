package com.company.controller;

import com.company.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

//	@GetMapping(value = "", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@GetMapping("")
	Flux<Product> getProducts() {
		
//		List<String> products = new ArrayList<String>();
		Random random = new Random();
		Flux<Product> products = Flux.<Product>generate(sink -> sink.next(new Product(random.nextLong(), "Prod", random.nextInt(100)))).take(10);
		return products;

//		Flux<String> values = Flux.<String>generate(sink -> sink.next("Live temprature: "+random.nextInt(50))).delayElements(Duration.ofSeconds(2));
//		return values;
		//		Flux.just("Apple","Banana","Orange","iPhone","Books")
//				.log()
//				.subscribe(new Subscriber<String>() {
//
//					private Subscription s;
//					int count;
//					@Override
//					public void onSubscribe(Subscription subscription) {
//						subscription.request(2);
//						this.s = subscription;
//					}
//
//					@Override
//					public void onNext(String s) {
//						products.add(s);
//						this.count ++;
//						if(count == 2){this.count = 0;this.s.request(2);}
//
//					}
//
//					@Override
//					public void onError(Throwable throwable) {
//
//					}
//
//					@Override
//					public void onComplete() {
//
//					}
//				});
//		logger.info(products.toString());
	}

}
