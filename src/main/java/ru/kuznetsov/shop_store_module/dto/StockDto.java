package ru.kuznetsov.shop_store_module.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockDto extends AbstractDto {
    private Integer amount;
    private Long productId;
    private String productName;
    private String store;
    private String storeAddress;
}
