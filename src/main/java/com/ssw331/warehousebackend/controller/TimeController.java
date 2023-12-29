package com.ssw331.warehousebackend.controller;

import com.ssw331.warehousebackend.dao.serialization.Result;
import com.ssw331.warehousebackend.dao.serialization.ResultResponse;
import com.ssw331.warehousebackend.service.TimeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "时间查询")
@RestController
@RequestMapping("time")
public class TimeController {
    TimeService timeService;

    @Autowired
    private void setTimeService(TimeService timeService) {
        this.timeService = timeService;
    }

    @Operation(summary = "年份")
    @RequestMapping(value = "year", method = RequestMethod.GET)
    public Result<Object> timeYear(@RequestParam int year) {
        long startTime = System.currentTimeMillis();
        int data = timeService.searchMoviesByYear(year);
        List<Long> modelTimes = new ArrayList<>();
        List<String> modelLogs = new ArrayList<>();
        modelTimes.add(0L);
        modelLogs.add("");
        modelTimes.add(0L);
        modelLogs.add("");
        modelTimes.add(System.currentTimeMillis() - startTime);
        modelLogs.add("MATCH (m:Movie) WHERE m.release_time contains '" + year + "' RETURN count(m);");
        return ResultResponse.success(data, modelTimes, modelLogs);
    }

    @Operation(summary = "年月")
    @RequestMapping(value = "year-month", method = RequestMethod.GET)
    public Result<Object> timeYearMonth(@RequestParam int year, @RequestParam int month) {
        long startTime = System.currentTimeMillis();
        int data = timeService.searchMoviesByYM(year, month);
        List<Long> modelTimes = new ArrayList<>();
        List<String> modelLogs = new ArrayList<>();
        modelTimes.add(0L);
        modelLogs.add("");
        modelTimes.add(0L);
        modelLogs.add("");
        modelTimes.add(System.currentTimeMillis() - startTime);
        modelLogs.add("MATCH (m:Movie) WHERE m.release_time contains '" + year + "/" + month + "' RETURN count(m);");
        return ResultResponse.success(data, modelTimes, modelLogs);
    }

    @Operation(summary = "年月日")
    @RequestMapping(value = "year-month-day", method = RequestMethod.GET)
    public Result<Object> timeYearMonthDay(@RequestParam int year, @RequestParam int month, @RequestParam int day) {
        long startTime = System.currentTimeMillis();
        int data = timeService.searchMoviesByYMD(year, month, day);
        List<Long> modelTimes = new ArrayList<>();
        List<String> modelLogs = new ArrayList<>();
        modelTimes.add(0L);
        modelLogs.add("");
        modelTimes.add(0L);
        modelLogs.add("");
        modelTimes.add(System.currentTimeMillis() - startTime);
        modelLogs.add("MATCH (m:Movie) WHERE m.release_time contains '" + year + "/" + month + "/" + day + "' RETURN count(m);");
        return ResultResponse.success(data, modelTimes, modelLogs);
    }

    @Operation(summary = "年季")
    @RequestMapping(value = "year-season", method = RequestMethod.GET)
    public Result<Object> timeYearSeason(@RequestParam int year, @RequestParam String season) {
        long startTime = System.currentTimeMillis();
        int data = timeService.searchMoviesByYS(year, season);
        List<Long> modelTimes = new ArrayList<>();
        List<String> modelLogs = new ArrayList<>();
        modelTimes.add(0L);
        modelLogs.add("");
        modelTimes.add(0L);
        modelLogs.add("");
        modelTimes.add(System.currentTimeMillis() - startTime);
        modelLogs.add("MATCH (m:Movie) WHERE m.release_time contains '" + year + "/" + "1-3 or 4-6 or 7-9 or 10-12" + "' RETURN count(m);");
        return ResultResponse.success(data, modelTimes, modelLogs);
    }
}
