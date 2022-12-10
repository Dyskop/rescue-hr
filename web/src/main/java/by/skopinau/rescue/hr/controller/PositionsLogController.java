package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.entity.PositionsLog;
import by.skopinau.rescue.hr.service.PositionsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static by.skopinau.rescue.hr.config.WebConfig.PAGE_SIZE;

@Controller
public class PositionsLogController {
    @Autowired
    private PositionsLogService plService;

    // todo: defaultValue the last page
    @GetMapping("/position-logs")
    public String showPositionsLog(@RequestParam(defaultValue = "1") int page, Model model) {
        List<PositionsLog> pl = plService.findAllPageable(page - 1, PAGE_SIZE);

        model.addAttribute("page", page);
        model.addAttribute("positionLogs", pl);

        return "positions-log";
    }
}
