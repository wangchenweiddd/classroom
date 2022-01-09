package com.edu.ahu.classroom.service;


import com.edu.ahu.classroom.dto.AirConLogDto;

import java.util.Date;
import java.util.List;

public interface AirConOperateService {

    List<AirConLogDto> listUserOperateByAdministrator(Date startTime, Date endTime);

}
