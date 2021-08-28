package com.volodymyr.pletnov.dobropost_bot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Data
@Builder
@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
public class NotificationToUserRequest {
	private String coinName;
	private String coinSymbol;
	@Digits(integer = 12, fraction = 20)
	private BigDecimal profitInPercent;
	@Digits(integer = 12, fraction = 20)
	private BigDecimal profit;
	@Digits(integer = 12, fraction = 20)
	private BigDecimal price;
	@Digits(integer = 12, fraction = 20)
	private BigDecimal percentChange1h;
	@Digits(integer = 12, fraction = 20)
	private BigDecimal percentChange24h;
}
