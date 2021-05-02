package br.com.cx.caixinha.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConversorAnoMes implements Converter<String, Integer> {

	@Override
	public Integer convert(String source) {
		 System.out.println(source);
		return null;
	}
	
	
	

}
