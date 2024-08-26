package com.swabhav.crud.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor 
@Getter
@Setter
public class PageResponse<T> {
    private int totalPages;
    private long totalElements;
    private int size;
    private List<T> content;
    private boolean isLastPage;

    public static <K> PageResponse<K> toPageResponse(Page<K> page) {
        return new PageResponse<>(
            page.getTotalPages(),
            page.getTotalElements(),
            page.getSize(),
            page.getContent(),
            page.isLast()
        );
    }
}