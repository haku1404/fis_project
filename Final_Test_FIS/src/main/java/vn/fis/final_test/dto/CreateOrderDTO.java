package vn.fis.final_test.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CreateOrderDTO {
    private Long customerId;
    private ArrayList<ProductQuantityDTO> orderItemInfo;
}
