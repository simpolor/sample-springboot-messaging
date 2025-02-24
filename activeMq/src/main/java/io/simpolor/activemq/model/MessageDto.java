package io.simpolor.activemq.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageDto {

    private String title;
    private String content;
}
