package com.spring.mvc.chap05.dto.page;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Page {

    private int pageNo; // 클라이언트가 보낸 페이지 번호
    private int amount; // 클라이언트가 보낸 목록게시물 수

    public Page() {
        this.pageNo = 1;
        this.amount = 6;
    }

    public void setPageNo(int pageNo) {
        if (pageNo < 1 || pageNo > Integer.MAX_VALUE) {
            this.pageNo = 1;
            return;
        }
        this.pageNo = pageNo;
    }

    public void setAmount(int amount) {
        if (amount < 6 || amount > 10) {
            this.amount = 6;
            return;
        }
        this.amount = amount;
    }

    public int getPageStart() {
        /*
            pageNo : 1 ->  return 0
            pageNo : 2 ->  return 6
            pageNo : 3 ->  return 12
            pageNo : n ->  return (n - 1) * 6
         */
        return (pageNo - 1) * amount;
    }
}
