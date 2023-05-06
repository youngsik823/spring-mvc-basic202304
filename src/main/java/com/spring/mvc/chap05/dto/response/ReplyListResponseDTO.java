package com.spring.mvc.chap05.dto.response;

import com.spring.mvc.chap05.dto.page.PageMaker;
import lombok.*;

import java.util.List;

@Setter @Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyListResponseDTO {

    private int count; // 총 댓글 수
    private PageMaker pageInfo; // 페이지 정보
    private List<ReplyDetailResponseDTO> replies; // 댓글 리스트
}
