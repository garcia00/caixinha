package br.com.cx.caixinha.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Component
public class ConversorValor implements Converter<String, BigDecimal> {

    @Override
    public BigDecimal convert(String valorString) {
//        return new BigDecimal(new DecimalFormat("#,##0.00").format(valorString));
//        return new BigDecimal(new DecimalFormat("#,##0.00").format(valorString));

        return new BigDecimal(valorString);
    }
}
