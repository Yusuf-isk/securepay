package com.demo.securepay.request;

import lombok.Data;

import java.util.Date;

@Data
public class SearchByDatePaymentsRequest {
    private Date startDate;
    private Date endDate;
}
