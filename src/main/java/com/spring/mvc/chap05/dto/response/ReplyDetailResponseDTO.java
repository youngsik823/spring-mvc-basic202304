package com.spring.mvc.chap05.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.mvc.chap05.entity.Reply;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyDetailResponseDTO {

    private long rno;
    private String text;
    private String writer;

    @JsonFormat(pattern = "yyyy년 MM월 dd일 HH:mm")
    private LocalDateTime regDate;

    // 엔터티를 DTO로 변환하는 생성자
    public ReplyDetailResponseDTO(Reply reply) {
        this.rno = reply.getReplyNo();
        this.text = reply.getReplyText();
        this.writer = reply.getReplyWriter();
        this.regDate = reply.getReplyDate();
    }

}
