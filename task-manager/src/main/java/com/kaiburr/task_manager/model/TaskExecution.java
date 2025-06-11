package com.kaiburr.task_manager.model;

import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskExecution {
    private Date startTime;
    private Date endTime;
    private String output;
}
