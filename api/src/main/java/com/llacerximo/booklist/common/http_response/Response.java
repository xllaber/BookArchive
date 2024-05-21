package com.llacerximo.booklist.common.http_response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder
@JsonPropertyOrder({"totalRecords", "pagination", "data"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private Object data;
    private Integer totalRecords;
    private Map<String, Object> pagination;

    public void paginate(Integer page, Integer pageSize, String url) {
        this.pagination = new HashMap<>();
        this.pagination.put("page", page);
        this.pagination.put("page size", pageSize);
        int totalPages = (int) (Math.ceil((double) totalRecords / pageSize));
        this.pagination.put("total pages", totalPages);
        if (page > 1 && totalPages > 1)
            this.pagination.put("previous", url + "/movies?page=" + (page - 1));
        if (page < totalPages)
            this.pagination.put("previous", url + "/movies?page=" + (page + 1));
    }

}
