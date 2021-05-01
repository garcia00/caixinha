package br.com.cx.caixinha;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.server.i18n.FixedLocaleContextResolver;

@SpringBootApplication
public class CaixinhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaixinhaApplication.class, args);
	}
	
	public FixedLocaleContextResolver localResolver() {
		return new FixedLocaleContextResolver(new Locale("pt","BR"));
	}

}
