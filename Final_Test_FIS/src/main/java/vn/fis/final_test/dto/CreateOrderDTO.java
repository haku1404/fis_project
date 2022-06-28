package vn.fis.final_test.dto;

import lombok.*;

import java.util.ArrayList;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDTO {
    private Long customerId;
    private ArrayList<ProductInfoDTO> orderItems;
}
