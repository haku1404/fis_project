package vn.fis.final_test.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddOrderItemDTO {
    private Long orderId;
    private Long productId;
    private Long quantity;
}
