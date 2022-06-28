package vn.fis.final_test.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductInfoDTO {
    private Long productId;
    private Long quantity;
}
