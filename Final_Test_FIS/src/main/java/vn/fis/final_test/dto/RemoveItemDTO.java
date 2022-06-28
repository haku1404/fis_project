package vn.fis.final_test.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RemoveItemDTO {
    private Long orderId;
    private Long orderItemId;
}
