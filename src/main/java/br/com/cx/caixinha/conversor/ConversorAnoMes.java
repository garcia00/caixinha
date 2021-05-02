package br.com.cx.caixinha.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConversorAnoMes implements Converter<String, Integer> {

	@Override
	public Integer convert(String source) {
		String[]  values = source.split("/");
		return Integer.valueOf(values[1]+values[0]);
	}
	
	
	

}
