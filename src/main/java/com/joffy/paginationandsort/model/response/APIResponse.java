package com.joffy.paginationandsort.model.response;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {
   
    int recordCount;
    T response;

}