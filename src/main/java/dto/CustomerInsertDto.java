package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInsertDto {
    private String firstName;
    private String lastName;
    private Date bornAt;
}
