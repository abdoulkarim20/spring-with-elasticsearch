package dev.architecture.springbootelasticsearch.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoidResponse {
    private int status;
    private String message;
}
