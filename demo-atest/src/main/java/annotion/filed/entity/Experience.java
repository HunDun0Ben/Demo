package annotion.filed.entity;

import annotion.filed.annotion.Sensitive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Experience {

    @Sensitive
    private String name;

    private String time;
}
