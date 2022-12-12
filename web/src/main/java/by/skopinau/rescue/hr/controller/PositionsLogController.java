package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.entity.PositionsLog;
import by.skopinau.rescue.hr.service.PositionsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PositionsLogController {
    @Autowired
    private PositionsLogService plService;

    // todo: defaultValue the last page
    @GetMapping("/position-logs")
    public String showPositionsLog(@RequestParam(defaultValue = "1") int page, Model model) {
        List<PositionsLog> pl = plService.findAllPageable(page - 1);
        boolean pagination = plService.showPagination();
        int total = plService.getTotalPages();

        model.addAttribute("page", page);
        model.addAttribute("positionLogs", pl);
        model.addAttribute("pagination", pagination);
        model.addAttribute("view", "positions-log");
        model.addAttribute("total", total);

        return "positions-log";
    }
}
