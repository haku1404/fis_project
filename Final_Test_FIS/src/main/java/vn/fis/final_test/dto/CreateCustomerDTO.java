package vn.fis.final_test.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CreateCustomerDTO {
    private String name;
    private String mobile;
    private String address;
}
