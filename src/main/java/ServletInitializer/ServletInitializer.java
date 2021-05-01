package ServletInitializer;

import org.springframework.boot.builder.SpringApplicationBuilder;

import br.com.cx.caixinha.CaixinhaApplication;

public class ServletInitializer {
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CaixinhaApplication.class);
	}

}
