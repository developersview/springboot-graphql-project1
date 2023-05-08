package com.developersview.springbootgraphqlproject1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pranoy.chakraborty
 * @Date 09/05/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    String name;
}
